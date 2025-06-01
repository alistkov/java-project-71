package hexlet.code;

import picocli.CommandLine;

@CommandLine.Command(
    name = "gendiff",
    description = "Compares two configuration files and shows a difference.",
    version = "0.0.1",
    mixinStandardHelpOptions = true
)
public class Differ {
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
}
