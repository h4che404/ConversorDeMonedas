package org.delazete.config;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    Properties propiedades = new Properties();

    public void inicializandoConfig() throws IOException {
        var path = Paths.get("opciones.properties");
        var in = Files.newInputStream(path);
        propiedades.load(in);
        /*
        propiedades.setProperty("ApiKey","0f9d05f271f5e78235f2ef58");
        propiedades.setProperty("URL","https://v6.exchangerate-api.com/v6/");

        var path = Paths.get("opciones.properties");
        var oos = Files.newOutputStream(path);
        propiedades.store(oos, "Access");
        System.out.println("Se creo");
         */
    }
    public String getApiKey() throws IOException {
        return propiedades.getProperty("ApiKey");
    }
    public String getURL() {
        return propiedades.getProperty("URL");
    }

}
