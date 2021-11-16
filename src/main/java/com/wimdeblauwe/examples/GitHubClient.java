package com.wimdeblauwe.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Singleton
public class GitHubClient {

    public RepositoryInfo getRepositoryInfo(String owner,
                                            String repo) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.github.com/repos/" + owner + "/" + repo))
                                         .GET()
                                         .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == HttpStatus.OK.getCode()) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), RepositoryInfo.class);
        } else {
            throw new RuntimeException("Error: " + response.statusCode() + " " + response.body());
        }
    }
}
