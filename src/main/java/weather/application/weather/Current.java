package weather.application.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Current {       // ta klasa może być zdefiniowana w sobnym pliku np. Current.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String temperature;
    private String pressure;
    private String humidity;
    private String wind_dir;
    private String wind_speed;

    public Current(String temperature, String pressure, String humidity, String wind_dir, String wind_speed) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind_dir = wind_dir;
        this.wind_speed = wind_speed;
    }
}
