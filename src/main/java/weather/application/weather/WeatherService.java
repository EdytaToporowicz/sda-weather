package weather.application.weather;

public class WeatherService {   // warstwa logiki biznesowej

    private final WeatherRepository weatherRepository = new WeatherRepository();

    public Weather showWeatherInfo(String cityName) {
        // todo: use external service eg. https://weatherstack.com/documentation
        // todo: create WeatherResponse as a container for new data
        // todo: WeatherResponse -> Weather
        // todo: save new data of weather to repository
        return new Weather();
    }
}
