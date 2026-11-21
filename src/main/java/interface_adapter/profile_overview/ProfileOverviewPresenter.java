package interface_adapter.profile_overview;

import interface_adapter.navigation.ViewSwitcher;
import interface_adapter.search_movie.SearchMovieViewModel;
import use_case.mainpage_overview.OverviewOutputBoundary;
import use_case.mainpage_overview.OverviewOutputData;

public class ProfileOverviewPresenter implements OverviewOutputBoundary {

    public static final String LOGIN_VIEW_NAME = "log in";

    private final ProfileOverviewViewModel viewModel;
    private final ViewSwitcher viewSwitcher;

    public ProfileOverviewPresenter(ProfileOverviewViewModel viewModel,
                                    ViewSwitcher viewSwitcher) {
        this.viewModel = viewModel;
        this.viewSwitcher = viewSwitcher;
    }

    @Override
    public void prepareSuccessView(OverviewOutputData outputData) {
        final ProfileOverviewState state = viewModel.getState();
        state.setUsername(outputData.getUsername());
        state.setTriggerPreferences(outputData.getTriggerPreferences());
        state.setReviews(outputData.getReviews());
        state.setSavedMovies(outputData.getSavedMovies());
        state.setErrorMessage(null);
        viewModel.notifyStateChanged();
        viewSwitcher.switchTo(ProfileOverviewViewModel.VIEW_NAME);
    }

    @Override
    public void prepareFailView(String errorMessage) {
        viewModel.getState().setErrorMessage(errorMessage);
        viewModel.notifyStateChanged();
        viewSwitcher.switchTo(ProfileOverviewViewModel.VIEW_NAME);
    }

    @Override
    public void prepareNotLoggedInView() {
        viewSwitcher.switchTo(LOGIN_VIEW_NAME);
    }

    @Override
    public void switchToSearchView() {
        viewSwitcher.switchTo(SearchMovieViewModel.VIEW_NAME);
    }
}
