import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

import java.io.IOException;

public class DeserializeExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Driver driver = mapper.readValue(new File("driver.json"), Driver.class);
            System.out.println("Driver: " + driver.getName() + ", " + driver.getLocation());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
