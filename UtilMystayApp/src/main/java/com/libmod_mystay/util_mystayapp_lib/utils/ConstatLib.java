package com.libmod_mystay.util_mystayapp_lib.utils;

/**
 * Created by Saket on 30/6/17.
 */


/*Constant interface for entire project.All the constant are declare here.*/
public interface ConstatLib {

    //Socket io url....
    //http://172.17.4.1:8014/tcp

    //http://192.168.3.92:8014/tcp---main

    //public static final String socket_Io= "http://10.10.10.1:8014/tcp";

    public static final String socket_Io= "http://10.10.10.1:8014/tcp";

    public static final String webSocket="ws://10.10.10.1:18444/";


    //Sqlite download location for TV-CHANNELS---- url.

    public static final String sqlDown="http://192.168.0.50/offlineApp/dv5/tvchannel/Tvchannel.sqlite";



    //Sqlite download location for PROMOTIONS-

    public static final String sqlDown_Promotions ="http://192.168.0.50/offlineApp/dv5/settings.sqlite";

    //Sqlite download location for Movies-

    public static final String sqlDown_mouvs="http://192.168.0.50/offlineApp/dv5/entertainment/newmymovie.sqlite";

    //here i am declearing all "DVC -- Command Here--"

    //Commands For Tv---
    public static final String tvCHannel_ON_First="device=tv:operation=tvmode";
    public static final String tvCHannel_Up_push="device=tv : operation=channel_up : flag=1";
    public static final String tvChannel_Up_leave="device=tv : operation=channel_up : flag=0";
    public static final String tvChannel_Down_push="device=tv : operation=channel_down : flag=1";
    public static final String tvChannel_Down_leave="device=tv : operation=channel_down : flag=0";
    public static final String tvCHannel_ON_Off="device=tv : operation=onoff : mode=tvmode : view=tvview";
    public static final String tvChannel_mute="device=tv : operation=mute";
    public static final String tvChannelVolume_incr="device=tv:operation=setvolume: level=";
    public static final String tvChannel_select_channel ="device =tv : operation=movetoFchannel : channel_name=";
    public static final String logStatus ="device=tv:operation=logStatus";

    // Commands For Movie--------

    public static final String movieChannel_On_First="device=tv:operation = pcmode";
    public static final String movieChannel_On_Off="device=tv : operation=onoff : mode=pcmode : view=movieview";
    public static final String movieChannel_Status="device=tv : operation=status";
    public static final String movieChannel_Play_Pause="device=tv : operation=startplayer : type=movie : filename= : lenght=";
    public static final String movieChannel_Resume="device=tv : operation=resumtmovie : type=movie : filename= : resume= : lenght=";
    public static final String movieChannel_Forward="device=tv : operation=forwardvlc : time=60";
    public static final String movieChannel_Rewind="device=tv : operation=rewindvlc : time=60";
    public static final String movieChannel_Stop="device=tv : operation=stopvlc";

    // Commands for device Streaming...

    public static final String dvcStream_AndMod="device=tv:operation=digicastmode:mode=android";
    public static final String dvcStream_GuestIn="device=tv:operation=digicastpage";

}
