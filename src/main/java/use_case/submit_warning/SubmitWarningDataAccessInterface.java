package use_case.submit_warning;

import entity.TriggerCategory;
import entity.TriggerWarning;

import java.util.Optional;

/**
 * Data access interface for submitting trigger warnings.
 */
public interface SubmitWarningDataAccessInterface {

    /**
     * Finds an existing trigger category by its name.
     *
     * @param categoryName the category's internal name
     * @return the category, if it exists
     */
    Optional<TriggerCategory> findCategoryByName(
            String categoryName);

    /**
     * Saves a submitted trigger warning.
     *
     * @param warning the warning to save
     */
    void saveWarning(TriggerWarning warning);
}

