package weather.application.weather;

import lombok.Data;

@Data
public class WeatherResponse {  // w resources/example_response.json wkleiłem strukturę otrzymanego JSON'a - są tam zagnieżdżone obiekty
    // struktura JOSN'a musi odpowiadać tej klasie

    private WeatherLocation location;
    private Current current;    //nazwa jak w strukturze jsona?

}
