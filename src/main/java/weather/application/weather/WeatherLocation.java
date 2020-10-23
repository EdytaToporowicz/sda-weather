package weather.application.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
public class WeatherLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String region;
    private String lat;
    private String lon;
    private LocalDate localtime;    //nazwa jak w json?

    public WeatherLocation(String name, String country, String region, String lat, String lon, LocalDate localtime) {
        this.name = name;
        this.country = country;
        this.region = region;
        this.lat = lat;
        this.lon = lon;
        this.localtime = localtime;
    }
}
