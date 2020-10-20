package weather.application.weather;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherController {  //warstwa prezentacji
    private final WeatherService weatherService = new WeatherService();
    private final ObjectMapper objectMapper = new ObjectMapper();   //Jackson - żeby dane jako plik json a nie String

    public void getWeatherParameters(String cityName, int latitude, int longitude, String weatherDate) {
    }

    public void getWeatherResponse(String temperature, String atmosphericPressure, String humidity, String windDirection, String windSpeed) {
    }
}
