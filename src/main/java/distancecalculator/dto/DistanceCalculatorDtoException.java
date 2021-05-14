package distancecalculator.dto;

public class DistanceCalculatorDtoException extends Exception{

    DistanceCalculatorDtoException(String message) {
        super(message);
    }
    DistanceCalculatorDtoException(String message, Throwable cause) {
        super(message, cause);
    }

}
