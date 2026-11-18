package use_case.search_movie;

public class MovieDataAccessException extends RuntimeException {
    public MovieDataAccessException(String message) {
        super(message);
    }
}
