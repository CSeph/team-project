
package use_case.submit_warning;

/**
 * Output boundary for the Submit Trigger Warning use case.
 */
public interface SubmitWarningOutputBoundary {

    /**
     * Called when a trigger warning is submitted successfully.
     *
     * @param outputData the result of the submission
     */
    void prepareSuccessView(SubmitWarningOutputData outputData);

    /**
     * Called when the submission fails.
     *
     * @param errorMessage explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
