package use_case.profile_overview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import data_access.movie.SampleMovies;
import data_access.profile.InMemoryProfileDataAccessObject;
import entity.movie.Movie;
import use_case.mainpage_overview.OverviewInteractor;
import use_case.mainpage_overview.OverviewOutputBoundary;
import use_case.mainpage_overview.OverviewOutputData;
import use_case.mainpage_overview.ProfileDataAccessException;

class ProfileOverviewInteractorTest {

    private final RecordingPresenter presenter = new RecordingPresenter();

    @Test
    void loggedInUserSeesWholeProfile() {
        final Movie getOut = SampleMovies.all().get(3);
        final InMemoryProfileDataAccessObject data = new InMemoryProfileDataAccessObject(
                "seph", List.of("Violence: Medium"), List.of("Great warnings"), List.of(getOut));

        new OverviewInteractor(data, presenter).execute();

        assertEquals("seph", presenter.successData.getUsername());
        assertEquals(List.of("Violence: Medium"), presenter.successData.getTriggerPreferences());
        assertEquals(List.of("Great warnings"), presenter.successData.getReviews());
        assertEquals("Get Out", presenter.successData.getSavedMovies().get(0).getTitle());
        assertNull(presenter.errorMessage);
    }

    @Test
    void notLoggedInGoesToSignIn() {
        final InMemoryProfileDataAccessObject data = new InMemoryProfileDataAccessObject(
                null, List.of(), List.of(), List.of());

        new OverviewInteractor(data, presenter).execute();

        assertTrue(presenter.notLoggedIn);
        assertNull(presenter.successData);
    }

    @Test
    void emptyProfileIsStillShown() {
        final InMemoryProfileDataAccessObject data = new InMemoryProfileDataAccessObject(
                "newuser", List.of(), List.of(), List.of());

        new OverviewInteractor(data, presenter).execute();

        assertEquals("newuser", presenter.successData.getUsername());
        assertTrue(presenter.successData.getTriggerPreferences().isEmpty());
        assertTrue(presenter.successData.getSavedMovies().isEmpty());
    }

    @Test
    void loadFailureShowsError() {
        final InMemoryProfileDataAccessObject data = new InMemoryProfileDataAccessObject(
                "seph", List.of(), List.of(), List.of()) {
            @Override
            public List<String> getReviews(String username) {
                throw new ProfileDataAccessException("database offline");
            }
        };

        new OverviewInteractor(data, presenter).execute();

        assertEquals(OverviewInteractor.LOAD_FAILED_MESSAGE, presenter.errorMessage);
        assertNull(presenter.successData);
    }

    @Test
    void backGoesToSearch() {
        final InMemoryProfileDataAccessObject data = InMemoryProfileDataAccessObject
                .withSampleUser();

        new OverviewInteractor(data, presenter).switchToSearchView();

        assertTrue(presenter.switchedToSearch);
    }

    private static final class RecordingPresenter implements OverviewOutputBoundary {
        private OverviewOutputData successData;
        private String errorMessage;
        private boolean notLoggedIn;
        private boolean switchedToSearch;

        @Override
        public void prepareSuccessView(OverviewOutputData outputData) {
            successData = outputData;
        }

        @Override
        public void prepareFailView(String message) {
            errorMessage = message;
        }

        @Override
        public void prepareNotLoggedInView() {
            notLoggedIn = true;
        }

        @Override
        public void switchToSearchView() {
            switchedToSearch = true;
        }
    }
}
