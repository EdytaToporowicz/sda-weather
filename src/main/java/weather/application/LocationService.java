package weather.application;

import java.util.List;

public class LocationService {//warstwa logiki biznesowej

    private final LocationRepository locationRepository = new LocationRepository();


    public Location addNewLocation(String cityName, int latitude, int longitude, String regionName, String countryName) {

        if (cityName == null || cityName.isEmpty()                  //wpisuj, aż poprawne
                || regionName == null || regionName.isBlank()
                || countryName == null || countryName.isBlank()) {
            throw new RuntimeException("Miasto nie może być puste.");
        }
        if (latitude < -90 || latitude > 90) {
            throw new RuntimeException("Niepoprawna szerokość.");
        }
        if (longitude < -180 || longitude > 180) {
            throw new RuntimeException("Niepoprawna długość.");
        }
        Location location = new Location(cityName, latitude, longitude, regionName, countryName);
        Location savedLocation = locationRepository.saveNewLocation(location);

        return savedLocation;
    }

    public List<Location> readAllLocationsSaved() {
        return locationRepository.readAllLocationsSaved();
    }

    public String getCurrentWeatherNow() {          // ???

        return null;
    }
}
