package use_case.analyze;

import entity.CaptionSegment;
import entity.TriggerCategory;
import entity.TriggerDetection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnalyzeInteractor implements AnalyzeInputBoundary {

    private final CaptionSource captionSource;
    private final TriggerDetector detector;
    private final AnalyzeOutputBoundary presenter;

    public AnalyzeInteractor(CaptionSource captionSource,
                             TriggerDetector detector,
                             AnalyzeOutputBoundary presenter) {
        this.captionSource = captionSource;
        this.detector = detector;
        this.presenter = presenter;
    }

    @Override
    public void execute(AnalyzeInputData inputData) {
        List<CaptionSegment> segments;
        try {
            segments = captionSource.load(inputData.getFilePath());
        } catch (IOException e) {
            presenter.prepareFailView("Could not open the file: " + inputData.getFilePath());
            return;
        } catch (InvalidCaptionFileException e) {
            presenter.prepareFailView("Invalid subtitle file: " + e.getMessage());
            return;
        }

        if (segments.isEmpty()) {
            presenter.prepareFailView("No captions found. Is this an SRT file?");
            return;
        }

        List<TriggerDetection> detections = new ArrayList<>();
        for (TriggerDetection detection : detector.detect(segments)) {
            if (isSelected(detection, inputData)) {
                detections.add(detection);
            }
        }
        detections.sort(Comparator.comparingLong(d -> d.getSegment().getStartMillis()));

        presenter.prepareSuccessView(new AnalyzeOutputData(detections));
    }

    private boolean isSelected(TriggerDetection detection, AnalyzeInputData inputData) {
        List<TriggerCategory> selected = inputData.getSelectedCategories();
        return selected.isEmpty() || selected.contains(detection.getCategory());
    }
}