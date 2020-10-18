package weather.application;

import java.util.List;

public class LocationService {//warstwa logiki biznesowej

    LocationRepository locationRepository=new LocationRepository();


    public Location addNewLocation(String cityName, int latitude, int longitude, String regionName, String countryName) {
        //in progress......

    }

    public List<Location> readAllLocationsSaved() {
        //in progress......
    }
}
