package weather.application.weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.application.exceptions.BadGatewayException;
import weather.application.exceptions.BadRequestException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherService {   // warstwa logiki biznesowej

    private final WeatherRepository weatherRepository = new WeatherRepository();
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String ACCESS_KEY = "036e872c7948b453473b70c5635fe4f7";

    public WeatherService() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.findAndRegisterModules();
    }

    public Weather getWeather(String name, int lat, int lon, String localtime) {

        if (lat < -90 || lat > 90) {
            throw new BadRequestException("Niepoprawna szerokość.");
        }

        if (lon < -180 || lon > 180) {
            throw new BadRequestException("Niepoprawna długość.");
        }

        // todo use - data about the localization -> getWeatherResponse(cityName) -> WeatherResponse
        WeatherResponse weatherResponseFromCityName = getWeatherResponseByCity(name);
        WeatherResponse weatherResponseFromLatLon = getWeatherResponseByLatLon(lat, lon);

        // todo: WeatherResponse -> Weather
        // new Weather(weatherResponse.getWeatherLocation().getName(), weatherResponse.getWeatherLocation().getLon() ...)

        Weather weather = new Weather(weatherResponseFromCityName.getLocation().getName(),
                weatherResponseFromCityName.getLocation().getLat(),
                weatherResponseFromCityName.getLocation().getLon(),
                weatherResponseFromCityName.getCurrent().getTemperature(),
                weatherResponseFromCityName.getCurrent().getPressure(),
                weatherResponseFromCityName.getCurrent().getHumidity(),
                weatherResponseFromCityName.getCurrent().getWind_dir(),
                weatherResponseFromCityName.getCurrent().getWind_speed(),
                weatherResponseFromCityName.getLocation().getLocaltime());

        Weather weather1 = new Weather(weatherResponseFromLatLon.getLocation().getName(),   //???
                weatherResponseFromLatLon.getLocation().getLat(),
                weatherResponseFromLatLon.getLocation().getLon(),
                weatherResponseFromLatLon.getCurrent().getTemperature(),
                weatherResponseFromLatLon.getCurrent().getPressure(),
                weatherResponseFromLatLon.getCurrent().getHumidity(),
                weatherResponseFromLatLon.getCurrent().getWind_dir(),
                weatherResponseFromLatLon.getCurrent().getWind_speed(),
                weatherResponseFromLatLon.getLocation().getLocaltime());
        // todo: save new data of weather to repository (Weather type)

        // todo return a Weather object
        return weatherRepository.saveWeather(weather);
    }

    // todo move to WeatherForecastClient.java (optional)
    public WeatherResponse getWeatherResponseByCity(String cityName) {    //gdy poda miasto
        // todo: use external service eg. https://weatherstack.com/documentation
        // todo: create WeatherResponse as a container for new data (JSON -> object)

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://api.weatherstack.com/current?access_key=" + ACCESS_KEY + "&query=" + cityName))
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();
            WeatherResponse weatherResponse = objectMapper.readValue(responseBody, WeatherResponse.class);
            return weatherResponse;
        } catch (Exception e) {
            throw new BadGatewayException("Nieudana próba pobrania pogody z serwisu: " + e.getMessage());
        }
    }

    public WeatherResponse getWeatherResponseByLatLon(int lat, int lon) {   //gdy poda lat i lon
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://api.weatherstack.com/current?access_key=" + ACCESS_KEY + "&query=" + lat + "," + lon))  //czy dobre zapytanie?
                .build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();
            WeatherResponse weatherResponse = objectMapper.readValue(responseBody, WeatherResponse.class);
            return weatherResponse;
        } catch (Exception e) {
            throw new BadGatewayException("Nieudana próba pobrania pogody z serwisu: " + e.getMessage());
        }
    }

}
