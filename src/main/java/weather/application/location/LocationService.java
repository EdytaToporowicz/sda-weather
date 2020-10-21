package weather.application.location;

import weather.application.exceptions.BadRequestException;

import java.util.List;

public class LocationService {  //warstwa logiki biznesowej

    private final LocationRepository locationRepository = new LocationRepository();

    public Location addNewLocation(String cityName, int latitude, int longitude, String regionName, String countryName) {
        if (cityName == null || cityName.isBlank()) {
            throw new BadRequestException("Miasto nie może być puste.");
        }
        if (latitude < -90 || latitude > 90) {
            throw new BadRequestException("Niepoprawna szerokość.");
        }
        if (longitude < -180 || longitude > 180) {
            throw new BadRequestException("Niepoprawna długość.");
        }
        if (countryName == null || countryName.isBlank()) {
            throw new BadRequestException("Państwo nie może być puste.");
        }
        Location location = new Location(cityName, latitude, longitude, regionName, countryName);

        return locationRepository.saveNewLocation(location);
    }

    public List<Location> showSavedLocations() {
        return locationRepository.readAllLocationsSaved();
    }

}
