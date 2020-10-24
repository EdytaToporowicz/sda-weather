package weather.application.weather;

import lombok.Data;

@Data
public class Wind {
    private String deg; //kierunek wiatru w stopniach - nie ma kierunku w tym portalu
    private String speed;
}
