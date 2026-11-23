package use_case.search_movie.filter;

import entity.movie.Movie;

public class ReleaseYearFilter implements MovieFilter{

    private final int year;

    public ReleaseYearFilter(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Release year must be positive");
        }
        this.year = year;
    }

    @Override
    public boolean matches(Movie movie) {
        return movie.getReleaseYear() == year;
    }

    public int getYear() {
        return year;
    }
}
