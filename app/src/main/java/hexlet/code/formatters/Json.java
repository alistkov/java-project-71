package hexlet.code.formatters;

import tools.jackson.databind.ObjectMapper;

import java.util.Map;

public class Json {
    public static String render(Map<String, Map<String, Object>> diff) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(diff);
    }
}
