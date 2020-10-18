package weather.application.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.application.exceptions.InternalServerException;

import java.util.List;

public class WeatherController {  //warstwa prezentacji
    private final WeatherService weatherService = new WeatherService();
    private final ObjectMapper objectMapper = new ObjectMapper();   //Jackson - żeby dane jako plik json a nie String

    public String showWeather() {
        List<Weather> weatherInfo= weatherService.showWeatherInfo();
//        return weatherInfo.toString();
        try {
            return objectMapper.writeValueAsString(weatherInfo);
        } catch (JsonProcessingException e) {
            throw new InternalServerException("Błąd pobierania pogody.");
        }
    }
}
