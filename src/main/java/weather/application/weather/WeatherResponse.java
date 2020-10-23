package weather.application.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherResponse {  // w resources/example_response.json wkleiłem strukturę otrzymanego JSON'a - są tam zagnieżdżone obiekty
    // struktura JOSN'a musi odpowiadać tej klasie

    private WeatherRequest weatherRequest;
    private WeatherLocation weatherLocation;
    private Current current;    //nazwa jak w strukturze jsona?

    public WeatherResponse(WeatherRequest weatherRequest, WeatherLocation weatherLocation, Current current) {
        this.weatherRequest = weatherRequest;
        this.weatherLocation = weatherLocation;
        this.current = current;
    }
}
