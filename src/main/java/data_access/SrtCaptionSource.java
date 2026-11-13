package data_access;


import entity.CaptionSegment;
import use_case.analyze.CaptionSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class SrtCaptionSource implements CaptionSource {

    @Override
    public List<CaptionSegment> load(String path) throws IOException {
        return new ArrayList<>();
    }

    private long parseTimestamp(String timestamp) {
        String[] parts = timestamp.trim().split(":");

        long hours = Long.parseLong(parts[0]);
        long minutes = Long.parseLong(parts[1]);

        String[] secAndMillis = parts[2].split(",");

        long seconds = Long.parseLong(secAndMillis[0]);
        long millis = Long.parseLong(secAndMillis[1]);


        return hours * 3_600_000 + minutes * 60_000 + seconds * 1_000 + millis;
    }
}