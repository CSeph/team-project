package use_case.submit_warning;

/**
 * Output data returned after a trigger warning
 * has been submitted successfully.
 */
public final class SubmitWarningOutputData {

    private final String warningId;
    private final String confirmation;

    public SubmitWarningOutputData(
            String warningId,
            String confirmation) {
        this.warningId = warningId;
        this.confirmation = confirmation;
    }

    public String getWarningId() {
        return warningId;
    }

    public String getConfirmation() {
        return confirmation;
    }
}

