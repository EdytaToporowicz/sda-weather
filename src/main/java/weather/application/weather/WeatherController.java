package weather.application.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.application.exceptions.InternalServerException;

import java.util.List;

public class WeatherController {  //warstwa prezentacji
    private final WeatherService weatherService = new WeatherService();
    private final ObjectMapper objectMapper = new ObjectMapper();   //Jackson - żeby dane jako plik json a nie String

    public String getWeatherParameters(String cityName, int latitude, int longitude, String weatherDate) {
        WeatherParameters weatherParameters = weatherService.addWeatherParameters(cityName, latitude, longitude, weatherDate);
        try {
            return objectMapper.writeValueAsString(weatherParameters);   //Jackson - zamiana obiektu javovego 'location' na Stringa, w którym będzie json
        } catch (JsonProcessingException e) {
            throw new InternalServerException("Błąd dodawania parametrów pogody.");
        }
    }


    public String addWeatherResponse(String temperature,String atmoatmosphericPressure, String humidity, String windDirection, String windSpeed) {
        WeatherResponse weatherResponse=weatherService.addWeatherResponse(temperature,atmoatmosphericPressure,humidity,windDirection,windSpeed);
        try {
            return objectMapper.writeValueAsString(weatherResponse);   //Jackson - zamiana obiektu javovego 'location' na Stringa, w którym będzie json
        } catch (JsonProcessingException e) {
            throw new InternalServerException("Błąd dodawania danych pogodowych.");
        }
    }
}
