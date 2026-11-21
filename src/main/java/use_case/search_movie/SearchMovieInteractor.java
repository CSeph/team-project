package use_case.search_movie;

import java.util.ArrayList;
import java.util.List;

import entity.movie.Movie;
import use_case.mainpage_overview.MovieDataAccessException;
import use_case.search_movie.filter.MovieFilter;

public class SearchMovieInteractor implements SearchMovieInputBoundary {
    public static final String EMPTY_QUERY_MESSAGE = "Movie title:";

    public static final String SEARCH_FAILED_MESSAGE = "";

    public static final String NO_RESULTS_MESSAGE = "No movies were found for \"%s\".";

    public static final String NO_FILTER_MATCH_MESSAGE =
            "No movies match the selected filters. Try changing or clearing them.";

    public static final String FILTER_OPTIONS_FAILED_MESSAGE =
            "The options could not be loaded.";

    private final SearchMovieDataAccessInterface movieDataAccess;
    private final SearchMovieOutputBoundary presenter;

    public SearchMovieInteractor(SearchMovieDataAccessInterface movieDataAccess,
                                 SearchMovieOutputBoundary presenter) {
        this.movieDataAccess = movieDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(SearchMovieInputData inputData) {
        final String query = inputData.getQuery();
        if (query == null || query.isBlank()) {
            presenter.prepareFailView(EMPTY_QUERY_MESSAGE);
            return;
        }
        final String trimmedQuery = query.trim();

        final List<Movie> movies;
        try {
            movies = movieDataAccess.searchByTitle(trimmedQuery);
        }
        catch (MovieDataAccessException exception) {
            presenter.prepareFailView(SEARCH_FAILED_MESSAGE);
            return;
        }

        if (movies.isEmpty()) {
            presenter.prepareFailView(String.format(NO_RESULTS_MESSAGE, trimmedQuery));
            return;
        }

        final List<Movie> filteredMovies = applyFilters(movies, inputData.getFilters());
        if (filteredMovies.isEmpty()) {
            presenter.prepareFailView(NO_FILTER_MATCH_MESSAGE);
            return;
        }

        final List<MovieResult> results = new ArrayList<>();
        for (Movie movie : filteredMovies) {
            results.add(toResult(movie));
        }
        presenter.prepareSuccessView(new SearchMovieOutputData(trimmedQuery, results));
    }

    @Override
    public void loadFilterOptions() {
        try {
            final List<String> genres = new ArrayList<>(movieDataAccess.getAvailableGenres());
            genres.sort(String.CASE_INSENSITIVE_ORDER);
            presenter.prepareFilterOptionsView(genres);
        }
        catch (MovieDataAccessException exception) {
            presenter.prepareFailView(FILTER_OPTIONS_FAILED_MESSAGE);
        }
    }
    private List<Movie> applyFilters(List<Movie> movies, List<MovieFilter> filters) {
        final List<Movie> kept = new ArrayList<>();
        for (Movie movie : movies) {
            if (passesAll(movie, filters)) {
                kept.add(movie);
            }
        }
        return kept;
    }

    private boolean passesAll(Movie movie, List<MovieFilter> filters) {
        for (MovieFilter filter : filters) {
            if (!filter.matches(movie)) {
                return false;
            }
        }
        return true;
    }

    private MovieResult toResult(Movie movie) {
        return new MovieResult(movie.getId(), movie.getTitle(), movie.getReleaseYear(),
                movie.getPosterUrl(), movie.getVoteAverage());
    }
}
