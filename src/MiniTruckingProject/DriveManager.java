package MiniTruckingProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class DriveManager {
    private static final String FILE_NAME = "drivers.json";
    private static final Scanner scanner = new Scanner(System.in);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        List<TruckDriver> driverList = new ArrayList<>();

        while(true) {
            System.out.println("\n1. Add driver.. ");
            System.out.println("2. Show All Drivers..");
            System.out.println("3. Save Drivers to JSON..");
            System.out.println("4. Load Drivers from JSON..");
            System.out.println("0. Exit..");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    driverList.add(addDriver());
                    break;
                case 2:
                    showDrivers(driverList);
                    break;
                case 3:
                    saveToJson(driverList);
                    break;
                case 4:
                    driverList = loadFromJson();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice...");
            }
        }
    }

    private static TruckDriver addDriver() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter truck number: ");
        String truckNumber = scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        return new TruckDriver(name, truckNumber, location);
    }

    private static void showDrivers(List<TruckDriver> drivers) {
        if (drivers.isEmpty()) {
            System.out.println("No drivers found.");
        } else {
            for (TruckDriver d : drivers) {
                System.out.println(d.getName() + " | " + d.getTruckNumber() + " | " + d.getLocation());
            }
        }
    }

    private static void saveToJson(List<TruckDriver> drivers) {
        try {
            mapper.writeValue(new File(FILE_NAME), drivers);
            System.out.println("✅ Drivers saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("❌ Error saving file: " + e.getMessage());
        }
    }

    private static List<TruckDriver> loadFromJson() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No file to load.");
                return new ArrayList<>();
            }

            List<TruckDriver> drivers = mapper.readValue(file, new TypeReference<List<TruckDriver>>() {});
            System.out.println("✅ Loaded drivers from " + FILE_NAME);
            return drivers;
        } catch (IOException e) {
            System.out.println("❌ Error loading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
