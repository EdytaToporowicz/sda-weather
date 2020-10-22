package weather.application.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Weather {  // obiekt domentowy, czyli taki który wykorzystujemy w naszym kodzie i zapisujemy do bazy danych

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String temperature;
    private String atmosphericPressure;
    private String humidity;
    private String windDirection;
    private String windSpeed;

    public Weather(String temperature, String atmosphericPressure, String humidity, String windDirection, String windSpeed) {
        this.temperature = temperature;
        this.atmosphericPressure = atmosphericPressure;
        this.humidity = humidity;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }
}
