package weather.application;

public class Location {
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

    public String getCityName() {
        return cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return "Location{" +
                "cityName='" + cityName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", regionName='" + regionName + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
