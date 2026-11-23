package use_case.analyze;

public class InvalidCaptionFileException extends RuntimeException {

    public InvalidCaptionFileException(String message) {
        super(message);
    }
}