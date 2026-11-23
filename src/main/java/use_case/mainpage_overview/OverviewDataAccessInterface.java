package use_case.mainpage_overview;

import java.util.List;

import entity.movie.Movie;

public interface OverviewDataAccessInterface {

    String getCurrentUsername();

    List<String> getTriggerPreferenceSummaries(String username);

    List<String> getReviews(String username);

    List<Movie> getSavedMovies(String username);
}
