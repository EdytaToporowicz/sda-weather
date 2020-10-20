package weather.application.weather;

import weather.application.exceptions.BadRequestException;

import java.time.LocalDate;

public class WeatherService {   // warstwa logiki biznesowej

    private final WeatherRepository weatherRepository = new WeatherRepository();

    public WeatherResponse getWeather(String temperature, String atmosphericPressure, String humidity, String windDirection, String windSpeed) {
        // todo: use external service eg. https://weatherstack.com/documentation
        // todo: create WeatherResponse as a container for new data
        // todo: WeatherResponse -> Weather
        // todo: save new data of weather to repository




        return new WeatherResponse();
    }

    public WeatherParameters getWeatherParameters(String cityName, double latitude, double longitude, String weatherDate) {
        if (cityName == null || cityName.isBlank()) {
            throw new BadRequestException("Miasto nie może być puste.");
        }
        if (latitude < -90 || latitude > 90) {
            throw new BadRequestException("Niepoprawna szerokość.");
        }
        if (longitude < -180 || longitude > 180) {
            throw new BadRequestException("Niepoprawna długość.");
        }
        LocalDate weatherDateFromString;
        if (weatherDate == null || weatherDate.isEmpty()) {  //data jutrzejsza
            weatherDateFromString = LocalDate.now().plusDays(1);
        } else {
            weatherDate = LocalDate.parse(weatherDate);
        }
        return WeatherParameters;
    }
}
