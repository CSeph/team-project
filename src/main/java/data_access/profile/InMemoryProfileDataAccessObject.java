package data_access.profile;

import java.util.ArrayList;
import java.util.List;

import data_access.movie.SampleMovies;
import entity.movie.Movie;
import use_case.mainpage_overview.OverviewDataAccessInterface;

public class InMemoryProfileDataAccessObject implements OverviewDataAccessInterface {

    private String currentUsername;
    private final List<String> triggerPreferences;
    private final List<String> reviews;
    private final List<Movie> savedMovies;

    public InMemoryProfileDataAccessObject(String currentUsername,
                                           List<String> triggerPreferences,
                                           List<String> reviews, List<Movie> savedMovies) {
        this.currentUsername = currentUsername;
        this.triggerPreferences = new ArrayList<>(triggerPreferences);
        this.reviews = new ArrayList<>(reviews);
        this.savedMovies = new ArrayList<>(savedMovies);
    }

    public static InMemoryProfileDataAccessObject withSampleUser() {
        final List<Movie> catalogue = SampleMovies.all();
        return new InMemoryProfileDataAccessObject(
                "seph",
                List.of("Violence: Medium threshold, blur content",
                        "Jump scares: Low threshold, show a warning",
                        "Self-harm: Low threshold, skip content"),
                List.of("Scream (1996): the 0:52 warning was accurate",
                        "Get Out (2017): warning came about 30 seconds early"),
                List.of(catalogue.get(3), catalogue.get(5), catalogue.get(8)));
    }

    public void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }

    @Override
    public String getCurrentUsername() {
        return currentUsername;
    }

    @Override
    public List<String> getTriggerPreferenceSummaries(String username) {
        return new ArrayList<>(triggerPreferences);
    }

    @Override
    public List<String> getReviews(String username) {
        return new ArrayList<>(reviews);
    }

    @Override
    public List<Movie> getSavedMovies(String username) {
        return new ArrayList<>(savedMovies);
    }
}
