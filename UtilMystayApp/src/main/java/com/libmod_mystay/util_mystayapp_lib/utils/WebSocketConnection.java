package com.libmod_mystay.util_mystayapp_lib.utils;

import android.util.Log;



import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Saket on 28/6/17.
 */

public class WebSocketConnection {
    public static WebSocketClient mWebsocket;
    //public WebSocketClient mWebsocket;
    public static boolean closBol;

    public static String response="";

    public static String evntStatus="";



    private static JSONObject jsonObj;


    // webSocket connection --------------Saket....

    public static void connectWebSocket() {
       // http://172.17.4.1:8014/tcp
  //main-        //ws://192.168.3.92:18444/


        URI uri;
        try {
            uri = new URI(ConstatLib.webSocket);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }


        mWebsocket = new WebSocketClient(uri, new Draft_17()) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {

                Log.e("Websocket", "Opened");

                // mWebsocket.send("Hello_Socket_Send");
            }

            @Override
            public void onMessage(String message) {
               // Toast.makeText(WebSocketConnection, "Message Recived---" + message, Toast.LENGTH_SHORT).show();

                Log.e("onMessage_Recv----",message);

                 jsonObj = null;
                try {
                    jsonObj = XML.toJSONObject(message);

                    setJsonObj(jsonObj);
                /*    parseJson();
                    Folio_xml_dto dto = jsonParse(jsonObj.toString());
                    callBack_clickEvent.getStatus(dto);
*/
                    Log.e("onMessage_Recv-------rcvJson",jsonObj.toString());
                } catch (JSONException e) {
                    Log.e("onMessage_Recv-------rcvJson", e.getMessage());
                    e.printStackTrace();
                }
              /*  try {
                    JSONObject job = new JSONObject(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
                response=message;
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                Log.e("Websocket", "Closed " + remote);

                setClosBol(remote);
            }

            @Override
            public void onError(Exception e) {
                Log.e("Websocket", "Error " + e.getMessage());
            }
        };

        mWebsocket.connect();


        // mWebsocket.onMessage();

    }

    public static boolean isClosBol() {
        return closBol;
    }

    public static void setClosBol(boolean closBol) {
        WebSocketConnection.closBol = closBol;
    }

    public static String getEvntStatus() {
        return evntStatus;
    }

    public static void setEvntStatus(String evntStatus) {
        WebSocketConnection.evntStatus = evntStatus;
    }

    public static JSONObject getJsonObj() {
        return jsonObj;
    }

    public static void setJsonObj(JSONObject jsonObj) {
        WebSocketConnection.jsonObj = jsonObj;
    }

    /*  public static Folio_xml_dto jsonParse(String jsonOutput){
        Folio_xml_dto dto;



        try {
            dto = (Folio_xml_dto) new Gson().fromJson(jsonOutput, new TypeToken<Folio_xml_dto>(){}.getType());
            return dto;
        }catch (Exception e){
            dto=new Folio_xml_dto();

            e.printStackTrace();

            Log.e("responce error----------->",e.toString());

            return dto;
        }
    }


    public static void parseJson(){
        Folio_Dto folo;

        HashMap<Integer,ArrayList<Folio_Dto>> hs=new HashMap<>();
        ArrayList<Folio_Dto> folio_dtos=new ArrayList<>();

        try {
            JSONObject root =jsonObj.getJSONObject("root");

            JSONArray window = root.getJSONArray("window");

            for (int i=0;i<window.length();i++){


                JSONObject wIn = window.getJSONObject(i);
                JSONArray rowWin = wIn.getJSONArray("row");

                for (int j=0;j<rowWin.length();j++){

                    folo = new Folio_Dto();
                    JSONObject rowObj = rowWin.getJSONObject(j);

                    JSONObject val = rowObj.getJSONObject("value");

                    folo.setContent(val.optString("content"));
                    folo.setConversion(val.getString("conversion"));

                    folo.setKey(rowObj.getString("key"));

                    folio_dtos.add(folo);

                }
                folo = new Folio_Dto();
                JSONObject subWin = wIn.getJSONObject("subwindowtotal");
                JSONObject val = subWin.getJSONObject("value");

                folo.setContent(val.optString("content"));
                folo.setConversion(val.optString("conversion"));
                folo.setKey(subWin.optString("key"));
                folo.setName(wIn.optString("name"));

                folio_dtos.add(folo);

                hs.put(i,folio_dtos);

                Folio_Dto.getInstance().setWindRw(hs);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public static void setOnEventListenn(FolioCallBack onChannelSelectListen){

        if (onChannelSelectListen!=null){
            callBack_clickEvent=onChannelSelectListen;
        }

    }*/


}
