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
    private final String ACCESS_KEY = "036e872c7948b453473b70c5635fe4f7";

    public WeatherService() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.findAndRegisterModules();

    }

    public WeatherParameters addWeatherParameters(String cityName, int latitude, int longitude, String weatherDate) {
        LocalDate weatherDateFromString;
        if (weatherDate == null || weatherDate.isEmpty()) {  //data jutrzejsza
            weatherDateFromString = LocalDate.now().plusDays(1);
        } else {
            weatherDateFromString = LocalDate.parse(weatherDate);
        }

        if (latitude < -90 || latitude > 90) {
            throw new BadRequestException("Niepoprawna szerokość.");
        }

        if (longitude < -90 || longitude > 90) {
            throw new BadRequestException("Niepoprawna długość.");
        }

        WeatherParameters weatherParameters = new WeatherParameters(cityName, latitude, longitude, weatherDateFromString);

        return weatherRepository.saveWeatherParameters(weatherParameters);
    }

    public WeatherResponse getWeatherResponse(String cityName) {
        // todo: use external service eg. https://weatherstack.com/documentation
        // todo: create WeatherResponse as a container for new data
        // todo: WeatherResponse -> Weather
        // todo: save new data of weather to repository

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://api.weatherstack.com/current?access_key=" + ACCESS_KEY + "&query=" + cityName))
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();

            WeatherResponse weatherResponse = objectMapper.readValue(responseBody, WeatherResponse.class);  //odpowiedź w Stringu i na jaką klasę ma być zmapowany
            String temperatureResponse = weatherResponse.getTemperature();
            String atmosphericPressureResponse = weatherResponse.getAtmosphericPressure();
            String humidityResponse = weatherResponse.getHumidity();
            String windDirectionResponse = weatherResponse.getWindDirection();
            String windSpeedResponse = weatherResponse.getWindSpeed();

            return new WeatherResponse(temperatureResponse, atmosphericPressureResponse, humidityResponse, windDirectionResponse, windSpeedResponse);

        } catch (Exception e) {
            throw new BadGatewayException("Nieudana próba pobrania pogody z serwisu: " + e.getMessage());
        }

    }

}
