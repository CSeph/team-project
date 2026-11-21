package use_case.search_movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import use_case.search_movie.filter.MovieFilter;

public class SearchMovieInputData {

    private final String query;
    private final List<MovieFilter> filters;

    public SearchMovieInputData(String query, List<MovieFilter> filters) {
        this.query = query;
        this.filters = filters == null ? new ArrayList<>() : new ArrayList<>(filters);
    }

    public String getQuery() {
        return query;
    }

    public List<MovieFilter> getFilters() {
        return Collections.unmodifiableList(filters);
    }
}
