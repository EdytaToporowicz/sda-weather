package weather.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class LocationController {   //warstwa prezentacji

    private final LocationService locationService = new LocationService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String addLocation(String cityName, int latitude, int longitude, String regionName, String countryName) {
        Location location = locationService.addNewLocation(cityName, latitude, longitude, regionName, countryName);

        try {
            return objectMapper.writeValueAsString(location);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("...");
        }
    }

    public  String readAllLocations() {
        List<Location> locations = locationService.readAllLocationsSaved();
        return "";
    }
}
