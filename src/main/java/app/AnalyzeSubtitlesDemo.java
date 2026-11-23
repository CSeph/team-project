package app;

import data_access.SrtCaptionSource;
import detection.DefaultLexicon;
import detection.KeywordTriggerDetector;
import interface_adapter.analyze.AnalyzeController;
import interface_adapter.analyze.ConsoleAnalyzePresenter;
import use_case.analyze.AnalyzeInteractor;

import java.util.List;

public class AnalyzeSubtitlesDemo {

    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : "src/main/resources/sample.srt";

        AnalyzeInteractor interactor = new AnalyzeInteractor(
                new SrtCaptionSource(),
                new KeywordTriggerDetector(DefaultLexicon.create()),
                new ConsoleAnalyzePresenter(System.out));
        AnalyzeController controller = new AnalyzeController(interactor);

        System.out.println("Analyzing " + path + " (all categories)");
        controller.execute(path, List.of());
    }
}