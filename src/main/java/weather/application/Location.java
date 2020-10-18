package weather.application;

import lombok.Data;

@Data
public class Location {
    private String cityName;
    private double latitude;       //szer.geog
    private double longitude;      //dług.geog
    private String regionName;
    private String countryName;

    public Location(String cityName, double latitude, double longitude, String regionName, String countryName) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.regionName = regionName;
        this.countryName = countryName;
    }
}
