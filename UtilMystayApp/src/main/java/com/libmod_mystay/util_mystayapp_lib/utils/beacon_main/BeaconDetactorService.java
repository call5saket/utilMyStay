package com.libmod_mystay.util_mystayapp_lib.utils.beacon_main;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;


import com.libmod_mystay.util_mystayapp_lib.R;
import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.IBeacon;
import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.IBeaconConsumer;
import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.IBeaconManager;
import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.MonitorNotifier;
import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.RangeNotifier;
import com.libmod_mystay.util_mystayapp_lib.utils.beacon_java.Region;

import java.util.ArrayList;
import java.util.Collection;

public class BeaconDetactorService extends Service implements IBeaconConsumer {

	private IBeaconManager iBeaconManager = IBeaconManager.getInstanceForApplication(this);
	private ArrayList<IBeacon> arrayL = new ArrayList<IBeacon>();

	double avgDst=0;
	int cycle=0;
	Context context;
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_STICKY;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		iBeaconManager.bind(this);

		context = this;
		final Handler handler = new Handler();
		final Runnable runnable = new Runnable() {

			@Override
			public void run() {
				//stopSelf();
			}
		};
		handler.postDelayed(runnable, 10000);
	}

	@Override
	public void onDestroy() {
		iBeaconManager.unBind(this);
		super.onDestroy();
	}

	@Override
	public void onIBeaconServiceConnect() {
		iBeaconManager.setRangeNotifier(new RangeNotifier() {
			@Override
			public void didRangeBeaconsInRegion(Collection<IBeacon> iBeacons, Region region) {

				arrayL.clear();
				arrayL.addAll((ArrayList<IBeacon>) iBeacons);

				if (arrayL.size() > 0) {
					IBeacon firstBeacon = iBeacons.iterator().next();

					for (int i=0;i<arrayL.size();i++) {

						//logToDisplay(arrayL.get(i).getProximityUuid() + " is about " + arrayL.get(i).getAccuracy()+ " Major " + arrayL.get(i).getMajor() + " meters away.");Major-3794
						Log.e("Background_The first beacon", arrayL.get(i).getProximityUuid() + " is about " + arrayL.get(i).getAccuracy() + " Major " + arrayL.get(i).getMajor() + " meters away.");

						getAvrgDistance();
					}
				}
			}
		});




		iBeaconManager.setMonitorNotifier(new MonitorNotifier() {
			@Override
			public void didEnterRegion(Region region) {
				Log.e("BeaconDetactorService", "didEnterRegion");
			/*	generateNotification(getApplicationContext(), region.getUniqueId()
						+ ": just saw this iBeacon for the first time");*/
			}

			@Override
			public void didExitRegion(Region region) {
				Log.e("BeaconDetactorService", "didExitRegion");
			//	generateNotification(getApplicationContext(), region.getUniqueId() + ": is no longer visible");
			}

			@Override
			public void didDetermineStateForRegion(int state, Region region) {
				Log.e("BeaconDetactorService", "didDetermineStateForRegion:" + state);
			}

		});

		try {
			iBeaconManager.startRangingBeaconsInRegion(new Region("B9407F30-F5F8-466E-AFF9-25556B57FE6D",null, null, null));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			iBeaconManager.startMonitoringBeaconsInRegion(new Region("B9407F30-F5F8-466E-AFF9-25556B57FE6D",null , null, null));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public double getAvrgDistance(){


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
				LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
			}else {
				intent.putExtra("beacon_Dst", false);
				LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
			}

			Log.e("Avg---Dst-----------",String.valueOf(avgDst));
			cycle=0;
			avgDst=0;
		}



		return avgDst;
	}

	/**
	 * Issues a notification to inform the user that server has sent a message.
	 *
	 * this method we will define in our library class like--tv,--
	 *
	 * Class<?> to ,this param is temeporary we will replace it by class name..
	 *
	 */
	private static void generateNotification(Context context, String message, Class<?> to) {

		Intent launchIntent = new Intent(context, to).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP);

		((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).notify(
				0,
				new NotificationCompat.Builder(context).setWhen(System.currentTimeMillis())
						//.setSmallIcon(R.drawable.ic_launcher).setTicker(message)
						.setContentTitle(context.getResources().getString(R.string.app_name)).setContentText(message)
						.setContentIntent(PendingIntent.getActivity(context, 0, launchIntent, 0)).setAutoCancel(true)
						.build());

	}
	private void logToDisplay(final String line) {


				Log.e("The first beacon " + line + " meters away.","");
				Toast.makeText(context, "The first beacon "+line, Toast.LENGTH_SHORT).show();
                /*EditText editText = (EditText)RangingActivity.this.findViewById(R.id.rangingText);
                editText.append(line+"\n");*/


	}


}