package entity;

public final class TriggerPreference {

    private final TriggerCategory category;
    private final SeverityThreshold severityThreshold;
    private final WarningResponse warningResponse;
    private boolean isSelected;

    public TriggerPreference(TriggerCategory category, SeverityThreshold severityThreshold, WarningResponse warningResponse) {
        if (category == null) {
            throw new IllegalArgumentException("The trigger category cannot be null.");
        }
        if (warningResponse == null) {
            throw new IllegalArgumentException("The warning response to the trigger is invalid.");
        }
        if (severityThreshold == null) {
            throw new IllegalArgumentException("The severity threshold to the trigger is invalid.");
        }

        this.category = category;
        this.severityThreshold = severityThreshold;
        this.warningResponse = warningResponse;
        this.isSelected = false;
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

    public SeverityThreshold getSeverityThreshold() {
        return severityThreshold;
    }

    public WarningResponse getWarningResponse() {
        return warningResponse;
    }

    public void deselect() {
        isSelected = false;
    }

    public void selected(){
        isSelected = true;
    }
}