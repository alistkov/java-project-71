package hexlet.code;

import tools.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Differ {
    public static String generate(String path1, String path2) throws Exception {
        return Differ.generate(path1, path2, "stylish");
    }

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        var normalizePath1 = Paths.get(filePath1).toAbsolutePath().normalize();
        var normalizePath2 = Paths.get(filePath2).toAbsolutePath().normalize();

        var content1 = Parser.parse(Files.readString(normalizePath1), getFormat(filePath1));
        var content2 = Parser.parse(Files.readString(normalizePath2), getFormat(filePath2));
        var diffTree = DiffTree.build(content1, content2);

        return Formatter.render(diffTree, format);
    }

    private static String getFormat(String path) {
        int index = path.lastIndexOf(".");
        return index == -1 ? "" : path.substring(index + 1).toLowerCase();
    }
}
