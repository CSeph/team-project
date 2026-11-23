package use_case.mainpage_overview;

public interface OverviewOutputBoundary {

    void prepareSuccessView(OverviewOutputData outputData);

    void prepareFailView(String errorMessage);

    void prepareNotLoggedInView();

    void switchToSearchView();
}
