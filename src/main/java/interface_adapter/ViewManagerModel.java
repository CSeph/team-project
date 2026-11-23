package interface_adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for the View Manager. Its state is the name of the View which
 * is currently active. An initial state of "" is used.
 */
public class ViewManagerModel {

    private final List<ViewManagerModelListener> listeners = new ArrayList<>();

    private String currentViewName = "";

    public String getCurrentViewName() {
        return this.currentViewName;
    }

    public void setState(String currentViewName) {
        this.currentViewName = currentViewName;
    }

    public void addListener(ViewManagerModelListener listener) {
        listeners.add(listener);
    }

    public void notifyViewChanged() {
        for (ViewManagerModelListener listener : listeners) {
            listener.viewChanged();
        }
    }

}