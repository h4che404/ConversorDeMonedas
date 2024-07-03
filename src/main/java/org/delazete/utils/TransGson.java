package org.delazete.utils;

import com.google.gson.Gson;
import org.delazete.config.Config;
import org.delazete.models.Monedas;
import org.delazete.service.HttpClient;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TransGson {
    Map<String, Monedas> cache = new HashMap<>();

    public TransGson (){
    }

    private String obtenerFechaActual() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaActual.format(formatter); // Devuelve la fecha en formato "yyyy-MM-dd"
    }

    public Monedas TrayendoDatos() throws IOException, InterruptedException {
        String key = obtenerFechaActual();
        Monedas entry = cache.get(key);
        if (entry == null){

            Config iniciandoConfig = new Config();
            iniciandoConfig.inicializandoConfig();
            HttpClient servidor = new HttpClient(iniciandoConfig.getApiKey(), iniciandoConfig.getURL(), iniciandoConfig.getTipoDeMoneda());
            String jsonResponse = servidor.fetchDataFromApi();
            Gson gson = new Gson();
            Monedas moneda = gson.fromJson(jsonResponse, Monedas.class);
            cache.put(key, moneda);
            return moneda;
        }else {
            return entry;
        }

    }
}
