package detection;

import entity.TriggerCategory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class DefaultLexicon {

    public static final TriggerCategory VIOLENCE = new TriggerCategory("violence", "Violence");
    public static final TriggerCategory GUNS = new TriggerCategory("guns", "Guns / Gunshots");
    public static final TriggerCategory SELF_HARM = new TriggerCategory("self_harm", "Self-harm");
    public static final TriggerCategory SUBSTANCE_USE = new TriggerCategory("substance_use", "Substance use");
    public static final TriggerCategory DEATH = new TriggerCategory("death", "Death");

    private DefaultLexicon() {
    }

    public static Map<TriggerCategory, List<String>> create() {
        Map<TriggerCategory, List<String>> lexicon = new LinkedHashMap<>();
        lexicon.put(VIOLENCE, List.of("kill", "kills", "killed", "killing", "stab", "stabbed",
                "stabbing", "blood", "bleeding", "murder", "murdered"));
        lexicon.put(GUNS, List.of("gun", "guns", "gunshot", "gunshots", "shoot", "shot", "shots",
                "shooting", "bullet", "bullets"));
        lexicon.put(SELF_HARM, List.of("suicide", "kill myself", "hurt myself", "cut myself",
                "self-harm", "overdose", "overdosed"));
        lexicon.put(SUBSTANCE_USE, List.of("drunk", "cocaine", "heroin", "pills", "drugs", "needle"));
        lexicon.put(DEATH, List.of("dead", "died", "dying", "death", "funeral", "corpse"));
        return lexicon;
    }
}