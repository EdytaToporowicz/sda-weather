package weather.application.weather;

import weather.application.exceptions.BadRequestException;

import java.time.LocalDate;

public class WeatherService {   // warstwa logiki biznesowej

    private final WeatherRepository weatherRepository = new WeatherRepository();


//    public WeatherResponse getWeather(String temperature, String atmosphericPressure, String humidity, String windDirection, String windSpeed) {
//        // todo: use external service eg. https://weatherstack.com/documentation
//        // todo: create WeatherResponse as a container for new data
//        // todo: WeatherResponse -> Weather
//        // todo: save new data of weather to repository
//
//
//        return new WeatherResponse();
//    }

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
        WeatherParameters savedWeatherParameters = weatherRepository.saveWeatherParameters(weatherParameters);

        return savedWeatherParameters;
    }


    public WeatherResponse getWeatherResponse(String temperature, String atmoatmosphericPressure, String humidity, String windDirection, String windSpeed) {
        //todo: use external service eg. https://weatherstack.com/documentation
        // todo: create WeatherResponse as a container for new data
        // todo: WeatherResponse -> Weather
        // todo: save new data of weather to repository


        return new WeatherResponse();
    }
}
