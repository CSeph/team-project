package interface_adapter.signup;

import java.util.ArrayList;
import java.util.List;

/**
 * The ViewModel for the Signup View.
 */
public class SignupViewModel {

    public static final String TITLE_LABEL = "Sign Up View";
    public static final String USERNAME_LABEL = "Choose username";
    public static final String PASSWORD_LABEL = "Choose password";
    public static final String REPEAT_PASSWORD_LABEL = "Enter password again";

    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public static final String TO_LOGIN_BUTTON_LABEL = "Go to Login";

    private final List<SignupViewModelListener> listeners = new ArrayList<>();

    public static final String VIEW_NAME = "sign up";

    private SignupState state = new SignupState();

    public SignupState getState() {
        return this.state;
    }

    public void setState(SignupState state) {
        this.state = state;
    }

    public void addListener(SignupViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (SignupViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}