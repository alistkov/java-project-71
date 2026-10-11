package hexlet.code.formatters;

import hexlet.code.DiffNode;
import hexlet.code.Status;
import java.util.ArrayList;

public class Stylish {
    public static String render(ArrayList<DiffNode> diffTree) {
        var result = new StringBuilder("{\n");

        for (var node : diffTree) {
            var status = node.status();

            if (status.equals(Status.DELETED)) {
                result.append("  - ")
                        .append(node.key())
                        .append(": ")
                        .append(node.oldValue())
                        .append("\n");
            } else if (status.equals(Status.UNCHANGED)) {
                result.append("    ")
                        .append(node.key())
                        .append(": ")
                        .append(node.oldValue())
                        .append("\n");
            } else if (status.equals(Status.ADDED)) {
                result.append("  + ")
                        .append(node.key())
                        .append(": ")
                        .append(node.newValue())
                        .append("\n");
            } else {
                result.append("  - ")
                        .append(node.key())
                        .append(": ")
                        .append(node.oldValue())
                        .append("\n");
                result.append("  + ")
                        .append(node.key())
                        .append(": ")
                        .append(node.newValue())
                        .append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }
}
