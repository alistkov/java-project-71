package hexlet.code.formatters;

import hexlet.code.DiffNode;
import hexlet.code.Status;

import java.util.ArrayList;

public class Plain {
    public static String render(ArrayList<DiffNode> diffTree) {
        var result = new StringBuilder();

        for (var node : diffTree) {
            var status = node.status();

            if (status.equals(Status.DELETED)) {
                result.append("Property '")
                        .append(node.key())
                        .append("' was removed")
                        .append("\n");
            } else if (status.equals(Status.ADDED)) {
                result.append("Property '")
                        .append(node.key())
                        .append("' was added with value: ")
                        .append(renderValue(node.newValue()))
                        .append("\n");
            } else if (status.equals(Status.CHANGED)){
                result.append("Property '")
                        .append(node.key())
                        .append("' was updated. From ")
                        .append(renderValue(node.oldValue()))
                        .append(" to ")
                        .append(renderValue(node.newValue()))
                        .append("\n");
            }
        }
        return result.toString().trim();
    }

    private static String renderValue(Object value) {
        return switch (value) {
            case null -> "null";
            case String s -> String.format("'%s'", s);
            case Number n -> n.toString();
            case Boolean b -> b.toString();
            default -> "[complex value]";
        };
    }
}
