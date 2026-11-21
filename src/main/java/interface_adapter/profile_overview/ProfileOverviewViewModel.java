package interface_adapter.profile_overview;

import java.util.ArrayList;
import java.util.List;

public class ProfileOverviewViewModel {

    public static final String VIEW_NAME = "profile overview";

    private final List<ProfileOverviewViewModelListener> listeners = new ArrayList<>();
    private ProfileOverviewState state = new ProfileOverviewState();

    public ProfileOverviewState getState() {
        return state;
    }

    public void setState(ProfileOverviewState state) {
        this.state = state;
    }

    public void addListener(ProfileOverviewViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (ProfileOverviewViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}
