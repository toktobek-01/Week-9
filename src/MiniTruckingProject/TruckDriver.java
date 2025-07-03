package MiniTruckingProject;
import java.io.IOException;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TruckDriver {
    private String name;
    private String truckNumber;
    private String location;

    public TruckDriver() {
    }

    public TruckDriver(String name, String truckNumber, String location) {
        this.name = name;
        this.truckNumber = truckNumber;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
