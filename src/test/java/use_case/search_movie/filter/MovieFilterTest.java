package use_case.search_movie.filter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import entity.movie.Movie;

class MovieFilterTest {

    private final Movie scream = new Movie("1", "Scream", 1996, null,
            List.of("Horror", "Mystery"), 7.4, null);
    private final Movie unknownYear = new Movie("2", "Untitled", Movie.UNKNOWN_YEAR, null,
            List.of(), 0.0, null);

    @Test
    void releaseYearFilterKeepsMatchingYear() {
        assertTrue(new ReleaseYearFilter(1996).matches(scream));
    }

    @Test
    void releaseYearFilterRemovesOtherYears() {
        assertFalse(new ReleaseYearFilter(2022).matches(scream));
    }

    @Test
    void releaseYearFilterRemovesMoviesWithUnknownYear() {
        assertFalse(new ReleaseYearFilter(1996).matches(unknownYear));
    }

    @Test
    void releaseYearFilterRejectsNonPositiveYear() {
        assertThrows(IllegalArgumentException.class, () -> new ReleaseYearFilter(0));
    }

    @Test
    void genreFilterKeepsMatchingGenreIgnoringCase() {
        assertTrue(new GenreFilter("horror").matches(scream));
        assertTrue(new GenreFilter(" Mystery ").matches(scream));
    }

    @Test
    void genreFilterRemovesOtherGenres() {
        assertFalse(new GenreFilter("Comedy").matches(scream));
    }

    @Test
    void genreFilterRemovesMoviesWithNoGenres() {
        assertFalse(new GenreFilter("Horror").matches(unknownYear));
    }

    @Test
    void genreFilterRejectsEmptyGenre() {
        assertThrows(IllegalArgumentException.class, () -> new GenreFilter(" "));
        assertThrows(IllegalArgumentException.class, () -> new GenreFilter(null));
    }

    @Test
    void minRatingFilterKeepsRatingsAtOrAboveMinimum() {
        assertTrue(new MinRatingFilter(7.4).matches(scream));
        assertTrue(new MinRatingFilter(5).matches(scream));
    }

    @Test
    void minRatingFilterRemovesLowerRatings() {
        assertFalse(new MinRatingFilter(8).matches(scream));
    }

    @Test
    void minRatingFilterRejectsOutOfRangeRating() {
        assertThrows(IllegalArgumentException.class, () -> new MinRatingFilter(-1));
        assertThrows(IllegalArgumentException.class, () -> new MinRatingFilter(10.5));
    }
}
