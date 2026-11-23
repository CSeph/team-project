package interface_adapter.analyze;

import entity.TriggerCategory;
import use_case.analyze.AnalyzeInputBoundary;
import use_case.analyze.AnalyzeInputData;

import java.util.List;

public class AnalyzeController {

    private final AnalyzeInputBoundary interactor;

    public AnalyzeController(AnalyzeInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String filePath, List<TriggerCategory> selectedCategories) {
        interactor.execute(new AnalyzeInputData(filePath, selectedCategories));
    }
}