import java.io.IOException;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeExample {
    public static void main(String[] args) {
        Driver driver = new Driver("Ali", "Dallas");
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("driver.json"), driver);

            String jsonString = mapper.writeValueAsString(driver);
            System.out.println("JSON Output: " + jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
