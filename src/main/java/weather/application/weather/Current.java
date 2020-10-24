package weather.application.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Current {       // ta klasa może być zdefiniowana w sobnym pliku np. Current.java

    private String temperature;
    private String pressure;
    private String humidity;
    private String wind_dir;
    private String wind_speed;
}
