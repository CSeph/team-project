package use_case.mainpage_overview;

public class ProfileDataAccessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProfileDataAccessException(String message) {
        super(message);
    }
}
