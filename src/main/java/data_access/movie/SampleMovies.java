package data_access.movie;

import java.util.List;

import entity.movie.Movie;

public final class SampleMovies {

    private SampleMovies() {
    }

    public static List<Movie> all() {
        return List.of(
                movie("tt-1", "Scream", 1996, 7.4, "Horror", "Mystery"),
                movie("tt-2", "Scream", 2022, 6.7, "Horror", "Mystery"),
                movie("tt-3", "Scream VI", 2023, 7.1, "Horror", "Thriller"),
                movie("tt-4", "Get Out", 2017, 7.6, "Horror", "Thriller"),
                movie("tt-5", "The Shining", 1980, 8.2, "Horror", "Thriller"),
                movie("tt-6", "Inception", 2010, 8.4, "Science Fiction", "Action"),
                movie("tt-7", "Interstellar", 2014, 8.4, "Science Fiction", "Drama"),
                movie("tt-8", "The Dark Knight", 2008, 8.5, "Action", "Crime"),
                movie("tt-9", "Inside Out", 2015, 7.9, "Animation", "Family"),
                movie("tt-10", "Inside Out 2", 2024, 7.6, "Animation", "Family"),
                movie("tt-11", "Toy Story", 1995, 8.0, "Animation", "Comedy"),
                movie("tt-12", "Parasite", 2019, 8.5, "Thriller", "Drama"),
                movie("tt-13", "Mean Girls", 2004, 7.1, "Comedy"),
                movie("tt-14", "Saving Private Ryan", 1998, 8.2, "War", "Drama"));
    }

    private static Movie movie(String id, String title, int year, double rating,
                               String... genres) {
        return new Movie(id, title, year, null, List.of(genres), rating, null);
    }
}
