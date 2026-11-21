package data_access;

import entity.CaptionSegment;
import org.junit.jupiter.api.Test;


import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


class SrtCaptionSourceTest {

    @Test
    void parsesSingleCaption() {
        List<String> lines = List.of("1", "00:00:01,000 --> 00:00:04,500", "Hello there");

        List<CaptionSegment> segments = new SrtCaptionSource().parse(lines);


        assertEquals(1, segments.size());

        CaptionSegment segment = segments.get(0);

        assertEquals(1000, segment.getStartMillis());
        assertEquals(4500, segment.getEndMillis());
        assertEquals("Hello there", segment.getText());

    }

    @Test
    void parsesMultipleCaptionsAndJoinsLines() {
        List<String> lines = List.of("1", "00:00:01,000 --> 00:00:02,000", "First",
                "",
                "2", "00:00:03,000 --> 00:00:05,000", "I heard a gunshot", "outside the house.");

        List<CaptionSegment> segments = new SrtCaptionSource().parse(lines);

        assertEquals(2, segments.size());

        CaptionSegment segment = segments.get(1);

        assertEquals("I heard a gunshot outside the house.", segment.getText());

    }
}

