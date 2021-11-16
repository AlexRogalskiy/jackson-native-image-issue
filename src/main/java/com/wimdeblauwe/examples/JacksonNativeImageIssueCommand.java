package com.wimdeblauwe.examples;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "jackson-native-image-issue", description = "...",
        mixinStandardHelpOptions = true,
        subcommands = GetRepositoryInformationCommand.class)
public class JacksonNativeImageIssueCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(JacksonNativeImageIssueCommand.class, args);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
