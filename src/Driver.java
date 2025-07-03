import java.io.IOException;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
    private String name;
    private String location;

    public Driver() {}

    public Driver(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() { return name; }
    public void getName(String name) { this.name = name; }

    public String getLocation() { return location;}
    public void setLocation() { this.location = location; }
}
