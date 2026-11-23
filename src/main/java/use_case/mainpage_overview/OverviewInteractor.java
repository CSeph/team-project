package use_case.mainpage_overview;

import java.util.ArrayList;
import java.util.List;

import entity.movie.Movie;
import use_case.search_movie.MovieResult;

public class OverviewInteractor implements OverviewInputBoundary {

    public static final String LOAD_FAILED_MESSAGE =
            "Your profile could not be loaded. Please try again.";

    private final OverviewDataAccessInterface profileDataAccess;
    private final OverviewOutputBoundary presenter;

    public OverviewInteractor(OverviewDataAccessInterface profileDataAccess,
                                     OverviewOutputBoundary presenter) {
        this.profileDataAccess = profileDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        final String username = profileDataAccess.getCurrentUsername();
        if (username == null) {
            presenter.prepareNotLoggedInView();
            return;
        }

        final OverviewOutputData outputData;
        try {
            outputData = new OverviewOutputData(
                    username,
                    profileDataAccess.getTriggerPreferenceSummaries(username),
                    profileDataAccess.getReviews(username),
                    toResults(profileDataAccess.getSavedMovies(username)));
        }
        catch (ProfileDataAccessException exception) {
            presenter.prepareFailView(LOAD_FAILED_MESSAGE);
            return;
        }
        presenter.prepareSuccessView(outputData);
    }

    @Override
    public void switchToSearchView() {
        presenter.switchToSearchView();
    }

    private static List<MovieResult> toResults(List<Movie> movies) {
        final List<MovieResult> results = new ArrayList<>();
        for (Movie movie : movies) {
            results.add(new MovieResult(movie.getId(), movie.getTitle(),
                    movie.getReleaseYear(), movie.getPosterUrl(), movie.getVoteAverage()));
        }
        return results;
    }
}
