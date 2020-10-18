package weather.application;

import lombok.Data;
import lombok.Getter;
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
    private String cityName;
    private double latitude;       //szer.geog
    private double longitude;      //dług.geog
    private String regionName;
    private String countryName;

    public Location(String cityName, double latitude, double longitude, String regionName, String countryName) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.regionName = regionName;
        this.countryName = countryName;
    }
}
