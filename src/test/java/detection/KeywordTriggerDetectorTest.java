package detection;



import entity.CaptionSegment;
import entity.TriggerCategory;
import entity.TriggerDetection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



class KeywordTriggerDetectorTest {

    private TriggerCategory violence;
    private KeywordTriggerDetector detector;

    @BeforeEach
    void setUp() {
        violence = new TriggerCategory("violence", "Violence");
        detector = new KeywordTriggerDetector(Map.of(violence, List.of("kill", "shot dead")));
    }

    private List<TriggerDetection> detectIn(String captionText) {
        return detector.detect(List.of(new CaptionSegment(0,1000, captionText)));
    }


    @Test
    void detectsKeywordInCaption() {

        List<TriggerDetection> detections = detectIn("He will KILL you!");

        assertEquals(1, detections.size());
        assertEquals(violence, detections.get(0).getCategory());
        assertEquals("kill", detections.get(0).getMatchedTerm());
    }

    @Test
    void ignoreKeywordInsideOtherWord() {
        List<TriggerDetection> detections = detectIn("I have a new skill");

        assertTrue(detections.isEmpty());
    }


    @Test
    void detectMultiWordPhrase() {
        List<TriggerDetection> detections = detectIn("He was shot dead.");

        assertEquals(1, detections.size());
        assertEquals("shot dead", detections.get(0).getMatchedTerm());
    }
}

