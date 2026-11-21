package use_case.search_movie.filter;

import entity.movie.Movie;

public class MinRatingFilter implements MovieFilter{

    public static final double MAX_RATING = 10.0;

    private final double minRating;

    public MinRatingFilter(double minRating) {
        if (minRating < 0 || minRating > MAX_RATING) {
            throw new IllegalArgumentException("Minimum rating must be between 0 and 10");
        }
        this.minRating = minRating;
    }

    @Override
    public boolean matches(Movie movie) {
        return movie.getVoteAverage() >= minRating;
    }

    public double getMinRating() {
        return minRating;
    }
}
