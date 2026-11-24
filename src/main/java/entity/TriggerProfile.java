package entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public final class TriggerProfile {
    private final LocalDateTime accountCreated;
    private int numLikes;
    private int numMovieRatings;
    private final Map<TriggerCategory, TriggerPreference> preferences;

    public TriggerProfile() {
        this.accountCreated = LocalDateTime.now();
        this.numLikes = 0;
        this.numMovieRatings = 0;
        this.preferences = new HashMap<>();
    }

    public LocalDateTime getAccountCreated() {
        return accountCreated;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void increaseLikes() {
        this.numLikes += 1;
    }

    public int getNumMovieRatings() {
        return numMovieRatings;
    }

    public void increaseMovieRatings(int numMovieRatings) {
        this.numMovieRatings += 1;
    }

    public TriggerPreference getPreference(TriggerCategory category) {
        return preferences.get(category);
    }

    public void removePreference(TriggerCategory category){
        preferences.remove(category);
    }

    public void addPreference(TriggerCategory category, TriggerPreference preference){
        preferences.put(category, preference);
    }

    public Map<TriggerCategory, TriggerPreference> getPreferences(){
        return new HashMap<>(preferences);
    }

    public boolean hasPreference(TriggerCategory category){
        return preferences.containsKey(category);
    }
}
