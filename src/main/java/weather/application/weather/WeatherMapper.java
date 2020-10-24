package weather.application.weather;

public class WeatherMapper {

    public Weather mapToWeather(WeatherResponse weatherResponse) {
        WeatherLocation location = weatherResponse.getLocation();
        Current current = weatherResponse.getCurrent();

        return new Weather(location.getName(),
                (int) location.getLat(),
                (int) location.getLon(),
                current.getTemperature(),
                current.getPressure(),
                current.getHumidity(),
                current.getWind_dir(),
                current.getWind_speed(),
                location.getLocaltime());
    }
}
