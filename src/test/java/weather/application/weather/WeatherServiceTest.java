package weather.application.weather;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherServiceTest {
    WeatherService weatherService = new WeatherService();


    @Test
    void addWeatherParameters_shouldReturnNewWeatherParameters() {
        //when
        Weather weatherRequest = weatherService.getWeather("London",0,0,"2020-10-25");
        //then
        assertEquals(weatherRequest.getCityName(), "miasto");
        assertEquals(weatherRequest.getLat(), 0);
        assertEquals(weatherRequest.getLon(), 0);
        assertEquals(weatherRequest.getLocaltime(),"2020-10-25");
    }

    @Test
    void addWeatherParameters_whenDateIsEmpty_shouldReturnNewWeatherParameters() {
        //when
        Weather weatherRequest = weatherService.getWeather("London",0,0,"2020-10-25");
        //then
        assertEquals(weatherRequest.getCityName(), "miasto");
        assertEquals(weatherRequest.getLat(), 0);
        assertEquals(weatherRequest.getLon(), 0);
        assertEquals(weatherRequest.getLocaltime(),"2020-10-26");
    }
//    @Test   //jak sprawdzić gdy lat puste
//    void addWeatherParameters_whenLatitudeIsEmpty_shouldReturnNewWeatherParameters(){
//
//
//    }

    //    @Test   //jak sprawdzić gdy lon puste
//    void addWeatherParameters_whenLongitudeIsEmpty_shouldReturnNewWeatherParameters(){
//
//
//    }
    @Test
    void savedNewWeatherResponse_returnNewWeatherResponse() {
        //when
        WeatherResponse weatherResponse = weatherService.getWeatherResponseByCity("London");


        //then
        System.out.println(weatherResponse);
    }
}
