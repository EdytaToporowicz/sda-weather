package weather.application.weather;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {
    WeatherService weatherService = new WeatherService();


    @Test
    void getWeather_shouldReturnNewWeatherParameters() {
        //when
        Weather weatherRequest = weatherService.getWeather("Miasto",52.9536f, 23.1757f,"2020-10-25 03:00:00");
        //then
        assertEquals(weatherRequest.getCityName(), "Miasto");
        assertEquals(weatherRequest.getLat(), 52.9536f);
        assertEquals(weatherRequest.getLon(), 23.1757f);
        assertEquals(weatherRequest.getLocal_time(), "2020-10-25 03:00:00");
    }

    @Test
    void getWeather_whenDateIsEmpty_shouldReturnNewWeatherParameters() {
        //when
        Weather weatherRequest = weatherService.getWeather("Globe", 0, 0, "2020-10-25 03:00:00");
        //then
        assertEquals(weatherRequest.getCityName(), "Globe");
        assertEquals(weatherRequest.getLat(), 0);
        assertEquals(weatherRequest.getLon(), 0);
        assertEquals(weatherRequest.getLocal_time(), "2020-10-25 03:00:00");
    }

    @Test
    void getWeatherResponseByCity_returnNewWeatherResponse() {
        // when
        WeatherResponse response = weatherService.getWeatherResponseByCity("London","2020-10-25 00:00:00");

        // then
        List<WeatherParameters> list = response.getList();
        assertFalse(list.get(0).getMain().getTemp().isBlank());
        assertFalse(list.get(0).getMain().getPressure().isBlank());
        assertFalse(list.get(0).getMain().getHumidity().isBlank());
        assertFalse(list.get(1).getWind().getDeg().isBlank());
        assertFalse(list.get(1).getWind().getSpeed().isBlank());
        assertEquals(list.get(2).getDt_txt(), "2020-10-25 00:00:00");

        WeatherCity city = response.getCity();
        assertEquals(city.getName(), "London");
        assertTrue(city.getCoord().getLat() > -90);
        assertTrue(city.getCoord().getLat() < 90);
        assertTrue(city.getCoord().getLon() < 180);
        assertTrue(city.getCoord().getLon() > -180);
        assertEquals(city.getCountry(),"GB");

    }

    @Test
    void getWeatherResponseByLatLon_returnNewWeatherResponse() {
        // when
        WeatherResponse response = weatherService.getWeatherResponseByLatLon(0, 0,"2020-10-25 00:00:00");

        // then
        List<WeatherParameters> list = response.getList();
        assertFalse(list.get(0).getMain().getTemp().isBlank());
        assertFalse(list.get(0).getMain().getPressure().isBlank());
        assertFalse(list.get(0).getMain().getHumidity().isBlank());
        assertFalse(list.get(1).getWind().getDeg().isBlank());
        assertFalse(list.get(1).getWind().getSpeed().isBlank());
        assertEquals(list.get(2).getDt_txt(), "2020-10-25 00:00:00");

        WeatherCity city = response.getCity();
        assertEquals(city.getName(), "Globe");
        assertTrue(city.getCoord().getLat() > -90);
        assertTrue(city.getCoord().getLat() < 90);
        assertTrue(city.getCoord().getLon() < 180);
        assertTrue(city.getCoord().getLon() > -180);
        assertEquals(city.getCountry(),"");
    }


}
