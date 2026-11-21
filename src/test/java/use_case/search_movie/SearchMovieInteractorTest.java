package use_case.search_movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data_access.movie.InMemoryMovieDataAccessObject;
import entity.movie.Movie;
import use_case.mainpage_overview.MovieDataAccessException;
import use_case.search_movie.filter.GenreFilter;
import use_case.search_movie.filter.MinRatingFilter;
import use_case.search_movie.filter.MovieFilter;
import use_case.search_movie.filter.ReleaseYearFilter;

class SearchMovieInteractorTest {

    private SearchMovieDataAccessInterface movieDataAccess;
    private RecordingPresenter presenter;
    private SearchMovieInteractor interactor;

    @BeforeEach
    void setUp() {
        movieDataAccess = new InMemoryMovieDataAccessObject(List.of(
                new Movie("1", "Scream", 1996, null, List.of("Horror", "Mystery"), 7.4, null),
                new Movie("2", "Scream", 2022, null, List.of("Horror"), 6.3, null),
                new Movie("3", "Scream VI", 2023, null, List.of("Horror", "Thriller"), 6.5, null),
                new Movie("4", "Scream Queens", 2015, null, List.of("Comedy"), 7.0, null),
                new Movie("5", "Inception", 2010, null, List.of("Science Fiction"), 8.4, null)));
        presenter = new RecordingPresenter();
        interactor = new SearchMovieInteractor(movieDataAccess, presenter);
    }

    @Test
    void searchWithoutFiltersReturnsEveryTitleMatch() {
        interactor.execute(new SearchMovieInputData("scream", null));

        assertNull(presenter.errorMessage);
        assertEquals(List.of("1", "2", "3", "4"), presenter.resultIds());
        assertEquals("scream", presenter.successData.getQuery());
    }

    @Test
    void queryIsTrimmedBeforeSearching() {
        interactor.execute(new SearchMovieInputData("  inception  ", null));

        assertEquals(List.of("5"), presenter.resultIds());
        assertEquals("inception", presenter.successData.getQuery());
    }

    @Test
    void genreFilterKeepsOnlyThatGenre() {
        interactor.execute(input("scream", new GenreFilter("Horror")));

        assertEquals(List.of("1", "2", "3"), presenter.resultIds());
    }

    @Test
    void allFiltersMustPass() {
        interactor.execute(input("scream",
                new GenreFilter("Horror"), new MinRatingFilter(6.4)));

        assertEquals(List.of("1", "3"), presenter.resultIds());
    }

    @Test
    void releaseYearFilterKeepsOnlyThatYear() {
        interactor.execute(input("scream", new ReleaseYearFilter(2022)));

        assertEquals(List.of("2"), presenter.resultIds());
    }

    @Test
    void resultsCarryTheDataTheViewNeeds() {
        interactor.execute(input("inception"));

        final MovieResult result = presenter.successData.getResults().get(0);
        assertEquals("Inception", result.getTitle());
        assertEquals(2010, result.getReleaseYear());
        assertEquals(8.4, result.getVoteAverage());
    }

    @Test
    void emptyQueryFails() {
        interactor.execute(new SearchMovieInputData("   ", null));

        assertEquals(SearchMovieInteractor.EMPTY_QUERY_MESSAGE, presenter.errorMessage);
        assertNull(presenter.successData);
    }

    @Test
    void nullQueryFails() {
        interactor.execute(new SearchMovieInputData(null, null));

        assertEquals(SearchMovieInteractor.EMPTY_QUERY_MESSAGE, presenter.errorMessage);
    }

    @Test
    void noTitleMatchFailsWithNoResultsMessage() {
        interactor.execute(input("Titanic"));

        assertEquals(String.format(SearchMovieInteractor.NO_RESULTS_MESSAGE, "Titanic"),
                presenter.errorMessage);
    }

    @Test
    void filtersThatRemoveEverythingFailWithFilterMessage() {
        interactor.execute(input("scream", new GenreFilter("Animation")));

        assertEquals(SearchMovieInteractor.NO_FILTER_MATCH_MESSAGE, presenter.errorMessage);
        assertNull(presenter.successData);
    }

    @Test
    void dataAccessFailureFailsWithSearchFailedMessage() {
        interactor = new SearchMovieInteractor(new FailingDataAccess(), presenter);

        interactor.execute(input("scream"));

        assertEquals(SearchMovieInteractor.SEARCH_FAILED_MESSAGE, presenter.errorMessage);
    }

    @Test
    void loadFilterOptionsReturnsSortedGenres() {
        interactor.loadFilterOptions();

        assertEquals(List.of("Comedy", "Horror", "Mystery", "Science Fiction", "Thriller"),
                presenter.genres);
    }

    @Test
    void loadFilterOptionsFailureFails() {
        interactor = new SearchMovieInteractor(new FailingDataAccess(), presenter);

        interactor.loadFilterOptions();

        assertEquals(SearchMovieInteractor.FILTER_OPTIONS_FAILED_MESSAGE,
                presenter.errorMessage);
        assertTrue(presenter.genres.isEmpty());
    }

    private static SearchMovieInputData input(String query, MovieFilter... filters) {
        return new SearchMovieInputData(query, List.of(filters));
    }

    private static final class RecordingPresenter implements SearchMovieOutputBoundary {
        private SearchMovieOutputData successData;
        private String errorMessage;
        private List<String> genres = new ArrayList<>();

        @Override
        public void prepareSuccessView(SearchMovieOutputData outputData) {
            successData = outputData;
        }

        @Override
        public void prepareFailView(String message) {
            errorMessage = message;
        }

        @Override
        public void prepareFilterOptionsView(List<String> genreNames) {
            genres = genreNames;
        }

        List<String> resultIds() {
            final List<String> ids = new ArrayList<>();
            for (MovieResult result : successData.getResults()) {
                ids.add(result.getId());
            }
            return ids;
        }
    }

    private static final class FailingDataAccess implements SearchMovieDataAccessInterface {
        @Override
        public List<Movie> searchByTitle(String query) {
            throw new MovieDataAccessException("offline");
        }

        @Override
        public List<String> getAvailableGenres() {
            throw new MovieDataAccessException("offline");
        }
    }
}
