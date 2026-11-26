package data_access.trigger_warning;

import entity.TriggerCategory;
import entity.TriggerWarning;
import use_case.submit_warning.SubmitWarningDataAccessInterface;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Stores community trigger warnings in memory.
 */
public final class InMemoryWarningDataAccessObject
        implements SubmitWarningDataAccessInterface {

    private final Map<String, TriggerCategory> categories =
            new HashMap<>();

    private final Map<String, TriggerWarning> warnings =
            new HashMap<>();

    /**
     * Creates a DAO with the available trigger categories.
     *
     * @param initialCategories existing trigger categories
     */
    public InMemoryWarningDataAccessObject(
            Collection<TriggerCategory> initialCategories) {

        for (TriggerCategory category : initialCategories) {
            categories.put(category.getName(), category);
        }
    }

    @Override
    public Optional<TriggerCategory> findCategoryByName(
            String categoryName) {

        return Optional.ofNullable(
                categories.get(categoryName));
    }

    @Override
    public void saveWarning(TriggerWarning warning) {

        Objects.requireNonNull(warning, "warning");

        warnings.put(warning.getId(), warning);
    }

    /**
     * Finds a saved warning by its ID.
     *
     * @param warningId the warning ID
     * @return the saved warning, if present
     */
    public Optional<TriggerWarning> findWarningById(
            String warningId) {

        return Optional.ofNullable(
                warnings.get(warningId));
    }
}
