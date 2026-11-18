package entity;

import java.util.Objects;

public final class TriggerCategory {

    private final String name;
    private final String displayName;

    public TriggerCategory(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }


    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TriggerCategory)) {
            return false;

        }
        TriggerCategory other = (TriggerCategory) o;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return displayName;
    }

}