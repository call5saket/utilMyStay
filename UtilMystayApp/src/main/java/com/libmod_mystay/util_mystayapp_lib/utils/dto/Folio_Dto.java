package com.libmod_mystay.util_mystayapp_lib.utils.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Saket on 11/7/17.
 */

public class Folio_Dto {

    private static Folio_Dto instance;

    public HashMap<Integer,ArrayList<Folio_Dto>> windRw = new HashMap<>();
    public List<Folio_Dto> window;
    public List<Folio_Dto> row;

    public String content="",conversion="",key="",name="",tag="";

    public static Folio_Dto getInstance() {

        if (instance==null){
            instance = new Folio_Dto();
        }

        return instance;
    }

    public static void setInstance(Folio_Dto instance) {
        Folio_Dto.instance = instance;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }



    public List<Folio_Dto> getWindow() {
        return window;
    }

    public void setWindow(List<Folio_Dto> window) {
        this.window = window;
    }

    public List<Folio_Dto> getRow() {
        return row;
    }

    public void setRow(List<Folio_Dto> row) {
        this.row = row;
    }

    public HashMap<Integer, ArrayList<Folio_Dto>> getWindRw() {
        return windRw;
    }

    public void setWindRw(HashMap<Integer, ArrayList<Folio_Dto>> windRw) {
        this.windRw = windRw;
    }
}
