package data_access.movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;

import entity.movie.Movie;
import use_case.search_movie.SearchMovieDataAccessInterface;

public class InMemoryMovieDataAccessObject implements SearchMovieDataAccessInterface {

    private final List<Movie> movies;

    public InMemoryMovieDataAccessObject(List<Movie> movies) {
        this.movies = new ArrayList<>(movies);
    }

    @Override
    public List<Movie> searchByTitle(String query) {
        final String lowerQuery = query.toLowerCase(Locale.ROOT);
        final List<Movie> matches = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase(Locale.ROOT).contains(lowerQuery)) {
                matches.add(movie);
            }
        }
        return matches;
    }

    @Override
    public List<String> getAvailableGenres() {
        final TreeSet<String> genres = new TreeSet<>();
        for (Movie movie : movies) {
            genres.addAll(movie.getGenres());
        }
        return Collections.unmodifiableList(new ArrayList<>(genres));
    }
}
