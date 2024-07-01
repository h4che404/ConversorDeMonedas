package org.delazete;

import com.google.gson.JsonObject;
import org.delazete.utils.TransGson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            TransGson transGson = new TransGson();
            JsonObject jsonData = transGson.TrayendoDatos();
            System.out.println(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}