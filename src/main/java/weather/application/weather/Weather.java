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
    private float lat;
    private float lon;
    private String temperature;
    private String pressure;
    private String humidity;
    private String wind_dir;
    private String wind_speed;
    private String localtime;

    public Weather(String cityName, float lat, float lon, String temperature, String pressure, String humidity, String wind_dir, String wind_speed, String localtime) {
        this.cityName = cityName;
        this.lat = lat;
        this.lon = lon;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind_dir = wind_dir;
        this.wind_speed = wind_speed;
        this.localtime = localtime;
    }
}
