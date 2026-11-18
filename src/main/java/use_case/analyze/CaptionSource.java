package use_case.analyze;



import entity.CaptionSegment;
import java.io.IOException;
import java.util.List;


public interface CaptionSource {

    List<CaptionSegment> load(String path) throws IOException;
}

