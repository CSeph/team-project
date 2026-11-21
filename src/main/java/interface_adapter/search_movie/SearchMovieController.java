package interface_adapter.search_movie;

import java.util.ArrayList;
import java.util.List;

import use_case.search_movie.SearchMovieInputBoundary;
import use_case.search_movie.SearchMovieInputData;
import use_case.search_movie.filter.GenreFilter;
import use_case.search_movie.filter.MinRatingFilter;
import use_case.search_movie.filter.MovieFilter;
import use_case.search_movie.filter.ReleaseYearFilter;

public class SearchMovieController {

    private final SearchMovieInputBoundary searchMovieInteractor;

    public SearchMovieController(SearchMovieInputBoundary searchMovieInteractor) {
        this.searchMovieInteractor = searchMovieInteractor;
    }

    public void execute(String query) {
        execute(query, null, null, null);
    }

    public void execute(String query, List<String> genres, Integer releaseYear,
                        Double minRating) {
        final List<MovieFilter> filters = new ArrayList<>();
        if (genres != null) {
            for (String genre : genres) {
                filters.add(new GenreFilter(genre));
            }
        }
        if (releaseYear != null) {
            filters.add(new ReleaseYearFilter(releaseYear));
        }
        if (minRating != null) {
            filters.add(new MinRatingFilter(minRating));
        }
        searchMovieInteractor.execute(new SearchMovieInputData(query, filters));
    }

    public void loadFilterOptions() {
        searchMovieInteractor.loadFilterOptions();
    }
}
