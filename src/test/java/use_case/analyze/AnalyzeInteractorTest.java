package use_case.analyze;

import entity.CaptionSegment;
import entity.TriggerCategory;
import entity.TriggerDetection;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnalyzeInteractorTest {

    private final TriggerCategory violence = new TriggerCategory("violence", "Violence");
    private final TriggerCategory death = new TriggerCategory("death", "Death");

    private final CaptionSegment early = new CaptionSegment(1000, 2000, "early line");
    private final CaptionSegment late = new CaptionSegment(5000, 6000, "late line");

    /** Records what the interactor sent to the presenter. */
    private static class RecordingPresenter implements AnalyzeOutputBoundary {
        AnalyzeOutputData success;
        String error;

        @Override
        public void prepareSuccessView(AnalyzeOutputData outputData) {
            success = outputData;
        }

        @Override
        public void prepareFailView(String errorMessage) {
            error = errorMessage;
        }
    }

    private CaptionSource sourceReturning(List<CaptionSegment> segments) {
        return path -> segments;
    }

    /** Returns detections in reverse time order, to check that the interactor sorts. */
    private TriggerDetector detectorReturning() {
        return segments -> List.of(
                new TriggerDetection(death, late, "dead", 0.6),
                new TriggerDetection(violence, early, "kill", 0.6));
    }

    @Test
    void successSortsDetectionsByStartTime() {
        RecordingPresenter presenter = new RecordingPresenter();
        AnalyzeInteractor interactor = new AnalyzeInteractor(
                sourceReturning(List.of(early, late)), detectorReturning(), presenter);

        interactor.execute(new AnalyzeInputData("movie.srt", List.of()));

        assertNull(presenter.error);
        List<TriggerDetection> result = presenter.success.getDetections();
        assertEquals(2, result.size());
        assertEquals(early, result.get(0).getSegment());
        assertEquals(late, result.get(1).getSegment());
    }

    @Test
    void onlyKeepsSelectedCategories() {
        RecordingPresenter presenter = new RecordingPresenter();
        AnalyzeInteractor interactor = new AnalyzeInteractor(
                sourceReturning(List.of(early, late)), detectorReturning(), presenter);

        interactor.execute(new AnalyzeInputData("movie.srt", List.of(death)));

        List<TriggerDetection> result = presenter.success.getDetections();
        assertEquals(1, result.size());
        assertEquals(death, result.get(0).getCategory());
    }

    @Test
    void unreadableFileFails() {
        RecordingPresenter presenter = new RecordingPresenter();
        CaptionSource broken = path -> {
            throw new IOException("missing");
        };
        AnalyzeInteractor interactor = new AnalyzeInteractor(broken, detectorReturning(), presenter);

        interactor.execute(new AnalyzeInputData("missing.srt", List.of()));

        assertNull(presenter.success);
        assertTrue(presenter.error.contains("Could not open"));
    }

    @Test
    void invalidFileFails() {
        RecordingPresenter presenter = new RecordingPresenter();
        CaptionSource invalid = path -> {
            throw new InvalidCaptionFileException("bad timestamp line");
        };
        AnalyzeInteractor interactor = new AnalyzeInteractor(invalid, detectorReturning(), presenter);

        interactor.execute(new AnalyzeInputData("bad.srt", List.of()));

        assertTrue(presenter.error.contains("Invalid subtitle file"));
    }

    @Test
    void noTriggersIsStillSuccess() {
        RecordingPresenter presenter = new RecordingPresenter();
        TriggerDetector findsNothing = segments -> new ArrayList<>();
        AnalyzeInteractor interactor = new AnalyzeInteractor(
                sourceReturning(List.of(early)), findsNothing, presenter);

        interactor.execute(new AnalyzeInputData("movie.srt", List.of()));

        assertNull(presenter.error);
        assertTrue(presenter.success.getDetections().isEmpty());
    }
}