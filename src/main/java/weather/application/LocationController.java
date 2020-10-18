package weather.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class LocationController {   //warstwa prezentacji

    private final LocationService locationService = new LocationService();
    private final ObjectMapper objectMapper = new ObjectMapper();   //Jackson - żeby dane jako plik json a nie String

    public String addLocation(String cityName, int latitude, int longitude, String regionName, String countryName) {
        Location location = locationService.addNewLocation(cityName, latitude, longitude, regionName, countryName); //obiekt javovy z danymi
//        return location.toString();
        try {
            return objectMapper.writeValueAsString(location);   //Jackson - zamiana obiektu javovego 'location' na Stringa, w którym będzie json
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Błąd dodawania lokalizacji.");
        }
    }

    public String readAllLocations() {
        List<Location> locations = locationService.readAllLocationsSaved();
//        return locations.toString();
        try {
            return objectMapper.writeValueAsString(locations);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Błąd odczytywania lokalizacji.");
        }
    }

    public String getCurrentWeather() {
        String weatherNow = locationService.getCurrentWeatherNow();
        try {
            return objectMapper.writeValueAsString(weatherNow);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Błąd pobierania pogody.");
        }
    }
}
