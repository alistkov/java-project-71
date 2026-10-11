package hexlet.code;

import java.util.Map;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class Parser {
    public static Map<String, Object> parse(String content, String format) {
        ObjectMapper mapper =
                switch (format) {
                    case "json" -> new ObjectMapper();
                    default -> throw new IllegalArgumentException("Unknown format: " + format);
                };

        return mapper.readValue(content, new TypeReference<>() {});
    }
}
