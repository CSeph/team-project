package use_case.analysize;


import entity.CaptionSegment;
import entity.TriggerDetection;
import java.util.List;


public interface TriggerDetector {

    List<TriggerDetection> detect(List<CaptionSegment> segments);
}