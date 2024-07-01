package org.delazete.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.delazete.config.Config;
import org.delazete.service.HttpClient;

import java.io.IOException;

public class TransGson {

    public TransGson (){
    }

    public JsonObject TrayendoDatos() throws IOException, InterruptedException {
        Config iniciandoConfig = new Config();
        iniciandoConfig.inicializandoConfig();
        HttpClient servidor = new HttpClient(iniciandoConfig.getApiKey(), iniciandoConfig.getURL());
        String jsonResponse = servidor.fetchDataFromApi();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(jsonResponse);
        JsonObject jsonObj = root.getAsJsonObject();
        return jsonObj;
    }
}
