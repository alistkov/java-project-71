package hexlet.code;

import java.util.Map;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.dataformat.yaml.YAMLMapper;

public class Parser {
    public static Map<String, Object> parse(String content, String format) {
        ObjectMapper mapper =
                switch (format) {
                    case "json" -> new ObjectMapper();
                    case "yml", "yaml" -> new YAMLMapper();
                    default -> throw new IllegalArgumentException("Unknown format: " + format);
                };

        return mapper.readValue(content, new TypeReference<>() {});
    }
}
