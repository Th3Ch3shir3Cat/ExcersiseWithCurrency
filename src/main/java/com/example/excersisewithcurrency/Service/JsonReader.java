package com.example.excersisewithcurrency.Service;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JsonReader {

    private static String URL_FOR_CURRENCY = "https://www.cbr-xml-daily.ru/daily_json.js";

    public JSONObject getJsonString(){
        JSONObject resultObject = null;
        try (InputStream is = new URL(URL_FOR_CURRENCY).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String result = readAll(rd);
            resultObject = new JSONObject(result);
        }catch (IOException | JSONException e){
            System.out.println("Не удалось получить Json");
        }
        return resultObject;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

}
