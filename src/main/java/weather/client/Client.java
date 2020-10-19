package weather.client;

import weather.application.location.LocationController;
import weather.application.weather.WeatherController;

import java.util.Scanner;

public class Client {
    private final LocationController locationController = new LocationController();
    private final WeatherController weatherController = new WeatherController();

    public void runClientInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu aplikacji WEATHER: ");

        while (true) {
            System.out.println("Wybierz, co chcesz zrobić lub 0: ");
            System.out.println("1. Dodaj lokalizację.");
            System.out.println("2. Wyświetl dodane lokalizacje.");
            System.out.println("3. Wyświetl pogodę.");
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    addLocation();
                    break;
                case 2:
                    showAllLocations();
                    break;
                case 3:
                    showWeather();
                    break;
                case 0:
                    System.out.println("Zamykam aplikację.");
                    return;
            }
        }
    }

    private void addLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj miasto: ");
        String cityName = scanner.nextLine();
        System.out.println("Podaj szerokość geograficzną (-90 -> S, 90 -> N): ");
        int latitude = scanner.nextInt();
        System.out.println("Podaj długość geograficzną (-180 -> W, 180 -> E): ");
        int longitude = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj region: ");
        String regionName = scanner.nextLine();
        System.out.println("Podaj nazwę kraju: ");
        String countryName = scanner.nextLine();

        String addedLocation = locationController.addLocation(cityName, latitude, longitude, regionName, countryName);
        System.out.println("Dodano nową lokalizację: " + addedLocation);
    }

    private void showAllLocations() {
        String allLocations = locationController.showLocations();

        allLocations = allLocations.replaceAll("\\[", "\n")
                .replaceAll("\\{", "\n")
                .replaceAll("\\}", "")
                .replaceAll("\\]", "");

        System.out.println("Twoje lokalizacje: " + allLocations);
    }

    private void showWeather() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj lokalizację dla pogody: 1-miasto / 2-wsp.geogr.: ");
        int response = scanner.nextInt();
        String cityName = null;
        switch (response) {
            case 1:
                System.out.println("Miasto: ");
                cityName = scanner.nextLine();
                break;
//            case 2:
//                System.out.println("Współrzędne - szerokość: ");
//                double latitudeCoordinates = scanner.nextDouble();
//                System.out.println("długość: ");
//                double longitudeCoordinates = scanner.nextDouble();
//                break;
        }

        System.out.println("Podaj datę (YYYY-MM-DD): ");
        String weatherDate = scanner.nextLine();
        String weather = weatherController.showWeather(cityName, weatherDate);   //
        System.out.println("Pogoda dla wybranej lokalizacji: " + weather);
    }
}

