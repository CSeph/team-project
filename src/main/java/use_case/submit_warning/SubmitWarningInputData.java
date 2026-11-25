
package use_case.submit_warning;

/**
 * Input data for submitting a community trigger warning.
 */
public final class SubmitWarningInputData {

    private final String mediaId;
    private final String authorId;
    private final String categoryName;
    private final int startSeconds;
    private final int endSeconds;
    private final String description;
    private final int severity;

    public SubmitWarningInputData(
            String mediaId,
            String authorId,
            String categoryName,
            int startSeconds,
            int endSeconds,
            String description,
            int severity) {

        this.mediaId = mediaId;
        this.authorId = authorId;
        this.categoryName = categoryName;
        this.startSeconds = startSeconds;
        this.endSeconds = endSeconds;
        this.description = description;
        this.severity = severity;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getStartSeconds() {
        return startSeconds;
    }

    public int getEndSeconds() {
        return endSeconds;
    }

    public String getDescription() {
        return description;
    }

    public int getSeverity() {
        return severity;
    }
}
