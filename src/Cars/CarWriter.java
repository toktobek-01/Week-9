package Cars;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class CarWriter {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "White", 2012);
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("car.json"), car);
            System.out.println("Vehicle saved to car.json");
        } catch (IOException e) {
            System.out.println("Error in saving a vehicle..." + e.getMessage());
        }
    }
}
