package interface_adapter.search_movie;

import java.util.ArrayList;
import java.util.List;

import use_case.search_movie.SearchMovieOutputBoundary;
import use_case.search_movie.SearchMovieOutputData;

public class SearchMoviePresenter implements SearchMovieOutputBoundary {

    private final SearchMovieViewModel viewModel;

    public SearchMoviePresenter(SearchMovieViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(SearchMovieOutputData outputData) {
        final SearchMovieState state = viewModel.getState();
        state.setQuery(outputData.getQuery());
        state.setResults(outputData.getResults());
        state.setErrorMessage(null);
        viewModel.notifyStateChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final SearchMovieState state = viewModel.getState();
        state.setResults(new ArrayList<>());
        state.setErrorMessage(errorMessage);
        viewModel.notifyStateChanged();
    }

    @Override
    public void prepareFilterOptionsView(List<String> genres) {
        viewModel.getState().setAvailableGenres(genres);
        viewModel.notifyStateChanged();
    }
}
