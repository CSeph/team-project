package use_case.submit_warning;

import entity.TriggerCategory;
import entity.TriggerWarning;

import java.util.Optional;
import java.util.UUID;

/**
 * Implements the Submit Trigger Warning use case.
 */
public final class SubmitWarningInteractor
        implements SubmitWarningInputBoundary {

    private final SubmitWarningDataAccessInterface dataAccess;
    private final SubmitWarningOutputBoundary outputBoundary;

    public SubmitWarningInteractor(
            SubmitWarningDataAccessInterface dataAccess,
            SubmitWarningOutputBoundary outputBoundary) {

        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(SubmitWarningInputData inputData) {

        // Step 1: Validate the input.
        if (inputData == null) {
            outputBoundary.prepareFailView("Missing input data.");
            return;
        }

        if (isBlank(inputData.getMediaId())
                || isBlank(inputData.getAuthorId())) {
            outputBoundary.prepareFailView(
                    "Media ID and author ID are required.");
            return;
        }

        if (isBlank(inputData.getCategoryName())) {
            outputBoundary.prepareFailView(
                    "Please select a trigger category.");
            return;
        }

        if (isBlank(inputData.getDescription())) {
            outputBoundary.prepareFailView(
                    "Description cannot be empty.");
            return;
        }

        if (inputData.getStartSeconds() < 0
                || inputData.getEndSeconds()
                < inputData.getStartSeconds()) {
            outputBoundary.prepareFailView(
                    "Invalid time range.");
            return;
        }

        try {
            // Step 2: Find the selected category.
            Optional<TriggerCategory> category =
                    dataAccess.findCategoryByName(
                            inputData.getCategoryName());

            if (category.isEmpty()) {
                outputBoundary.prepareFailView(
                        "Trigger category does not exist.");
                return;
            }

            // Step 3: Generate an ID.
            String warningId = UUID.randomUUID().toString();

            // Step 4: Create the entity.
            TriggerWarning warning = new TriggerWarning(
                    warningId,
                    inputData.getMediaId(),
                    inputData.getAuthorId(),
                    category.get(),
                    inputData.getStartSeconds(),
                    inputData.getEndSeconds(),
                    inputData.getDescription(),
                    inputData.getSeverity()
            );

            // Step 5: Save through the data access interface.
            dataAccess.saveWarning(warning);

            // Step 6: Report success.
            SubmitWarningOutputData outputData =
                    new SubmitWarningOutputData(
                            warningId,
                            "Trigger warning submitted successfully."
                    );

            outputBoundary.prepareSuccessView(outputData);

        }
        catch (RuntimeException exception) {
            outputBoundary.prepareFailView(
                    "Unable to submit trigger warning.");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
