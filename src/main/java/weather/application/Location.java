package weather.application;

import lombok.Data;

@Data
public class Location {
    private String cityName;
    private double latitude;       //szer.geog
    private double longitude;      //dług.geog
    private String regionName;
    private String countryName;
}
