package com.libmod_mystay.util_mystayapp_lib.utils.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.libmod_mystay.util_mystayapp_lib.utils.dto.Folio_xml_dto;
import com.libmod_mystay.util_mystayapp_lib.utils.dto.Login_dto;
import com.libmod_mystay.util_mystayapp_lib.utils.dto.Tv_Channels_dto;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saket on 20/6/17.
 */

public class SharedData {

    private final String butler_primitive_db_name = "my_stay_app_db";
    private final SharedPreferences sharedPreferencess;
    private final SharedPreferences.Editor editior;
    private final String tvChnlStatus="tvChnnl_Mov";
    private final String loginDtl="logiDto";
    private final String chckLogIn="LoggedIn";
    private final String favourite="favourite";


    public SharedData(Context context){
        sharedPreferencess =context.getSharedPreferences(butler_primitive_db_name, Context.MODE_PRIVATE);
        editior = sharedPreferencess.edit();
    }

    public  boolean chkContainKey(String key){

        if (sharedPreferencess.contains(key)){
           return true;
        }

        return false;
    }

    public void saveTvChnlState(String key, boolean val){

        editior.putBoolean(key,val);
        editior.commit();
    }

    public boolean getTvMovStatus(String key){

        return sharedPreferencess.getBoolean(tvChnlStatus,false);
    }

    public void loggedIn(boolean val){
        editior.putBoolean(chckLogIn,val);
        editior.commit();

    }
    public boolean isLoggedIn(){
        return sharedPreferencess.getBoolean(chckLogIn,false);
    }

    public void saveGridOgj(Folio_xml_dto view, String key){
        Gson gson = new Gson();
        String json = gson.toJson(view);
        editior.putString(key, json);
        editior.commit();

    }

    public Folio_xml_dto getGridObj(String key){
        Gson gson = new Gson();
        String json = sharedPreferencess.getString(key, "");
        Folio_xml_dto obj = gson.fromJson(json, Folio_xml_dto.class);

        return obj;
    }

    public void saveLogin(Login_dto logiN){
        Gson gson = new Gson();
        String json= gson.toJson(logiN);
        editior.putString(loginDtl,json);
        editior.commit();

    }

    public Login_dto getLogDtl(){
        Gson gson = new Gson();
        String logJson = sharedPreferencess.getString(loginDtl,"");
        Login_dto loObj = gson.fromJson(logJson,Login_dto.class);

        return loObj;
    }

    public List<Tv_Channels_dto> getFavourite(){
        Gson gson = new Gson();
        List<Tv_Channels_dto> lstFav = new ArrayList<Tv_Channels_dto>();

        String jsonPreferences = sharedPreferencess.getString(favourite, "");

        Type type = new TypeToken<List<Tv_Channels_dto>>() {}.getType();
        lstFav = gson.fromJson(jsonPreferences, type);
        return lstFav;
    }

    public void setFavourite(List<Tv_Channels_dto> sveFav){

        Gson gson = new Gson();

        String json = gson.toJson(sveFav);

        editior.putString(favourite, json);
        editior.commit();
    }

}
