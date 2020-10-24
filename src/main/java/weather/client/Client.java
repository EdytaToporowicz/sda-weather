package weather.client;

import weather.application.location.LocationController;
import weather.application.weather.WeatherController;

import java.time.LocalDate;
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
            System.out.println("3. Pobierz pogodę.");
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    addLocation();
                    break;
                case 2:
                    showAllLocations();
                    break;
                case 3:
                    getWeather();
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
        Integer latitude = scanner.nextInt();
        System.out.println("Podaj długość geograficzną (-180 -> W, 180 -> E): ");
        Integer longitude = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj region: ");
        String regionName = scanner.nextLine();
        System.out.println("Podaj nazwę kraju: ");
        String countryName = scanner.nextLine();

        String addedLocation = locationController.addNewLocation(cityName, latitude, longitude, regionName, countryName);
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

    private void getWeather() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj datę prognozy (YYYY-MM-DD): ");
        String userDate = scanner.nextLine();
        LocalDate localtime;                             //???
        if (userDate == null || userDate.isEmpty()) {
            localtime = LocalDate.now().plusDays(1);
        } else {
            localtime = LocalDate.parse(userDate);
        }
        System.out.println("Podaj miasto dla pogody: ");
        String name = scanner.nextLine();
        Integer lat = 0;
        Integer lon = 0;
        if (name.isEmpty()) {
            System.out.println("Podaj szerokość geograficzną (-90 -> S, 90 -> N): ");
            lat = scanner.nextInt();
            System.out.println("Podaj długość geograficzną (-180 -> W, 180 -> E): ");
            lon = scanner.nextInt();
        }
        String weather = weatherController.getWeather(name, lat, lon, localtime.toString());

        System.out.println("Twoja prognoza: " + weather);
    }
}

