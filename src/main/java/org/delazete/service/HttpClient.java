package org.delazete.service;

import org.delazete.config.Config;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient extends Config {
    Config config = new Config();
    private final String apiKey;
    private final String URL;
    public HttpClient(String apiKey, String url) {
        this.apiKey = apiKey;
        this.URL = url;
    }

    public String fetchDataFromApi() throws IOException, InterruptedException {
        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + apiKey + "/latest/ARS")).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
