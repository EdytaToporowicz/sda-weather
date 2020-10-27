package weather.application.weather;

import java.util.List;

public class WeatherMapper {

    public Weather mapToWeather(WeatherResponse weatherResponse) {
        List<WeatherParameters> list = weatherResponse.getList();
        WeatherCity city = weatherResponse.getCity();


        return new Weather(city.getName(),
                city.getCoord().getLat(),
                city.getCoord().getLon(),
                list.get(0).getMain().getTemp(),
                list.get(0).getMain().getPressure(),
                list.get(0).getMain().getHumidity(),
                list.get(0).getWind().getDeg(),
                list.get(0).getWind().getSpeed(),
                list.get(0).getDt_txt()
        );
    }
}
