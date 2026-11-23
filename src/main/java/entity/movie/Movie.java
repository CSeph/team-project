package entity.movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Movie {
    public static final int UNKNOWN_YEAR = 0;
    private final String id;
    private final String title;
    private final int releaseYear;
    private final String posterUrl;
    private final List<String> genres;
    private final double voteAverage;
    private final String overview;
    public Movie(String id, String title, int releaseYear, String posterUrl,
                 List<String> genres, double voteAverage, String overview) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Movie id cannot be empty");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Movie title cannot be empty");
        }
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.posterUrl = posterUrl;
        this.genres = genres == null ? new ArrayList<>() : new ArrayList<>(genres);
        this.voteAverage = voteAverage;
        this.overview = overview;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public List<String> getGenres() {
        return Collections.unmodifiableList(genres);
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }
}
