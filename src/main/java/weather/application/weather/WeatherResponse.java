package weather.application.weather;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {
    // w resources/example_response.json wkleiłem strukturę otrzymanego JSON'a - są tam zagnieżdżone obiekty
    // struktura JSON'a musi odpowiadać tej klasie

    private List<WeatherParameters> list;
    private WeatherCity city;
}

