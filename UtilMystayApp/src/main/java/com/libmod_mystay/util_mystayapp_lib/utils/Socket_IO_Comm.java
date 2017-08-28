package com.libmod_mystay.util_mystayapp_lib.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.libmod_mystay.util_mystayapp_lib.utils.database.SharedData;

import java.net.URISyntaxException;

/**
 * Created by Saket on 23/8/17.
 */

public class Socket_IO_Comm {

    private  SharedData sharedData;
    private Context context;

    private Socket mSocket;

    private static  Socket_IO_Comm instance ;

    private static EventRespon_CallBack callBack_clickEvent;

    private static final String TAG = "Socket_IO_Comm";


    {
        try {
            IO.Options options = new IO.Options();
            options.query= "room_number=0401&roomtype=single&featuretype=light";
            mSocket = IO.socket(ConstatLib.socket_Io,options);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket_IO_Comm(){

    }
    public static Socket_IO_Comm getInstance() {
        if (instance==null){
            instance = new Socket_IO_Comm();
        }
        return instance;
    }

    public void setInstance(Socket_IO_Comm instance) {
        this.instance = instance;
    }

    public Socket_IO_Comm(Context context1){

        context = context1;

        sharedData = new SharedData(context);

        mSocket.io().reconnectionDelay(1500);
        //  mSocket.io().timeout(-1);
        mSocket.on(Socket.EVENT_CONNECT, onConnect);
        mSocket.on(Socket.EVENT_DISCONNECT, onDisconnect);
        mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
        mSocket.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);

        mSocket.on("notification-0401-single-light", onNewMessage);
        mSocket.connect();
    }



    public Socket getSocket() {
        return mSocket;
    }



    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {

                    if (!isConnected) {

                        mSocket.emit("new_message", "Helloo_node");
                        Toast.makeText(context,
                                "Connected_node", Toast.LENGTH_LONG).show();
                        isConnected = true;
                    }
                }
            });
           /* runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (!isConnected) {

                        mSocket.emit("new_message", "Helloo_node");
                        Toast.makeText(getApplicationContext(),
                                "Connected_node", Toast.LENGTH_LONG).show();
                        isConnected = true;
                    }
                }
            });*/
        }
    };




    private boolean isConnected = true;
    private Emitter.Listener onDisconnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Log.i(TAG, "diconnected");
                    isConnected = false;
                    Toast.makeText(context,
                            "Node Disconnected", Toast.LENGTH_LONG).show();
                }
            });

           /* runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.i(TAG, "diconnected");
                    isConnected = false;
                    Toast.makeText(context,
                            "Node Disconnected", Toast.LENGTH_LONG).show();
                }
            });*/
        }
    };



    private Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {

                    Log.e(TAG, "Error connecting" + args[0].toString());
                    Toast.makeText(context,
                            "Error in Connection", Toast.LENGTH_LONG).show();
                }
            });


         /*   runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    Log.e(TAG, "Error connecting" + args[0].toString());
                    Toast.makeText(context,
                            "Error in Connection", Toast.LENGTH_LONG).show();
                }
            });*/
            mSocket.close();
        }
    };


    private Socket_NodeRes_dto respons_socket_dto;
    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {


            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {

                    byte[] dataa = Base64.decode(args[0].toString());


                    String s = new String(dataa);
                    Log.e(TAG, args[0].toString().trim());
                    Log.e(TAG, String.valueOf(dataa));

                    // respons_socket_dto = jsonParse(s.trim());

                    setRespons_socket_dto(jsonParse(s.trim()));

                    Socket_NodeRes_dto dto = jsonParse(s.trim());

                    getStatuss(dto);

                    try {
                        callBack_clickEvent.getStatus(dto);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //getStatuss(dto);
                    Log.e(TAG, s.trim());
                }
            });
          /*  runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    byte[] dataa = Base64.decode(args[0].toString());


                    String s = new String(dataa);
                    Log.e(TAG, args[0].toString().trim());
                    Log.e(TAG, String.valueOf(dataa));

                    Socket_NodeRes_dto dto = jsonParse(s.trim());
                    //getStatuss(dto);
                    Log.e(TAG, s.trim());
                    try {
                       // callBack_clickEvent.getStatus(dto);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                      *//*  username = data.getString("username");
                        message = data.getString("message");*//*


                    *//*  removeTyping(username);
                    addMessage(username, message);*//*
                }
            });*/
        }
    };


    public static void setOnEventListen(EventRespon_CallBack onChannelSelectListen) {

        if (onChannelSelectListen != null) {
            callBack_clickEvent = onChannelSelectListen;
        }

    }
    public Socket_NodeRes_dto jsonParse(String jsonOutput) {
        Socket_NodeRes_dto dto;
        try {
            dto = (Socket_NodeRes_dto) new Gson().fromJson(jsonOutput, new TypeToken<Socket_NodeRes_dto>() {
            }.getType());
            return dto;
        } catch (Exception e) {
            dto = new Socket_NodeRes_dto();

            return dto;
        }
    }

    public Socket_NodeRes_dto getRespons_socket_dto() {
        return respons_socket_dto;
    }

    public void setRespons_socket_dto(Socket_NodeRes_dto respons_socket_dto) {
        this.respons_socket_dto = respons_socket_dto;
    }

    public void socketIoResume(){

        if (!mSocket.connected()) {
            mSocket.connect();
            //  Toast.makeText(context, "Trying to Connect", Toast.LENGTH_SHORT).show();
        }
    }

    public void getStatuss(Socket_NodeRes_dto result) {

        boolean valChk = true;

        if (result.getEventType().equals("tvchannel")) {

            Log.e("inside if getStatus-----", "tv");

            sharedData.saveTvChnlState("tvchannel", true);

            WebSocketConnection.setEvntStatus(result.getEventStatus());

            valChk = false;


        } else if (result.getEventType().equals("movielog")) {

            Log.e("inside else if getStatus-----", "mov");
            sharedData.saveTvChnlState("tvchannel", true);
            valChk = false;

        }


        if (valChk) {
            Log.e("inside if getStatus-----", "newVal");
            sharedData.saveTvChnlState("tvchannel", false);
        }
    }
}
