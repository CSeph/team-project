package interface_adapter.profile_overview;

import use_case.mainpage_overview.OverviewInputBoundary;

public class ProfileOverviewController {

    private final OverviewInputBoundary profileOverviewInteractor;

    public ProfileOverviewController(OverviewInputBoundary profileOverviewInteractor) {
        this.profileOverviewInteractor = profileOverviewInteractor;
    }

    public void execute() {
        profileOverviewInteractor.execute();
    }

    public void switchToSearchView() {
        profileOverviewInteractor.switchToSearchView();
    }
}
