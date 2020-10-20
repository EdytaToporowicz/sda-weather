package weather.application.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class WeatherParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;
    private double latitude;
    private double longitude;
    @Temporal(TemporalType.DATE)
    private LocalDate weatherDate;

    public WeatherParameters(String cityName, double latitude, double longitude, LocalDate weatherDate) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weatherDate = weatherDate;
    }
}



