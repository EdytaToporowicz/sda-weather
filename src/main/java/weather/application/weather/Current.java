package weather.application.weather;

import lombok.Data;

@Data
public class Current {       // ta klasa może być zdefiniowana w sobnym pliku np. Current.java

    private String temperature;
    private String pressure;
    private String humidity;
    private String wind_dir;
    private String wind_speed;
}
