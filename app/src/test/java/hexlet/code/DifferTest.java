package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class DifferTest {
    @Test
    public void testStylish() throws Exception {
        var actual =
                Differ.generate(
                        "./src/test/resources/hexlet/code/file1.json",
                        "./src/test/resources/hexlet/code/file2.json");
        var expected =
                Files.readString(
                        Paths.get("./src/test/resources/hexlet/code/expected/expected.txt")
                                .toAbsolutePath()
                                .normalize(),
                        StandardCharsets.UTF_8);
        assertEquals(expected, actual);
    }

    @Test
    public void testYml() throws Exception {
        var actual =
                Differ.generate(
                        "./src/test/resources/hexlet/code/file1.yaml",
                        "./src/test/resources/hexlet/code/file2.yaml");
        var expected =
                Files.readString(
                        Paths.get("./src/test/resources/hexlet/code/expected/expected.txt")
                                .toAbsolutePath()
                                .normalize(),
                        StandardCharsets.UTF_8);
        assertEquals(expected, actual);
    }
}
