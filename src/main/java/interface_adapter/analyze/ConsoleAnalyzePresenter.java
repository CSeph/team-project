package interface_adapter.analyze;

import entity.TriggerDetection;
import use_case.analyze.AnalyzeOutputBoundary;
import use_case.analyze.AnalyzeOutputData;

import java.io.PrintStream;
import java.util.List;

public class ConsoleAnalyzePresenter implements AnalyzeOutputBoundary {

    private final PrintStream out;

    public ConsoleAnalyzePresenter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void prepareSuccessView(AnalyzeOutputData outputData) {
        List<TriggerDetection> detections = outputData.getDetections();
        if (detections.isEmpty()) {
            out.println("No potential triggers were found.");
            return;
        }
        out.println(detections.size() + " potential trigger(s) found:");
        for (TriggerDetection d : detections) {
            out.printf("  %s - %s  [%s]  \"%s\"  (matched \"%s\", confidence %.0f%%)%n",
                    formatTime(d.getSegment().getStartMillis()),
                    formatTime(d.getSegment().getEndMillis()),
                    d.getCategory().getDisplayName(),
                    d.getSegment().getText(),
                    d.getMatchedTerm(),
                    d.getConfidence() * 100);
        }
    }

    @Override
    public void prepareFailView(String errorMessage) {
        out.println("Error: " + errorMessage);
    }

    static String formatTime(long millis) {
        long totalSeconds = millis / 1000;
        return String.format("%02d:%02d:%02d",
                totalSeconds / 3600, (totalSeconds % 3600) / 60, totalSeconds % 60);
    }
}