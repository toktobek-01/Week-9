package Cars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CarManager {
    private static final String FILE_NAME = "cars.json";
    private static final Scanner scanner = new Scanner(System.in);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add a car.");
            System.out.println("2. Show all cars.");
            System.out.println("3. Save cars to JSON.");
            System.out.println("4. Load all cars from JSON.");
            System.out.println("0. Exit.");
            System.out.print("CHOOSE OPTION: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    carList.add(addCar());
                    break;
                case 2:
                    showCars(carList);
                    break;
                case 3:
                    saveToJson(carList);
                    break;
                case 4:
                    carList = loadFromJson();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option choice...");
            }
        }
    }

    private static Car addCar() {
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter car color: ");
        String color = scanner.nextLine();

        System.out.print("Enter car made year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        return new Car(model, color, year);
    }

    private static void showCars(List<Car> carList) {
        if (carList.isEmpty()) {
            System.out.println("No cars found.");
        } else {
            for (Car c : carList) {
                System.out.println(c.getModel() + " | " + c.getColor() + " | " + c.getYear());
            }
        }
    }

    private static void saveToJson(List<Car> carList) {
        try {
            mapper.writeValue(new File(FILE_NAME), carList);
            System.out.println("✅ Cars saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("❌ Error saving file: " + e.getMessage());
        }
    }

    private static List<Car> loadFromJson() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No file to load.");
                return new ArrayList<>();
            }

            List<Car> carsList = mapper.readValue(file, new TypeReference<List<Car>>() {});
            System.out.println("✅ Loaded " + carsList.size() + " cars from " + FILE_NAME);
            return carsList;
        } catch (IOException e) {
            System.out.println("❌ Error loading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
