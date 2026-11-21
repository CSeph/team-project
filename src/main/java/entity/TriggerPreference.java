package entity;

public final class TriggerPreference {

    private final TriggerCategory category;
    private final int severityThreshold;
    private final String warningResponse;

    public TriggerPreference(TriggerCategory category, int severityThreshold, String warningResponse) {
        if (category == null) {
            throw new IllegalArgumentException("The trigger category cannot be null.");
        }
        if (warningResponse == null || !isValidWarningResponse(warningResponse)) {
            throw new IllegalArgumentException("The warning response to the trigger is invalid.");
        }

        this.category = category;
        this.severityThreshold = severityThreshold;
        this.warningResponse = warningResponse;
    }

    private boolean isValidSeverity(String severityThreshold) {
        return severityThreshold.equalsIgnoreCase("Low") || severityThreshold.equalsIgnoreCase("Medium") || severityThreshold.equalsIgnoreCase("High");
    }

    private boolean isValidWarningResponse(String warningResponse) {
        return warningResponse.equalsIgnoreCase("ShowWarningDescription") || warningResponse.equalsIgnoreCase("BlurContent") || warningResponse.equalsIgnoreCase("SkipContent");
    }

    public TriggerCategory getCategory() {
        return category;
    }

    public int getSeverityThreshold() {
        return severityThreshold;
    }

    public String getWarningResponse() {
        return warningResponse;
    }
}