package hexlet.code.formatters;

import hexlet.code.DiffNode;
import hexlet.code.Status;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import tools.jackson.core.util.DefaultIndenter;
import tools.jackson.core.util.DefaultPrettyPrinter;
import tools.jackson.databind.json.JsonMapper;

public class Json {
    public static String render(ArrayList<DiffNode> diffTree) {
        DefaultPrettyPrinter printer =
                new DefaultPrettyPrinter()
                        .withArrayIndenter(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        var mapper = JsonMapper.builder().defaultPrettyPrinter(printer).build();
        var result = new ArrayList<>();

        for (var node : diffTree) {
            Map<String, Object> mapTree = new LinkedHashMap<>();
            mapTree.put("key", node.key());
            mapTree.put("status", node.status().toString());

            if (node.status().equals(Status.DELETED)) {
                mapTree.put("old value", node.oldValue());
            } else if (node.status().equals(Status.ADDED)) {
                mapTree.put("new value", node.newValue());
            } else if (node.status().equals(Status.UNCHANGED)) {
                mapTree.put("value", node.oldValue());
            } else {
                mapTree.put("old value", node.oldValue());
                mapTree.put("new value", node.newValue());
            }
            result.add(mapTree);
        }
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
    }
}
