package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.ArrayList;

public class Formatter {
    public static String render(ArrayList<DiffNode> diffTree, String format) {
        return switch (format) {
            case "json" -> Json.render(diffTree);
            case "stylish" -> Stylish.render(diffTree);
            case "plain" -> Plain.render(diffTree);
            default -> throw new IllegalArgumentException("Unknown format: " + format);
        };
    }
}
