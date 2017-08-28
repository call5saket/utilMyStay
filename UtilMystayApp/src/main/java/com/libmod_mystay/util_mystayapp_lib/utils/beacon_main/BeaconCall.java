package com.libmod_mystay.util_mystayapp_lib.utils.beacon_main;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.IBeacon;
import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.IBeaconConsumer;
import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.IBeaconManager;
import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.MonitorNotifier;
import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.RangeNotifier;
import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.Region;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Saket on 24/8/17.
 */

public class BeaconCall implements IBeaconConsumer {

    public Context contextt;
    private ArrayList<IBeacon> arrayL = new ArrayList<IBeacon>();
    double avgDst=0;
    int cycle=0;


    private BeaconServiceUtility beaconUtill = null;
    private IBeaconManager iBeaconManager = IBeaconManager.getInstanceForApplication(contextt);

    public BeaconCall(Context context){

        contextt= context.getApplicationContext();

        beaconUtill = new BeaconServiceUtility(contextt);

    }

    @Override
    public void onIBeaconServiceConnect() {

        iBeaconManager.setRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<IBeacon> iBeacons, Region region) {

                System.out.println("Size of collection beaconss---------------" + iBeacons.size());
                arrayL.clear();
                arrayL.addAll((ArrayList<IBeacon>) iBeacons);

                if (arrayL.size() > 0) {
                    IBeacon firstBeacon = iBeacons.iterator().next();

                    for (int i=0;i<arrayL.size();i++) {

                        logToDisplay(arrayL.get(i).getProximityUuid() + " is about " + arrayL.get(i).getAccuracy()+ " Major " + arrayL.get(i).getMajor() + " meters away.");
                        Log.e("The first beacon", arrayL.get(i).getProximityUuid() + " is about " + arrayL.get(i).getAccuracy() + " Major " + arrayL.get(i).getMajor() + " meters away.");

                        getAvrgDistance();
                    }
                }
            }
        });

        iBeaconManager.setMonitorNotifier(new MonitorNotifier() {
            @Override
            public void didEnterRegion(Region region) {

                Log.e("BeaconDetactorService", "didEnterRegion");
            }

            @Override
            public void didExitRegion(Region region) {

                Log.e("BeaconDetactorService", "didExitRegion");
            }

            @Override
            public void didDetermineStateForRegion(int state, Region region) {

                Log.e("BeaconDetactorService", "didDetermineStateForRegion");
            }
        });

        try {
            iBeaconManager.startRangingBeaconsInRegion(new Region("B9407F30-F5F8-466E-AFF9-25556B57FE6D",null, null, null));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        try {
            iBeaconManager.startMonitoringBeaconsInRegion(new Region("B9407F30-F5F8-466E-AFF9-25556B57FE6D",null, null, null));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Context getApplicationContext() {

        return null;
    }


    @Override
    public void unbindService(ServiceConnection connection) {

    }

    @Override
    public boolean bindService(Intent intent, ServiceConnection connection, int mode) {
        return false;
    }

    // this method will call when onStart method will call of the activity....Saket
    public void beaconOnStartCall(){

        beaconUtill.onStart(iBeaconManager, this);
    }

    // this method will call when onStop method will call of the activtiy .... Saket.
    public void beaconOnStopCall(){
        beaconUtill.onStop(iBeaconManager, this);

    }

    private double getAvrgDistance(){


        if (cycle<6.0) {
            for (int i = 0; i < arrayL.size(); i++) {

                if (arrayL.get(i).getMajor() == 3794) {


                    cycle++;
                    avgDst = avgDst + arrayL.get(i).getAccuracy();

                    Log.e("Major==================>-----------",String.valueOf(arrayL.get(i).getMajor()));
                    Log.e("Total-----------",String.valueOf(avgDst));

                    Log.e("cycle-----------------",String.valueOf(cycle));
                }
            }
        }else {
            avgDst=avgDst/6;

            Intent intent = new Intent("Beacon-in-Range");
            // You can also include some extra data.


            if (avgDst<=5){

                intent.putExtra("beacon_Dst", true);
                LocalBroadcastManager.getInstance(contextt).sendBroadcast(intent);
            }else {
                intent.putExtra("beacon_Dst", false);
                LocalBroadcastManager.getInstance(contextt).sendBroadcast(intent);
            }

            Log.e("Avg---Dst-----------",String.valueOf(avgDst));
            cycle=0;
            avgDst=0;
        }



        return avgDst;
    }

    private void logToDisplay(final String line) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {

                Log.e("The first beacon " + line + " meters away.","");
                Toast.makeText(contextt, "The first beacon "+line, Toast.LENGTH_SHORT).show();
                /*EditText editText = (EditText)RangingActivity.this.findViewById(R.id.rangingText);
                editText.append(line+"\n");*/
            }
        });
    }
}
