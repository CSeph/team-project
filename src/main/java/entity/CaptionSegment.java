package entity;

import java.util.Objects;

public final class CaptionSegment {

    private final long startMillis;
    private final long endMillis;
    private final String text;


    public CaptionSegment(long startMillis, long endMillis, String text) {

        if (endMillis < startMillis) {
            throw new IllegalArgumentException("end before start, error");
        }
        this.startMillis = startMillis;
        this.endMillis = endMillis;
        this.text = Objects.requireNonNull(text, "text can't be null");
    }


    public long getStartMillis() {
        return startMillis;
    }

    public long getEndMillis() {
        return endMillis;
    }

    public String getText() {
        return text;
    }
}
