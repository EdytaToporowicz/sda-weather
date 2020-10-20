package weather.application.weather;

import lombok.Data;

@Data

public class WeatherParameters {
    private String cityName;
    private double latitude;
    private double longitude;
    private String weatherDate;
}


