package use_case.mainpage_overview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import use_case.search_movie.MovieResult;

public class OverviewOutputData {

    private final String username;
    private final List<String> triggerPreferences;
    private final List<String> reviews;
    private final List<MovieResult> savedMovies;

    public OverviewOutputData(String username, List<String> triggerPreferences,
                                     List<String> reviews, List<MovieResult> savedMovies) {
        this.username = username;
        this.triggerPreferences = new ArrayList<>(triggerPreferences);
        this.reviews = new ArrayList<>(reviews);
        this.savedMovies = new ArrayList<>(savedMovies);
    }

    public String getUsername() {
        return username;
    }

    public List<String> getTriggerPreferences() {
        return Collections.unmodifiableList(triggerPreferences);
    }

    public List<String> getReviews() {
        return Collections.unmodifiableList(reviews);
    }

    public List<MovieResult> getSavedMovies() {
        return Collections.unmodifiableList(savedMovies);
    }
}
