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
        Current current = response.getCurrent();
        assertFalse(current.getHumidity().isBlank());
        assertFalse(current.getPressure().isBlank());
        assertFalse(current.getTemperature().isBlank());
        assertFalse(current.getWind_dir().isBlank());
        assertFalse(current.getWind_speed().isBlank());

        WeatherLocation location = response.getLocation();
        assertFalse(location.getCountry().isBlank());
        assertTrue(location.getLat() > -90);
        assertTrue(location.getLat() < 90);
        assertTrue(location.getLon() > -180);
        assertTrue(location.getLon() < 180);
        assertFalse(location.getLocaltime().isBlank());
        assertFalse(location.getRegion().isBlank());
    }

    @Test
    void getWeatherResponseByLatLon_returnNewWeatherResponse(){
        // when
        WeatherResponse response = weatherService.getWeatherResponseByLatLon(20, 20);

        // then
        Current current = response.getCurrent();
        assertFalse(current.getHumidity().isBlank());
        assertFalse(current.getPressure().isBlank());
        assertFalse(current.getTemperature().isBlank());
        assertFalse(current.getWind_dir().isBlank());
        assertFalse(current.getWind_speed().isBlank());

        WeatherLocation location = response.getLocation();
        assertFalse(location.getCountry().isBlank());
        assertTrue(location.getLat() > -90);
        assertTrue(location.getLat() < 90);
        assertTrue(location.getLon() > -180);
        assertTrue(location.getLon() < 180);
        assertFalse(location.getLocaltime().isBlank());
        assertFalse(location.getRegion().isBlank());
    }


}
