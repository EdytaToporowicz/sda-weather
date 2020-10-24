package weather.application.weather;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {
    WeatherService weatherService = new WeatherService();


    @Test
    void getWeather_shouldReturnNewWeatherParameters() {
        //when
        Weather weatherRequest = weatherService.getWeather("miasto",50.1f, 50.1f,"2020-10-25");
        //then
        assertEquals(weatherRequest.getCityName(), "miasto");
        assertEquals(weatherRequest.getLat(), 50.1f);
        assertEquals(weatherRequest.getLon(), 50.1f);
        assertEquals(weatherRequest.getLocaltime(), "2020-10-25");
    }

    @Test
    void getWeather_whenDateIsEmpty_shouldReturnNewWeatherParameters() {
        //when
        Weather weatherRequest = weatherService.getWeather("London", 50.1f, 50.1f, "2020-10-25");
        //then
        assertEquals(weatherRequest.getCityName(), "miasto");
        assertEquals(weatherRequest.getLat(), 50.1f);
        assertEquals(weatherRequest.getLon(), 50.1f);
        assertEquals(weatherRequest.getLocaltime(), "2020-10-26");
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
