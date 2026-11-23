package interface_adapter.account.logged_in;

import use_case.account.change_password.ChangePasswordOutputBoundary;
import use_case.account.change_password.ChangePasswordOutputData;

/**
 * The Presenter for the Change Password Use Case.
 */
public class ChangePasswordPresenter implements ChangePasswordOutputBoundary {

    private final LoggedInViewModel loggedInViewModel;

    public ChangePasswordPresenter(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView(ChangePasswordOutputData outputData) {
        loggedInViewModel.getState().setPassword("");
        loggedInViewModel.getState().setPasswordError(null);
        loggedInViewModel.notifyPasswordChangeUpdate();
    }

    @Override
    public void prepareFailView(String error) {
        loggedInViewModel.getState().setPasswordError(error);
        loggedInViewModel.notifyPasswordChangeUpdate();
    }
}