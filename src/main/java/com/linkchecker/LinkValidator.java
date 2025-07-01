package com.napendra.linkchecker;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.lang.InterruptedException;

public class LinkValidator {
    private String url;
    private static final HttpClient client = HttpClient.newHttpClient();
    public LinkValidator(String url) {
        this.url = url;
    }

    public static int validateLinks(String url) {
        try{
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(url))
            .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode();
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
            return -1;  // Return -1 for unreachable or broken links
        }
    }
}