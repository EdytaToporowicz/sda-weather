package weather.application;

import java.util.List;

public class LocationController {   //warstwa prezentacji
    LocationService locationService = new LocationService();

    public String addLocation(String cityName, int latitude, int longitude, String regionName, String countryName) {
        Location location = locationService.addNewLocation(cityName, latitude, longitude, regionName, countryName);
        return location.toString();
    }

    public  String readAllLocations() {
        List<Location> locations = locationService.readAllLocationsSaved();
        return "";
    }


}
