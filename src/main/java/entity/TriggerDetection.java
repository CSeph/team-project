package entity;


import java.util.Objects;


public final class TriggerDetection {

    private final TriggerCategory category;
    private final CaptionSegment segment;
    private final String matchedTerm;
    private final double confidence;

    public TriggerDetection(TriggerCategory category, CaptionSegment segment, String matchedTerm, double confidence) {

        if ((confidence < 0.0) || (confidence > 1.0)) {
            throw new IllegalArgumentException("wrong value, not in interval");
        }

        this.category = Objects.requireNonNull(category, "cat can't be null");
        this.segment = Objects.requireNonNull(segment, "seg can't be null");
        this.matchedTerm = Objects.requireNonNull(matchedTerm, "mt can't be null");

        this.confidence = confidence;
    }

    public TriggerCategory getCategory() {
        return category;
    }

    public CaptionSegment getSegment() {
        return segment;
    }

    public String getMatchedTerm() {
        return matchedTerm;
    }

    public double getConfidence() {   //i don't need to get confidence :)
        return confidence;
    }
}