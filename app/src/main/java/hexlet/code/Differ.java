package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String path1, String path2) throws Exception {
        return Differ.generate(path1, path2, "stylish");
    }

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        var content1 = getFileContent(filePath1);
        var content2 = getFileContent(filePath2);
        var diffTree = DiffTree.build(content1, content2);

        return Formatter.render(diffTree, format);
    }

    private static Map<String,Object> getFileContent(String filePath) throws Exception {
        var normalizePath = Paths.get(filePath).toAbsolutePath().normalize();
        return Parser.parse(Files.readString(normalizePath), getFormat(filePath));
    }

    private static String getFormat(String path) {
        int index = path.lastIndexOf(".");
        return index == -1 ? "" : path.substring(index + 1).toLowerCase();
    }
}
