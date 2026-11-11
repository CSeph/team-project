package interface_adapter.logged_in;

public interface LoggedInViewModelListener {

  /**
   * The logged-in state was updated.
   */
  void stateChanged();

  /**
   * A password change attempt occurred.
   */
  void passwordChanged();
}