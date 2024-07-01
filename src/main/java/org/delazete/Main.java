package org.delazete;

import org.delazete.config.Config;
import org.delazete.service.HttpClient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String confirmacion;
        Config iniciandoConfig = new Config();
        iniciandoConfig.inicializandoConfig();
        HttpClient httpClient = new HttpClient(iniciandoConfig.getApiKey(), iniciandoConfig.getURL());
        // Lógica para consumir la API
        try {
           confirmacion = httpClient.fetchDataFromApi();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(confirmacion);
    }
}