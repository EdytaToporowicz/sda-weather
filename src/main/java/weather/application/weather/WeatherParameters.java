package weather.application.weather;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity

public class WeatherParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;
    private double latitude;
    private double longitude;
    private LocalDate weatherDate;

    public WeatherParameters(String cityName, double latitude, double longitude, LocalDate weatherDate) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weatherDate = weatherDate;
    }
}



