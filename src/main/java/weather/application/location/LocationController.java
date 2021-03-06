package weather.application.location;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.application.exceptions.InternalServerException;

import java.util.List;


public class LocationController {   //warstwa prezentacji

    private final LocationService locationService = new LocationService();
    private final ObjectMapper objectMapper = new ObjectMapper();   //Jackson - żeby dane jako plik json a nie String

    public String addNewLocation(String cityName, int latitude, int longitude, String regionName, String countryName) {
        Location location = locationService.addNewLocation(cityName, latitude, longitude, regionName, countryName); //obiekt javovy z danymi
//        return location.toString();   --> zamiana na String, której nie używamy,bo trzeba metodę toString zmodyfikować (apostrofy, nawiasy,itd)
        try {
            return objectMapper.writeValueAsString(location);   //Jackson - zamiana obiektu javovego 'location' na Stringa, w którym będzie json
        } catch (JsonProcessingException e) {
            throw new InternalServerException("Błąd dodawania lokalizacji.");
        }
    }


    public String showLocations() {
        List<Location> locations = locationService.showSavedLocations();
//        return locations.toString();
        try {
            return objectMapper.writeValueAsString(locations);
        } catch (JsonProcessingException e) {
            throw new InternalServerException("Błąd odczytywania lokalizacji.");
        }
    }


}
