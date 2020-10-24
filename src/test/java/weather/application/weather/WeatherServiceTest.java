package weather.application.weather;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherServiceTest {
    WeatherService weatherService = new WeatherService();


    @Test
    void addWeatherParameters_shouldReturnNewWeatherParameters() {
        //when
        Weather weatherRequest = weatherService.getWeatherParameters("miasto", 0, 0, "2020-10-25");
        //then
//        assertEquals(weatherRequest.getQuery(), "miasto");
//        assertEquals(weatherRequest.get, 0);
//        assertEquals(weatherRequest.getLongitude(), 0);
//        assertEquals(weatherRequest.getWeatherDate(), LocalDate.parse("2020-10-25"));
    }

    @Test
    void addWeatherParameters_whenDateIsEmpty_shouldReturnNewWeatherParameters() {
        //when
        Weather weather = weatherService.getWeatherParameters("city", 0, 0, "");
        //then
//        assertEquals(weatherRequest.getQuery(), "city");
//        assertEquals(weatherRequest.getLatitude(), 0);
//        assertEquals(weatherRequest.getLongitude(), 0);
//        assertEquals(weatherRequest.getWeatherDate(), LocalDate.now().plusDays(1));
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
        WeatherResponse weatherResponse = weatherService.getWeatherResponse("London");

        //then
        System.out.println(weatherResponse);
    }
}
