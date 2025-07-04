package Cars;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class CarReader {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Car car = mapper.readValue(new File("car.json"), Car.class);

            System.out.println("Model: " + car.getModel());
            System.out.println("Color: " + car.getColor());
            System.out.println("Year: " + car.getYear());
        } catch (IOException e) {
            System.out.println("Error in reading file..." + e.getMessage());
        }
    }
}
