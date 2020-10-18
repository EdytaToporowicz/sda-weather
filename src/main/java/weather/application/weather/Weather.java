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
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double temperature;
    private int atmosphericPressure;
    private String humidity;
    private String windDirection;
    private String windSpeed;

    public Weather(double temperature, int atmosphericPressure, String humidity, String windDirection, String windSpeed) {
        this.temperature = temperature;
        this.atmosphericPressure = atmosphericPressure;
        this.humidity = humidity;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }
}


