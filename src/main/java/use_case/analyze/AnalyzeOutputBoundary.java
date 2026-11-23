package use_case.analyze;

public interface AnalyzeOutputBoundary {

    void prepareSuccessView(AnalyzeOutputData outputData);

    void prepareFailView(String errorMessage);
}