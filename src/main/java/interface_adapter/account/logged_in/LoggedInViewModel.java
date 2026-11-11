package interface_adapter.logged_in;

import java.util.ArrayList;
import java.util.List;

/**
 * The View Model for the Logged In View.
 */
public class LoggedInViewModel {

    private final List<LoggedInViewModelListener> listeners = new ArrayList<>();

    public static final String VIEW_NAME = "logged in";

    private LoggedInState state = new LoggedInState();

    public LoggedInState getState() {
        return this.state;
    }

    public void setState(LoggedInState state) {
        this.state = state;
    }

    public void addListener(LoggedInViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (LoggedInViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }

    public void notifyPasswordChangeUpdate() {
        for (LoggedInViewModelListener listener : listeners) {
            listener.passwordChanged();
        }
    }
}