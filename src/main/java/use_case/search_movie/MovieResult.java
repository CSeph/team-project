package use_case.search_movie;

public class MovieResult {

    private final String id;
    private final String title;
    private final int releaseYear;
    private final String posterUrl;
    private final double voteAverage;

    public MovieResult(String id, String title, int releaseYear, String posterUrl,
                       double voteAverage) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.posterUrl = posterUrl;
        this.voteAverage = voteAverage;
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

    public double getVoteAverage() {
        return voteAverage;
    }
}
