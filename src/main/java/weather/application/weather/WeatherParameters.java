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
    private int latitude;
    private int longitude;
//    @Temporal(TemporalType.DATE)  dodajemy tylko dla klas starego typu np. java.util.Date, java.util.Calendar
    private LocalDate weatherDate;

    public WeatherParameters(String cityName, int latitude, int longitude, LocalDate weatherDate) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weatherDate = weatherDate;
    }
}



