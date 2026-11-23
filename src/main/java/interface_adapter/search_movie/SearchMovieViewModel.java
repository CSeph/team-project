package interface_adapter.search_movie;

import java.util.ArrayList;
import java.util.List;

public class SearchMovieViewModel {

    public static final String VIEW_NAME = "search movie";

    private final List<SearchMovieViewModelListener> listeners = new ArrayList<>();
    private SearchMovieState state = new SearchMovieState();

    public SearchMovieState getState() {
        return state;
    }

    public void setState(SearchMovieState state) {
        this.state = state;
    }

    public void addListener(SearchMovieViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (SearchMovieViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}
