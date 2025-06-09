package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final DefaultPrettyPrinter printer = new DefaultPrettyPrinter();

    public static String generate(String filePath1, String filePath2) throws Exception {
        var file1AbsolutePath = Paths.get(filePath1).toAbsolutePath().normalize();
        var file2AbsolutePath = Paths.get(filePath2).toAbsolutePath().normalize();

        var file1Content = Files.readString(file1AbsolutePath);
        var file2Content = Files.readString(file2AbsolutePath);
        var file1Data = getData(file1Content);
        var file2Data = getData(file2Content);


        return file1Data + "\n" + file2Data;
    }

    public static Map getData(String content) throws Exception {
        return  mapper.readValue(
            content,
            new TypeReference<Map<String, Object>>() {}
        );
    }
}
