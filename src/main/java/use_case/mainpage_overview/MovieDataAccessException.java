package use_case.mainpage_overview;

public class MovieDataAccessException extends RuntimeException {
    public MovieDataAccessException(String message) {
        super(message);
    }
}
