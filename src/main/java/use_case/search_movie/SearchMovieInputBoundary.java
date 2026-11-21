package use_case.search_movie;

public interface SearchMovieInputBoundary {

    void execute(SearchMovieInputData inputData);

    void loadFilterOptions();
}
