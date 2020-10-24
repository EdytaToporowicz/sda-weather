package weather.application.weather;

import lombok.Data;

@Data
public class WeatherLocation {

    private String name;
    private String country;
    private String region;
    private float lat;
    private float lon;
    private String localtime;    //nazwa jak w json?
}
