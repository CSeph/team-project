package use_case.search_movie;

import java.util.List;

public interface SearchMovieOutputBoundary {

    void prepareSuccessView(SearchMovieOutputData outputData);

    void prepareFailView(String errorMessage);

    void prepareFilterOptionsView(List<String> genres);
}
