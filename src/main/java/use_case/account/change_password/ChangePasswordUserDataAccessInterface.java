package use_case.account.change_password;

import entity.account.User;

/**
 * The DAO interface for the Change Password Use Case.
 */
public interface ChangePasswordUserDataAccessInterface {

    /**
     * Updates the system to record this user's password.
     * @param user the user whose password is to be updated
     */
    void changePassword(User user);
}