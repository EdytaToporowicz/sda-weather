package weather;

import java.util.Scanner;

public class ExampleApplication {
    public static void main(String[] args) {
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
                    .addNewLocation();
                    break;
                case 2:
                    .showLocations();
                    break;
                case 3:
                    .getWeather();
                    break;
                case 0:
                    System.out.println("Zamykam aplikację.");
                    return;
            }
        }

    }


    private static void addNewLocation() {
    }

    private static void showLocations() {
    }

    private static void getWeather() {
    }


}
