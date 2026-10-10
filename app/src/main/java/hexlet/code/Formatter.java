package hexlet.code;

import hexlet.code.formatters.Json;

import java.util.ArrayList;
import java.util.Map;

public class Formatter {
    public static String render (ArrayList<DiffNode> diffTree, String format) {
        return switch (format) {
            case "json" -> Json.render(diffTree);
            default -> throw new IllegalArgumentException("Unknown format: " + format);
        };
    }
}
