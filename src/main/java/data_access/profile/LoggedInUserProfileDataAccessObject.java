package data_access.profile;

import java.util.List;

import entity.movie.Movie;
import use_case.account.login.LoginUserDataAccessInterface;
import use_case.mainpage_overview.OverviewDataAccessInterface;

public class LoggedInUserProfileDataAccessObject implements OverviewDataAccessInterface {

    private final LoginUserDataAccessInterface accounts;
    private final OverviewDataAccessInterface profileData;

    public LoggedInUserProfileDataAccessObject(LoginUserDataAccessInterface accounts,
                                               OverviewDataAccessInterface profileData) {
        this.accounts = accounts;
        this.profileData = profileData;
    }

    @Override
    public String getCurrentUsername() {
        return accounts.getCurrentUsername();
    }

    @Override
    public List<String> getTriggerPreferenceSummaries(String username) {
        return profileData.getTriggerPreferenceSummaries(username);
    }

    @Override
    public List<String> getReviews(String username) {
        return profileData.getReviews(username);
    }

    @Override
    public List<Movie> getSavedMovies(String username) {
        return profileData.getSavedMovies(username);
    }
}
