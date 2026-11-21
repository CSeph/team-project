package detection;

import entity.CaptionSegment;
import entity.TriggerCategory;
import entity.TriggerDetection;
import use_case.analyze.TriggerDetector;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;


public class KeywordTriggerDetector implements TriggerDetector {

    private final Map<TriggerCategory, List<String>> lexicon;

    private static final double KEYWORD_CONFIDENCE = 0.6;

    public KeywordTriggerDetector(Map<TriggerCategory, List<String>> lexicon) {
        this.lexicon = lexicon;
    }


    @Override
    public List<TriggerDetection> detect(List<CaptionSegment> segments) {

        List<TriggerDetection> detections = new ArrayList<>();

        for (CaptionSegment segment : segments) {
            String text = segment.getText().toLowerCase(Locale.ROOT);
            for (Map.Entry<TriggerCategory, List<String>> entry : lexicon.entrySet()) {
                TriggerCategory category = entry.getKey();
                List<String> words = entry.getValue();

                for (String word : words) {

                    if (containsWholeWord(text, word.toLowerCase(Locale.ROOT))) {
                        detections.add(new TriggerDetection(category, segment, word, KEYWORD_CONFIDENCE));
                    }
                }

            }
        }
        return detections;
    }

    private boolean containsWholeWord(String text, String word) {
        String regex = "\\b" + Pattern.quote(word) + "\\b";

        return Pattern.compile(regex).matcher(text).find();
    }

}
