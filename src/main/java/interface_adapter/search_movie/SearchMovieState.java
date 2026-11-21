package interface_adapter.search_movie;

import java.util.ArrayList;
import java.util.List;

import use_case.search_movie.MovieResult;

public class SearchMovieState {

    private String query = "";
    private List<MovieResult> results = new ArrayList<>();
    private List<String> availableGenres = new ArrayList<>();
    private String errorMessage;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<MovieResult> getResults() {
        return results;
    }

    public void setResults(List<MovieResult> results) {
        this.results = new ArrayList<>(results);
    }

    public List<String> getAvailableGenres() {
        return availableGenres;
    }

    public void setAvailableGenres(List<String> availableGenres) {
        this.availableGenres = new ArrayList<>(availableGenres);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
