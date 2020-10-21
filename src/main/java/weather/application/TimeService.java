package weather.application;

/*public class TimeService {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public TimeService() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.findAndRegisterModules();
    }
    public WeatherResponse getWeatherResponse() {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://worldclockapi.com/api/json/utc/now"))
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();

            TimeResponse timeResponse = objectMapper.readValue(responseBody, TimeResponse.class);
            String currentDateTime = timeResponse.getDate();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
            LocalDateTime localDateTime = LocalDateTime.parse(currentDateTime, dateTimeFormatter);
            return localDateTime.toInstant(ZoneOffset.UTC);
        } catch (Exception e) {
            System.out.println("Nieudana próba pobrania czasu: " + e.getMessage());
            return Instant.now();
        }
    }

    public void getWeatherForecast() {
    }
}
*/