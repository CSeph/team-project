package data_access;


import entity.CaptionSegment;
import use_case.analysize.CaptionSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;





public class SrtCaptionSource implements CaptionSource {

    @Override
    public List<CaptionSegment> load(String path) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path));
        return parse(lines);
    }

    List<CaptionSegment> parse(List<String> lines) {
        List<CaptionSegment> segments = new ArrayList<>();

        for (int i=0; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("-->")) {
                String[] times = line.split("-->");
                long start = parseTimestamp(times[0]);
                long end = parseTimestamp(times[1]);

                StringBuilder text = new StringBuilder();
                i++;

                while ((i < lines.size()) && (!lines.get(i).isBlank())) {
                    if (text.length() > 0) {
                        text.append(" ");

                    }
                    text.append(lines.get(i).trim());
                    i++;
                }
                segments.add(new CaptionSegment(start, end, text.toString()));
            }
        }
        return segments;
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