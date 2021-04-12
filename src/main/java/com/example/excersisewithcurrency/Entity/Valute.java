package com.example.excersisewithcurrency.Entity;

import java.util.TreeMap;

public class Valute {

    private String name;
    private InfoAboutValute info = new InfoAboutValute();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InfoAboutValute getInfo() {
        return info;
    }

    public void setInfo(InfoAboutValute info) {
        this.info = info;
    }
}
