package weather.application.weather;

public class WeatherMapper {

    public Weather mapToWeather(WeatherResponse weatherResponse) {
        WeatherCoordinates coord = weatherResponse.getCoord();
        Current main = weatherResponse.getMain();
        Wind wind = weatherResponse.getWind();
        WeatherCountry sys = weatherResponse.getSys();
        String name = weatherResponse.getName();


        return new Weather(name,
                (int) coord.getLat(),
                (int) coord.getLon(),
                main.getTemp(),
                main.getPressure(),
                main.getHumidity(),
                wind.getDeg(),
                wind.getSpeed(),
                "");//brak daty w json // todo finish it
    }
}
