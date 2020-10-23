package weather.application.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class WeatherRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String query;
    private int lat;
    private int lon;
    private LocalDate localtime;//    @Temporal(TemporalType.DATE)  dodajemy tylko dla klas starego typu np. java.util.Date, java.util.Calendar

    public WeatherRequest(String query, int lat, int lon, LocalDate localtime) {
        this.query = query;
        this.lat = lat;
        this.lon = lon;
        this.localtime = localtime;
    }
}



