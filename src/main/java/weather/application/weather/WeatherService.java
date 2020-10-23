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
    private final WeatherRequest weatherRequest = new WeatherRequest();
    private final WeatherLocation weatherLocation = new WeatherLocation();
    private final Current current = new Current();
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String ACCESS_KEY = "036e872c7948b453473b70c5635fe4f7";

    public WeatherService() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.findAndRegisterModules();

    }

    public WeatherRequest getWeatherParameters(String name, int lat, int lon, String localtime) {
        LocalDate weatherDateFromString;
        if (localtime == null || localtime.isEmpty()) {
            weatherDateFromString = LocalDate.now().plusDays(1);    //data jutrzejsza
        } else {
            weatherDateFromString = LocalDate.parse(localtime);
        }

        if (lat < -90 || lat > 90) {
            throw new BadRequestException("Niepoprawna szerokość.");
        }

        if (lon < -180 || lon > 180) {
            throw new BadRequestException("Niepoprawna długość.");
        }

        WeatherRequest weatherRequest = new WeatherRequest(name, lat, lon, weatherDateFromString);

        return weatherRepository.getWeatherParameters(weatherRequest);
    }

    public WeatherResponse getWeatherResponse() {
        // todo: use external service eg. https://weatherstack.com/documentation
        // todo: create WeatherResponse as a container for new data
        // todo: WeatherResponse -> Weather     //???
        // todo: save new data of weather to repository

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://api.weatherstack.com/current?access_key=" + ACCESS_KEY + "&query=" + weatherRequest.getQuery()))
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();
            System.out.println(responseBody);

            WeatherRequest weatherRequest = objectMapper.readValue(responseBody, WeatherRequest.class);
            String weatherRequestQuery = weatherRequest.getQuery();
            int weatherRequestLat = weatherRequest.getLat();
            int weatherRequestLon = weatherRequest.getLon();
            LocalDate weatherRequestLocaltime = weatherRequest.getLocaltime();
            WeatherRequest weatherRequestResponse = new WeatherRequest(weatherRequestQuery, weatherRequestLat, weatherRequestLon, weatherRequestLocaltime);

            WeatherLocation weatherLocation = objectMapper.readValue(responseBody, WeatherLocation.class);
            String weatherLocationName = weatherLocation.getName();
            String weatherLocationCountry = weatherLocation.getCountry();
            String weatherLocationRegion = weatherLocation.getRegion();
            String weatherLocationLat = weatherLocation.getLat();
            String weatherLocationLon = weatherLocation.getLon();
            LocalDate weatherLocationLocaltime = weatherLocation.getLocaltime();
            WeatherLocation weatherLocationResponse = new WeatherLocation(weatherLocationName, weatherLocationCountry, weatherLocationRegion, weatherLocationLat, weatherLocationLon, weatherLocationLocaltime);

            Current current = objectMapper.readValue(responseBody, Current.class);
            String currentTemperatureResponse = current.getTemperature();
            String currentPressureResponse = current.getPressure();
            String currentHumidityReposnse = current.getHumidity();
            String currentWind_dirResponse = current.getWind_dir();
            String currentWind_speedResponse = current.getWind_speed();
            Current currentResponse = new Current(currentTemperatureResponse, currentPressureResponse, currentHumidityReposnse, currentWind_dirResponse, currentWind_speedResponse);

            WeatherResponse weatherResponse = objectMapper.readValue(responseBody, WeatherResponse.class);  //odpowiedź w Stringu i na jaką klasę ma być zmapowane
            WeatherResponse weatherResponse1 = new WeatherResponse(weatherRequestResponse, weatherLocationResponse, currentResponse);
            return weatherRepository.saveWeatherResponse(weatherResponse1);

        } catch (Exception e) {
            throw new BadGatewayException("Nieudana próba pobrania pogody z serwisu: " + e.getMessage());
        }
    }
}
