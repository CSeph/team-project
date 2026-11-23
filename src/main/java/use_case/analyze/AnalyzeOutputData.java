package use_case.analyze;

import entity.TriggerDetection;

import java.util.List;

public final class AnalyzeOutputData {

    private final List<TriggerDetection> detections;

    public AnalyzeOutputData(List<TriggerDetection> detections) {
        this.detections = List.copyOf(detections);
    }

    public List<TriggerDetection> getDetections() {
        return detections;
    }
}