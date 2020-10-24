package weather.application.weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.application.exceptions.BadGatewayException;
import weather.application.exceptions.BadRequestException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

public class WeatherService {   // warstwa logiki biznesowej

    private final WeatherRepository weatherRepository = new WeatherRepository();
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String ACCESS_KEY = "5d850280c7bc0a17e395eafa71ea2661";

    private final WeatherMapper weatherMapper = new WeatherMapper();

    public WeatherService() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.findAndRegisterModules();
    }

    public Weather getWeather(String cityName, float lat, float lon, String userDate) {
        if (lat < -90 || lat > 90) {
            throw new BadRequestException("Niepoprawna szerokość.");
        }
        if (lon < -180 || lon > 180) {
            throw new BadRequestException("Niepoprawna długość.");
        }

        // todo use userDate
        LocalDate localtime;
        if (userDate == null || userDate.isEmpty()) {
            localtime = LocalDate.now().plusDays(1);
        } else {
            localtime = LocalDate.parse(userDate);
        }

        WeatherResponse weatherResponse;
        if (cityName.isBlank()) {
            weatherResponse = getWeatherResponseByLatLon(lat, lon,localtime.toString());
        } else {
            weatherResponse = getWeatherResponseByCity(cityName, localtime.toString());
        }

        // todo fetch a forecast for specific date from WeatherResponse based on userDate

        Weather weather = weatherMapper.mapToWeather(weatherResponse);

        return weatherRepository.saveWeather(weather);
    }

    // todo move to WeatherForecastClient.java (optional)
    public WeatherResponse getWeatherResponseByCity(String cityName, String userDate) {    //gdy poda miasto

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid=" + ACCESS_KEY + "&units=metric"))
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

    public WeatherResponse getWeatherResponseByLatLon(float lat, float lon,String userDate) {   //gdy poda lat i lon

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&appid=" + ACCESS_KEY + "&units=metric"))
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
