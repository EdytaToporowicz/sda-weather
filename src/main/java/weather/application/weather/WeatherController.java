package weather.application.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.application.exceptions.InternalServerException;

public class WeatherController {  //warstwa prezentacji
    private final WeatherService weatherService = new WeatherService();
    private final ObjectMapper objectMapper = new ObjectMapper();   //Jackson - żeby dane jako plik json a nie String

    public String getWeatherParameters(String name, int lat, int lon, String localtime) {
        WeatherRequest weatherParametersRequest = weatherService.getWeatherParameters(name, lat, lon, localtime);
        try {
            return objectMapper.writeValueAsString(weatherParametersRequest);   //Jackson - zamiana obiektu javovego 'location' na Stringa, w którym będzie json
        } catch (JsonProcessingException e) {
            throw new InternalServerException("Błąd rządania.");
        }
    }


    public String getWeatherResponse() {
        WeatherResponse weatherResponse = weatherService.getWeatherResponse();
        try {
            return objectMapper.writeValueAsString(weatherResponse);   //Jackson - zamiana obiektu javovego 'location' na Stringa, w którym będzie json
        } catch (JsonProcessingException e) {
            throw new InternalServerException("Błąd pobierania danych pogodowych.");
        }
    }
}
