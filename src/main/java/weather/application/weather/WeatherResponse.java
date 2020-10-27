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

//WeatherResponse (list=[
// WeatherParameters(main=Parameters(temp=12.42, pressure=1008, humidity=63), wind=Wind(speed=4.64, deg=215), dt_txt=2020-10-27 15:00:00),
// WeatherParameters(main=Parameters(temp=10.76, pressure=1010, humidity=67), wind=Wind(speed=4.67, deg=205), dt_txt=2020-10-27 18:00:00),
// WeatherParameters(main=Parameters(temp=9.79, pressure=1010, humidity=69), wind=Wind(speed=4.99, deg=200), dt_txt=2020-10-27 21:00:00),
// WeatherParameters(main=Parameters(temp=9.42, pressure=1010, humidity=72), wind=Wind(speed=5.18, deg=190), dt_txt=2020-10-28 00:00:00),
// WeatherParameters(main=Parameters(temp=9.5, pressure=1008, humidity=70), wind=Wind(speed=5.78, deg=189), dt_txt=2020-10-28 03:00:00),
// WeatherParameters(main=Parameters(temp=9.99, pressure=1009, humidity=69), wind=Wind(speed=5.47, deg=202), dt_txt=2020-10-28 06:00:00),
// WeatherParameters(main=Parameters(temp=9.86, pressure=1009, humidity=83), wind=Wind(speed=5.15, deg=207), dt_txt=2020-10-28 09:00:00),
// WeatherParameters(main=Parameters(temp=11.27, pressure=1009, humidity=83), wind=Wind(speed=4.26, deg=224), dt_txt=2020-10-28 12:00:00),
// WeatherParameters(main=Parameters(temp=11.79, pressure=1010, humidity=79), wind=Wind(speed=3.37, deg=227), dt_txt=2020-10-28 15:00:00),
// WeatherParameters(main=Parameters(temp=11.12, pressure=1012, humidity=75), wind=Wind(speed=3.97, deg=219), dt_txt=2020-10-28 18:00:00),
// WeatherParameters(main=Parameters(temp=9.9, pressure=1012, humidity=71), wind=Wind(speed=3.89, deg=214), dt_txt=2020-10-28 21:00:00),
// WeatherParameters(main=Parameters(temp=9.88, pressure=1012, humidity=74), wind=Wind(speed=4.66, deg=209), dt_txt=2020-10-29 00:00:00),
// WeatherParameters(main=Parameters(temp=10.47, pressure=1011, humidity=80), wind=Wind(speed=5.94, deg=212), dt_txt=2020-10-29 03:00:00),
// WeatherParameters(main=Parameters(temp=10.11, pressure=1011, humidity=83), wind=Wind(speed=5.07, deg=240), dt_txt=2020-10-29 06:00:00),
// WeatherParameters(main=Parameters(temp=11.28, pressure=1012, humidity=70), wind=Wind(speed=6.48, deg=257), dt_txt=2020-10-29 09:00:00),
// WeatherParameters(main=Parameters(temp=11.86, pressure=1014, humidity=59), wind=Wind(speed=6.81, deg=268), dt_txt=2020-10-29 12:00:00),
// WeatherParameters(main=Parameters(temp=10.79, pressure=1016, humidity=64), wind=Wind(speed=5.7, deg=273), dt_txt=2020-10-29 15:00:00),
// WeatherParameters(main=Parameters(temp=9.86, pressure=1018, humidity=68), wind=Wind(speed=5.11, deg=269), dt_txt=2020-10-29 18:00:00),
// WeatherParameters(main=Parameters(temp=8.11, pressure=1020, humidity=74), wind=Wind(speed=4.32, deg=252), dt_txt=2020-10-29 21:00:00),
// WeatherParameters(main=Parameters(temp=7.7, pressure=1019, humidity=77), wind=Wind(speed=3.25, deg=225), dt_txt=2020-10-30 00:00:00),
// WeatherParameters(main=Parameters(temp=8.43, pressure=1018, humidity=85), wind=Wind(speed=3.85, deg=205), dt_txt=2020-10-30 03:00:00),
// WeatherParameters(main=Parameters(temp=9.66, pressure=1017, humidity=93), wind=Wind(speed=4.35, deg=208), dt_txt=2020-10-30 06:00:00),
// WeatherParameters(main=Parameters(temp=11.33, pressure=1017, humidity=91), wind=Wind(speed=4.92, deg=251), dt_txt=2020-10-30 09:00:00),
// WeatherParameters(main=Parameters(temp=12.17, pressure=1017, humidity=89), wind=Wind(speed=5.77, deg=262), dt_txt=2020-10-30 12:00:00),
// WeatherParameters(main=Parameters(temp=12.35, pressure=1018, humidity=88), wind=Wind(speed=5.28, deg=269), dt_txt=2020-10-30 15:00:00),
// WeatherParameters(main=Parameters(temp=12.34, pressure=1019, humidity=90), wind=Wind(speed=4.92, deg=268), dt_txt=2020-10-30 18:00:00),
// WeatherParameters(main=Parameters(temp=12.67, pressure=1020, humidity=91), wind=Wind(speed=4.44, deg=276), dt_txt=2020-10-30 21:00:00),
// WeatherParameters(main=Parameters(temp=12.64, pressure=1021, humidity=92), wind=Wind(speed=4.12, deg=270), dt_txt=2020-10-31 00:00:00),
// WeatherParameters(main=Parameters(temp=12.62, pressure=1022, humidity=92), wind=Wind(speed=3.39, deg=274), dt_txt=2020-10-31 03:00:00),
// WeatherParameters(main=Parameters(temp=12.54, pressure=1023, humidity=94), wind=Wind(speed=2.77, deg=269), dt_txt=2020-10-31 06:00:00),
// WeatherParameters(main=Parameters(temp=12.94, pressure=1023, humidity=91), wind=Wind(speed=2.21, deg=268), dt_txt=2020-10-31 09:00:00),
// WeatherParameters(main=Parameters(temp=13.75, pressure=1023, humidity=86), wind=Wind(speed=1.33, deg=224), dt_txt=2020-10-31 12:00:00),
// WeatherParameters(main=Parameters(temp=13.96, pressure=1023, humidity=86), wind=Wind(speed=2.15, deg=168), dt_txt=2020-10-31 15:00:00),
// WeatherParameters(main=Parameters(temp=12.44, pressure=1023, humidity=93), wind=Wind(speed=2.61, deg=160), dt_txt=2020-10-31 18:00:00),
// WeatherParameters(main=Parameters(temp=11.77, pressure=1023, humidity=94), wind=Wind(speed=3.2, deg=152), dt_txt=2020-10-31 21:00:00),
// WeatherParameters(main=Parameters(temp=11.19, pressure=1023, humidity=94), wind=Wind(speed=3, deg=162), dt_txt=2020-11-01 00:00:00),
// WeatherParameters(main=Parameters(temp=10.73, pressure=1022, humidity=93), wind=Wind(speed=2.57, deg=173), dt_txt=2020-11-01 03:00:00),
// WeatherParameters(main=Parameters(temp=10.24, pressure=1022, humidity=91), wind=Wind(speed=2.91, deg=185), dt_txt=2020-11-01 06:00:00),
// WeatherParameters(main=Parameters(temp=12.7, pressure=1022, humidity=78), wind=Wind(speed=3.72, deg=196), dt_txt=2020-11-01 09:00:00),
// WeatherParameters(main=Parameters(temp=15.35, pressure=1021, humidity=66), wind=Wind(speed=3.99, deg=201), dt_txt=2020-11-01 12:00:00)
// ],

// city=WeatherCity(name=Berlin, coord=WeatherCoordinates(lat=52.5244, lon=13.4105), country=DE))

