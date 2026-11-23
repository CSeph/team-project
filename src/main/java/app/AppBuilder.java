package app;

import data_access.account.FileUserDataAccessObject;
import entity.account.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.account.logged_in.ChangePasswordController;
import interface_adapter.account.logged_in.ChangePasswordPresenter;
import interface_adapter.account.logged_in.LoggedInViewModel;
import interface_adapter.account.login.LoginController;
import interface_adapter.account.login.LoginPresenter;
import interface_adapter.account.login.LoginViewModel;
import interface_adapter.account.logout.LogoutController;
import interface_adapter.account.logout.LogoutPresenter;
import interface_adapter.account.signup.SignupController;
import interface_adapter.account.signup.SignupPresenter;
import interface_adapter.account.signup.SignupViewModel;
import use_case.account.change_password.ChangePasswordInputBoundary;
import use_case.account.change_password.ChangePasswordInteractor;
import use_case.account.change_password.ChangePasswordOutputBoundary;
import use_case.account.login.LoginInputBoundary;
import use_case.account.login.LoginInteractor;
import use_case.account.login.LoginOutputBoundary;
import use_case.account.logout.LogoutInputBoundary;
import use_case.account.logout.LogoutInteractor;
import use_case.account.logout.LogoutOutputBoundary;
import use_case.account.signup.SignupInputBoundary;
import use_case.account.signup.SignupInteractor;
import use_case.account.signup.SignupOutputBoundary;
import view.LoggedInView;
import view.LoginView;
import view.SignupView;
import view.ViewManager;

import data_access.movie.InMemoryMovieDataAccessObject;
import data_access.movie.SampleMovies;
import data_access.profile.InMemoryProfileDataAccessObject;
import data_access.profile.LoggedInUserProfileDataAccessObject;
import interface_adapter.navigation.ViewManagerSwitcher;
import interface_adapter.navigation.ViewSwitcher;
import interface_adapter.profile_overview.ProfileOverviewController;
import interface_adapter.profile_overview.ProfileOverviewPresenter;
import interface_adapter.profile_overview.ProfileOverviewViewModel;
import interface_adapter.search_movie.SearchMovieController;
import interface_adapter.search_movie.SearchMoviePresenter;
import interface_adapter.search_movie.SearchMovieViewModel;
import use_case.mainpage_overview.OverviewInteractor;
import use_case.search_movie.SearchMovieInteractor;
import view.ProfileOverviewView;
import view.SearchMovieView;

import javax.swing.*;
import java.awt.*;

public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    final UserFactory userFactory = new UserFactory();
    final ViewManagerModel viewManagerModel = new ViewManagerModel();
    ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // set which data access implementation to use, can be any
    // of the classes from the data_access package

    // DAO version using local file storage
    final FileUserDataAccessObject userDataAccessObject = new FileUserDataAccessObject("users.csv", userFactory);

    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;
    private SearchMovieViewModel searchMovieViewModel;
    private SearchMovieView searchMovieView;
    private ProfileOverviewViewModel profileOverviewViewModel;
    private ProfileOverviewView profileOverviewView;
    private final ViewSwitcher viewSwitcher = new ViewManagerSwitcher(viewManagerModel);

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    public AppBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, SignupViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, LoginViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addLoggedInView() {
        loggedInViewModel = new LoggedInViewModel();
        loggedInView = new LoggedInView(loggedInViewModel);
        cardPanel.add(loggedInView, LoggedInViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    public AppBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    public AppBuilder addChangePasswordUseCase() {
        final ChangePasswordOutputBoundary changePasswordOutputBoundary = new ChangePasswordPresenter(loggedInViewModel);

        final ChangePasswordInputBoundary changePasswordInteractor =
                new ChangePasswordInteractor(userDataAccessObject, changePasswordOutputBoundary, userFactory);

        ChangePasswordController changePasswordController = new ChangePasswordController(changePasswordInteractor);
        loggedInView.setChangePasswordController(changePasswordController);
        return this;
    }

    /**
     * Adds the Logout Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);

        final LogoutInputBoundary logoutInteractor =
                new LogoutInteractor(userDataAccessObject, logoutOutputBoundary);

        final LogoutController logoutController = new LogoutController(logoutInteractor);
        loggedInView.setLogoutController(logoutController);
        return this;
    }

    public AppBuilder addSearchMovieView() {
        searchMovieViewModel = new SearchMovieViewModel();
        searchMovieView = new SearchMovieView(searchMovieViewModel);
        searchMovieView.setMovieSelectedAction(movieId -> showComingSoon("Movie Details (Toby)"));
        searchMovieView.setUploadAction(() -> showComingSoon("Upload Your Own Media (Emirhan)"));
        cardPanel.add(searchMovieView, SearchMovieViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addProfileOverviewView() {
        profileOverviewViewModel = new ProfileOverviewViewModel();
        profileOverviewView = new ProfileOverviewView(profileOverviewViewModel);
        profileOverviewView.setMovieSelectedAction(
                movieId -> showComingSoon("Movie Details (Toby)"));
        profileOverviewView.setManagePreferencesAction(
                () -> showComingSoon("Edit Profile Settings (Sarina)"));
        profileOverviewView.setSignOutAction(
                () -> showComingSoon("Sign Out (LogoutPresenter is not finished yet)"));
        cardPanel.add(profileOverviewView, ProfileOverviewViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addSearchMovieUseCase() {
        final SearchMoviePresenter presenter = new SearchMoviePresenter(searchMovieViewModel);
        final SearchMovieInteractor interactor = new SearchMovieInteractor(
                new InMemoryMovieDataAccessObject(SampleMovies.all()), presenter);
        final SearchMovieController controller = new SearchMovieController(interactor);
        searchMovieView.setSearchMovieController(controller);
        controller.loadFilterOptions();
        return this;
    }

    public AppBuilder addProfileOverviewUseCase() {
        final ProfileOverviewPresenter presenter =
                new ProfileOverviewPresenter(profileOverviewViewModel, viewSwitcher);
        final OverviewInteractor interactor = new OverviewInteractor(
                new LoggedInUserProfileDataAccessObject(userDataAccessObject,
                        InMemoryProfileDataAccessObject.withSampleUser()),
                presenter);
        final ProfileOverviewController controller = new ProfileOverviewController(interactor);
        profileOverviewView.setProfileOverviewController(controller);
        searchMovieView.setProfileOverviewController(controller);
        return this;
    }

    private void showComingSoon(String screenName) {
        JOptionPane.showMessageDialog(cardPanel,
                "The " + screenName + " screen is not connected yet.",
                "Coming soon", JOptionPane.INFORMATION_MESSAGE);
    }

    public JFrame build() {
        final JFrame application = new JFrame("User Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(SignupViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();

        return application;
    }


}