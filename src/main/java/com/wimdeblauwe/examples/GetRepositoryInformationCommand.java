package com.wimdeblauwe.examples;

import jakarta.inject.Inject;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "get-repo-info")
public class GetRepositoryInformationCommand implements Callable<Void> {
    private final GitHubClient client;

    @CommandLine.Option(names = "--owner", required = true, description = "The name of the repo owner")
    private String owner;

    @CommandLine.Option(names = "--repo", required = true, description = "The name of the repository")
    private String repo;

    @Inject
    public GetRepositoryInformationCommand(GitHubClient client) {
        this.client = client;
    }

    @Override
    public Void call() throws Exception {
        RepositoryInfo repositoryInfo = client.getRepositoryInfo(owner, repo);
        System.out.println(CommandLine.Help.Ansi.AUTO.string("@|bold,fg(green) ✔|@ : " + repositoryInfo.getName() + " - " + repositoryInfo.getDescription()));
        return null;
    }
}
