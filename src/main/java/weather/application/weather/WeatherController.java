package weather.application.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.application.exceptions.InternalServerException;

public class WeatherController {  //warstwa prezentacji
    private final WeatherService weatherService = new WeatherService();
    private final ObjectMapper objectMapper = new ObjectMapper();   //Jackson - żeby dane jako plik json a nie String

    public String getWeather(String name, int lat, int lon, String userDate) {
        Weather weather = weatherService.getWeather(name, lat, lon, userDate);
        try {
            return objectMapper.writeValueAsString(weather);   //Jackson - zamiana obiektu javovego 'location' na Stringa, w którym będzie json
        } catch (JsonProcessingException e) {
            throw new InternalServerException("Błąd rządania.");
        }
    }
}
