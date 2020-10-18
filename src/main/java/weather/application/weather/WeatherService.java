package weather.application.weather;

import java.util.List;

public class WeatherService {   //warstwa logiki biznesowej
    private final WeatherRepository weatherRepository = new WeatherRepository();

    public List<Weather> showWeatherInfo() {
        return weatherRepository.readWeatherInfoFromWWW();
    }
}
