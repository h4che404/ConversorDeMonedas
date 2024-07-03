package org.delazete.service;

import org.delazete.config.Config;
import org.delazete.models.Menu;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient extends Config {
    Config config = new Config();
    private final String apiKey;
    private final String URL;
    public String monedaPrincipal;

    public HttpClient(String apiKey, String url, String monedaPrincipal) {
        this.apiKey = apiKey;
        this.URL = url;
        this.monedaPrincipal = monedaPrincipal;
    }

    public String fetchDataFromApi() throws IOException, InterruptedException {
        Menu menu = new Menu();


        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + apiKey + "/latest/" + monedaPrincipal)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

}
