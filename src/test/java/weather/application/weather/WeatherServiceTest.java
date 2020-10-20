package weather.application.weather;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WeatherServiceTest {
    private final WeatherService weatherService=new WeatherService();

    @Test
    void addWeatherParameters_shouldReturnNewWeatherParameters(){
        //when
        WeatherParameters weatherParameters=weatherService.addWeatherParameters("miasto",0,0,"2020-10-25");
        //then
        assertEquals(weatherParameters.getCityName(), "miasto");
        assertEquals(weatherParameters.getLatitude(), 0);
        assertEquals(weatherParameters.getLongitude(), 0);
        assertEquals(weatherParameters.getWeatherDate(), LocalDate.parse("2020-10-25"));
    }
    @Test
    void addWeatherParameters_whenDateIsEmpty_shouldReturnNewWeatherParameters(){
        //when
        WeatherParameters weatherParameters=weatherService.addWeatherParameters("city",0,0,"");
        //then
        assertEquals(weatherParameters.getCityName(), "city");
        assertEquals(weatherParameters.getLatitude(), 0);
        assertEquals(weatherParameters.getLongitude(), 0);
        assertEquals(weatherParameters.getWeatherDate(), LocalDate.now().plusDays(1));
    }
//    @Test   //jak sprawdzić gdy latitude puste
//    void addWeatherParameters_whenLatitudeIsEmpty_shouldReturnNewWeatherParameters(){
//
//
//    }

//    @Test   //jak sprawdzić gdy longitude puste
//    void addWeatherParameters_whenLongitudeIsEmpty_shouldReturnNewWeatherParameters(){
//
//
//    }

}
