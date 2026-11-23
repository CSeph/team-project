package use_case.search_movie.filter;

import entity.movie.Movie;

public class GenreFilter implements MovieFilter{

    private final String genre;

    public GenreFilter(String genre){
        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre cannot be empty");
        }
        this.genre = genre.trim();
    }

    @Override
    public boolean matches(Movie movie) {
        for (String movieGenre : movie.getGenres()) {
            if (movieGenre.equalsIgnoreCase(genre)) {
                return true;
            }
        }
        return false;
    }

    public String getGenre() {
        return genre;
    }
}
