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
public class Weather {  // obiekt domenowy, czyli taki który wykorzystujemy w naszym kodzie i zapisujemy do bazy danych

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;
    private int lat;
    private int lon;
    private String temperature;
    private String pressure;
    private String humidity;
    private String windDir;
    private String windSpeed;

    public Weather(String cityName, int lat, int lon, String temperature, String pressure, String humidity, String windDir, String windSpeed) {
        this.cityName = cityName;
        this.lat = lat;
        this.lon = lon;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windDir = windDir;
        this.windSpeed = windSpeed;
    }
}
