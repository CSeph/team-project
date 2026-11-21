package interface_adapter.profile_overview;

import java.util.ArrayList;
import java.util.List;

import use_case.search_movie.MovieResult;

public class ProfileOverviewState {

    private String username = "";
    private List<String> triggerPreferences = new ArrayList<>();
    private List<String> reviews = new ArrayList<>();
    private List<MovieResult> savedMovies = new ArrayList<>();
    private String errorMessage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getTriggerPreferences() {
        return triggerPreferences;
    }

    public void setTriggerPreferences(List<String> triggerPreferences) {
        this.triggerPreferences = new ArrayList<>(triggerPreferences);
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = new ArrayList<>(reviews);
    }

    public List<MovieResult> getSavedMovies() {
        return savedMovies;
    }

    public void setSavedMovies(List<MovieResult> savedMovies) {
        this.savedMovies = new ArrayList<>(savedMovies);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
