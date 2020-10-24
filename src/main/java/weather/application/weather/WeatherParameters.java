package weather.application.weather;

import lombok.Data;

@Data
public class WeatherParameters {
    private Parameters main;
    private Wind wind;
    private String dt_txt;
}
