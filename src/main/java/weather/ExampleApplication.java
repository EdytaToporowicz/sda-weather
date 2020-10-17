package weather;

import weather.client.Client;

public class ExampleApplication {
    public static void main(String[] args) {
        Client client = new Client();
        client.runClientInterface();
    }
}
