package use_case.search_movie;

import java.util.List;

import entity.movie.Movie;

public interface SearchMovieDataAccessInterface {

    List<Movie> searchByTitle(String query);

    List<String> getAvailableGenres();
}
