package com.example.excersisewithcurrency.Entity;

import java.util.Collections;
import java.util.TreeMap;

public class Currency {

    private TreeMap<Double, Valute> valutes = new TreeMap<>(Collections.reverseOrder());

    public TreeMap<Double, Valute> getValutes() {
        return valutes;
    }

    public void setValutes(TreeMap<Double, Valute> valutes) {
        this.valutes = valutes;
    }

    public void addValute(Double difference,Valute valute){
        this.valutes.put(difference,valute);
    }
}
