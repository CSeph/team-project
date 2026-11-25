
package entity;

import java.util.Objects;

/**
 * Represents a trigger warning submitted by a user.
 */
public final class TriggerWarning {

    private final String id;
    private final String mediaId;
    private final String authorId;
    private final TriggerCategory category;
    private final int startSeconds;
    private final int endSeconds;
    private final String description;
    private final int severity;

    public TriggerWarning(
            String id,
            String mediaId,
            String authorId,
            TriggerCategory category,
            int startSeconds,
            int endSeconds,
            String description,
            int severity) {

        if (startSeconds < 0 || endSeconds < startSeconds) {
            throw new IllegalArgumentException(
                    "Invalid time range");
        }

        this.id = Objects.requireNonNull(id);
        this.mediaId = Objects.requireNonNull(mediaId);
        this.authorId = Objects.requireNonNull(authorId);
        this.category = Objects.requireNonNull(category);
        this.description = Objects.requireNonNull(description);
        this.startSeconds = startSeconds;
        this.endSeconds = endSeconds;
        this.severity = severity;
    }

    public String getId() {
        return id;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public TriggerCategory getCategory() {
        return category;
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
