package interface_adapter.login;

import java.util.ArrayList;
import java.util.List;

/**
 * The View Model for the Login View.
 */
public class LoginViewModel {

    private final List<LoginViewModelListener> listeners = new ArrayList<>();

    public static final String VIEW_NAME = "log in";

    private LoginState state = new LoginState();

    public LoginState getState() {
        return this.state;
    }

    public void setState(LoginState state) {
        this.state = state;
    }

    public void addListener(LoginViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (LoginViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }

}