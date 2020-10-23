package weather.application.location;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int lat;        //szer.geog
    private int lon;        //dług.geog
    private String region;
    private String country;

    public Location(String name, int lat, int lon, String region, String country) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.region = region;
        this.country = country;
    }
}
