package weather.application;

import java.util.List;

public class LocationService {//warstwa logiki biznesowej

    LocationRepository locationRepository = new LocationRepository();


    public Location addNewLocation(String cityName, int latitude, int longitude, String regionName, String countryName) {
        //in progress......

        return null;
    }

    public List<Location> readAllLocationsSaved() {
        //in progress......

        return null;
    }
}
