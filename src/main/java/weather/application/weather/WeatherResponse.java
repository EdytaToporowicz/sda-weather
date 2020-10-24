package weather.application.weather;

import lombok.Data;

@Data
public class WeatherResponse {
    // w resources/example_response.json wkleiłem strukturę otrzymanego JSON'a - są tam zagnieżdżone obiekty
    // struktura JSON'a musi odpowiadać tej klasie

    private WeatherCoordinates coord;   //typ nazwa dowolna, a nazwa jak w json
    private Current main;
    private Wind wind;
    private WeatherCountry sys;
    private String name;    //nazwa miasta
}
