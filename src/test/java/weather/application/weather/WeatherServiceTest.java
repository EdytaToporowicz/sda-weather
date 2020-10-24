package weather.application.weather;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {
    WeatherService weatherService = new WeatherService();


    @Test
    void addWeatherParameters_shouldReturnNewWeatherParameters() {
        //when
        Weather weatherRequest = weatherService.getWeather("London", 0, 0, "2020-10-25");
        //then
        assertEquals(weatherRequest.getCityName(), "miasto");
        assertEquals(weatherRequest.getLat(), 0);
        assertEquals(weatherRequest.getLon(), 0);
        assertEquals(weatherRequest.getLocaltime(), "2020-10-25");
    }

    @Test
    void addWeatherParameters_whenDateIsEmpty_shouldReturnNewWeatherParameters() {
        //when
        Weather weatherRequest = weatherService.getWeather("London", 0, 0, "2020-10-25");
        //then
        assertEquals(weatherRequest.getCityName(), "miasto");
        assertEquals(weatherRequest.getLat(), 0);
        assertEquals(weatherRequest.getLon(), 0);
        assertEquals(weatherRequest.getLocaltime(), "2020-10-26");
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
    void getWeatherResponseByCity_returnNewWeatherResponse() {
        // when
        WeatherResponse response = weatherService.getWeatherResponseByCity("London");

        // then
        WeatherCoordinates coord = response.getCoord();
        assertTrue(coord.getLat() > -90);
        assertTrue(coord.getLat() < 90);
        assertTrue(coord.getLon() > -180);
        assertTrue(coord.getLon() < 180);

        Current main = response.getMain();
        assertFalse(main.getTemp().isBlank());
        assertFalse(main.getPressure().isBlank());
        assertFalse(main.getHumidity().isBlank());

        Wind wind = response.getWind();
        assertFalse(wind.getDeg().isBlank());
        assertFalse(wind.getSpeed().isBlank());

        WeatherCountry sys = response.getSys();
        assertEquals(sys.getCountry(), "GB");

        assertEquals(response.getName(), "London");

    }

    @Test
    void getWeatherResponseByLatLon_returnNewWeatherResponse() {
        // when
        WeatherResponse response = weatherService.getWeatherResponseByLatLon(0, 0);

        // then
        WeatherCoordinates coord = response.getCoord();
        assertTrue(coord.getLat() > -90);
        assertTrue(coord.getLat() < 90);
        assertTrue(coord.getLon() > -180);
        assertTrue(coord.getLon() < 180);

        Current main = response.getMain();
        assertFalse(main.getTemp().isBlank());
        assertFalse(main.getPressure().isBlank());
        assertFalse(main.getHumidity().isBlank());

        Wind wind = response.getWind();
        assertFalse(wind.getDeg().isBlank());
        assertFalse(wind.getSpeed().isBlank());

        WeatherCountry sys = response.getSys();
        assertEquals(sys.getCountry(), "GB");


        assertEquals(response.getName(), "London");
    }


}
