package weather.application.weather;

import lombok.Data;

@Data
public class WeatherCity {
    private String name;
    private WeatherCoordinates coord;
    private String country;



    }

