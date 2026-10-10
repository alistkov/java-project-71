package hexlet.code;

import hexlet.code.formatters.Json;

import java.util.Map;

public class Formatter {
    public static String render (Map<String, Map<String, Object>> tree, String format) {
        return switch (format) {
            case "json" -> Json.render(tree);
            default -> throw new IllegalArgumentException("Unknown format: " + format);
        };
    }
}
