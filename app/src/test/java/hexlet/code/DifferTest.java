package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class DifferTest {
    @Test
    public void testPlainJson() throws Exception {
        var actual =
                Differ.generate(
                        "./src/test/resources/hexlet/code/plain1.json",
                        "./src/test/resources/hexlet/code/plain-json2.json");
        var expected =
                Files.readString(
                        Paths.get("./src/test/resources/hexlet/code/expected/expected.txt")
                                .toAbsolutePath()
                                .normalize(),
                        StandardCharsets.UTF_8);
        assertEquals(expected, actual);
    }

    @Test
    public void testPlainYml() throws Exception {
        var actual =
                Differ.generate(
                        "./src/test/resources/hexlet/code/plain1.yaml",
                        "./src/test/resources/hexlet/code/plain2.yaml");
        var expected =
                Files.readString(
                        Paths.get("./src/test/resources/hexlet/code/expected/expected.txt")
                                .toAbsolutePath()
                                .normalize(),
                        StandardCharsets.UTF_8);
        assertEquals(expected, actual);
    }

    @Test
    public void testNestedJson() throws Exception {
        var actual =
                Differ.generate(
                        "./src/test/resources/hexlet/code/nested1.json",
                        "./src/test/resources/hexlet/code/nested2.json");
        var expected =
                Files.readString(
                        Paths.get("./src/test/resources/hexlet/code/expected/expected-nested.txt")
                                .toAbsolutePath()
                                .normalize(),
                        StandardCharsets.UTF_8);
        assertEquals(expected, actual);
    }

    @Test
    public void testNestedYaml() throws Exception {
        var actual =
                Differ.generate(
                        "./src/test/resources/hexlet/code/nested1.yaml",
                        "./src/test/resources/hexlet/code/nested2.yaml");
        var expected =
                Files.readString(
                        Paths.get("./src/test/resources/hexlet/code/expected/expected-nested.txt")
                                .toAbsolutePath()
                                .normalize(),
                        StandardCharsets.UTF_8);
        assertEquals(expected, actual);
    }

    @Test
    public void testPlainFormat() throws Exception {
        var actual =
                Differ.generate(
                        "./src/test/resources/hexlet/code/nested1.json",
                        "./src/test/resources/hexlet/code/nested2.json", "plain");
        var expected =
                Files.readString(
                        Paths.get("./src/test/resources/hexlet/code/expected/expected-plain.txt")
                                .toAbsolutePath()
                                .normalize(),
                        StandardCharsets.UTF_8);
        assertEquals(expected, actual);
    }
}
