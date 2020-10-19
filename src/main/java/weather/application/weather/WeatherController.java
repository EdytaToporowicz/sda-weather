package weather.application.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.application.exceptions.InternalServerException;

public class WeatherController {  //warstwa prezentacji
    private final WeatherService weatherService = new WeatherService();
    private final ObjectMapper objectMapper = new ObjectMapper();   //Jackson - żeby dane jako plik json a nie String

    public String showWeather(String cityName, String weatherDate) {
        Weather weather = weatherService.getWeather(cityName, weatherDate);

        try {
            return objectMapper.writeValueAsString(weather);
        } catch (JsonProcessingException e) {
            throw new InternalServerException("Błąd pobierania pogody.");
        }
    }
}
