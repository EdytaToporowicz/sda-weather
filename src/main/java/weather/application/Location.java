package weather.application;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Location {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cityName;
    private double latitude;       //szer.geog
    private double longitude;      //dług.geog
    private String regionName;
    private String countryName;

    public Location(String cityName, int latitude, int longitude, String regionName, String countryName) {
    }
}
