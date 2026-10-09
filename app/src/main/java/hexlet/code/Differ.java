package hexlet.code;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.nio.file.Paths;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        var mapper = new ObjectMapper();
        var path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        var path2 = Paths.get(filePath2).toAbsolutePath().normalize();
        var fileContent1 = mapper.readValue(path1, new TypeReference<>() {});
        var fileContent2 = mapper.readValue(path2, new TypeReference<>() {});

        System.out.println(fileContent1);
        System.out.println(fileContent2);
        return "";
    }
}
