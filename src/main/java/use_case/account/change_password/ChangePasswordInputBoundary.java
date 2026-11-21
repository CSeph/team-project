package use_case.account.change_password;

/**
 * The Change Password Use Case.
 */
public interface ChangePasswordInputBoundary {

    /**
     * Execute the Change Password Use Case.
     * @param changePasswordInputData the input data for this use case
     */
    void execute(ChangePasswordInputData changePasswordInputData);

}