package weather.client;

import weather.application.LocationController;

import java.util.Scanner;

public class Client {
    private final LocationController locationController = new LocationController();

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
                    addNewLocation();
                    break;
                case 2:
                    showLocations();
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

    private void addNewLocation() {
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

        System.out.println("Dodano nową lokalizację.");
    }

    private void showLocations() {
        String location = locationController.readAllLocations();
        System.out.println("Twoje lokalizacje: " + location);
    }

    private void getWeather() {

    }
}

