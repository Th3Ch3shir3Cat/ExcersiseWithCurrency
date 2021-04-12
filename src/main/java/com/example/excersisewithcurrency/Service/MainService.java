package com.example.excersisewithcurrency.Service;
import com.example.excersisewithcurrency.Entity.Currency;
import com.example.excersisewithcurrency.Entity.InfoAboutValute;
import com.example.excersisewithcurrency.Entity.Valute;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MainService {

    private final JsonReader jsonReader = new JsonReader();
    private static int SIZE_LIMIT = 5;

    public List<Valute> getFiveCurrency(){

        Currency currency = new Currency();
        JSONObject resultJson = jsonReader.getJsonString();
        if(resultJson != null){
            currency = getCurrencyFromJson(resultJson);
            if(currency != null){
                return currency.getValutes().values().stream().limit(5).collect(Collectors.toList());
            }
        }
        return null;
    }

    public Currency getCurrencyFromJson(JSONObject resultObject) {
        Currency currency = new Currency();
        try {
            JSONObject arrayObjects = resultObject.getJSONObject("Valute");
            Iterator x = arrayObjects.keys();

            while (x.hasNext()){
                Valute valute = new Valute();
                String key = (String) x.next();
                valute.setName(key);
                JSONObject object = arrayObjects.getJSONObject(key);
                InfoAboutValute infoAboutValute = new InfoAboutValute();
                infoAboutValute.setCharCode(object.get("CharCode").toString());
                infoAboutValute.setName(object.get("Name").toString());
                infoAboutValute.setValue(object.get("Value").toString());
                infoAboutValute.setPrevious(object.get("Previous").toString());
                valute.setInfo(infoAboutValute);
                currency.addValute(Math.abs(Double.parseDouble(infoAboutValute.getValue()) - Double.parseDouble(infoAboutValute.getPrevious())),valute);
            }
        }catch (JSONException e){
            System.out.println(e.getMessage());
        }
        return currency;
    }

}
