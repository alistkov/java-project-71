package hexlet.code;

public enum Status {
    ADDED("added"),
    DELETED("deleted"),
    CHANGED("changed"),
    UNCHANGED("unchanged");

    private final String label;

    private Status(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
