package interface_adapter.account.logout;

import use_case.account.logout.LogoutInputBoundary;

/**
 * The controller for the Logout Use Case.
 */
public class LogoutController {

    private LogoutInputBoundary logoutUseCaseInteractor;

    public LogoutController(LogoutInputBoundary logoutUseCaseInteractor) {
        // TODO: Save the interactor in the instance variable.
    }

    /**
     * Executes the Logout Use Case.
     */
    public void execute() {
        // TODO: run the use case interactor for the logout use case
    }
}