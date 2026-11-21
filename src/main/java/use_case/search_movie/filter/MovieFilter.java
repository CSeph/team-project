package use_case.search_movie.filter;

import entity.movie.Movie;

public interface MovieFilter {

    boolean matches(Movie movie);
}
