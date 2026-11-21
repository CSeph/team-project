package use_case.search_movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchMovieOutputData {
    private final String query;
    private final List<MovieResult> results;

    public SearchMovieOutputData(String query, List<MovieResult> results) {
        this.query = query;
        this.results = new ArrayList<>(results);
    }
    public String getQuery() {
        return query;
    }

    public List<MovieResult> getResults() {
        return Collections.unmodifiableList(results);
    }
}
