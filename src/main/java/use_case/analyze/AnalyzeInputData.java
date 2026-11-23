package use_case.analyze;

import entity.TriggerCategory;

import java.util.List;
import java.util.Objects;

public final class AnalyzeInputData {

    private final String filePath;
    private final List<TriggerCategory> selectedCategories;

    public AnalyzeInputData(String filePath, List<TriggerCategory> selectedCategories) {
        this.filePath = Objects.requireNonNull(filePath, "filePath can't be null");
        this.selectedCategories = List.copyOf(
                Objects.requireNonNull(selectedCategories, "selectedCategories can't be null"));
    }

    public String getFilePath() {
        return filePath;
    }

    public List<TriggerCategory> getSelectedCategories() {
        return selectedCategories;
    }
}