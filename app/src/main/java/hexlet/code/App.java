package hexlet.code;

import picocli.CommandLine;
import java.util.concurrent.Callable;

@CommandLine.Command(
    name = "gendiff",
    description = "Compares two configuration files and shows a difference.",
    version = "0.0.2",
    mixinStandardHelpOptions = true
)
public class App implements Callable<Integer> {
    @CommandLine.Parameters(
        paramLabel = "filePath1",
        description = "path to first file")
    private String filePath1;

    @CommandLine.Parameters(
        paramLabel = "filePath2",
        description = "path to second file")
    private String filePath2;

    @CommandLine.Option(
        names = {"-h", "--help"},
        usageHelp = true,
        description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @CommandLine.Option(
        names = { "-V", "--version" },
        versionHelp = true,
        description = "Print version information and exit.")
    boolean versionRequested;

    @CommandLine.Option(
        names = { "-f", "--format" },
        defaultValue = "stylish",
        paramLabel = "format",
        description = "output format [default: ${DEFAULT-VALUE}]")
    private String format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        var diff = Differ.generate(filePath1, filePath2);
        System.out.println(diff);

        return 0;
    }
}
