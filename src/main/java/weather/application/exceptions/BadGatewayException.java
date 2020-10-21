package weather.application.exceptions;

public class BadGatewayException extends RuntimeException {
    public BadGatewayException(String message){
        super(message);
    }
}
