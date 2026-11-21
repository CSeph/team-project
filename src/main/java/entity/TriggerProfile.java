package entity;

import java.util.HashMap;
import java.util.Map;

public final class TriggerProfile {

    private final Map<TriggerCategory, TriggerPreference> preferences;

    public TriggerProfile() {
        this.preferences = new HashMap<>();
    }

    public TriggerPreference getPreference(TriggerCategory category) {
        return preferences.get(category);
    }

    public void removePreference(TriggerCategory category){
        preferences.remove(category);
    }

    public Map<TriggerCategory, TriggerPreference> getPreferences(){
        return new HashMap<>(preferences);
    }

    public boolean hasPreference(TriggerCategory category){
        return preferences.containsKey(category);
    }
}
