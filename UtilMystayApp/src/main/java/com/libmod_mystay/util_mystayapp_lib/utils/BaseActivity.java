package com.libmod_mystay.util_mystayapp_lib.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.util.Locale;

/**
 * Created by Saket on 10/7/17.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener  {

    String TAG=getClass().getName();
    final int PLAY_SERVICES_RESOLUTION_REQUEST=1011;
    final int PERMISSION_REQUEST_CODE_CALL=1012;
    final public int PERMISSION_REQUEST_FINE_LOCATION=1013;
    final public int PERMISSION_REQUEST_COARSE_LOCATION=1014;
    final int PERMISSION_REQUEST_CAMERA=1015;
    final public int PERMISSION_REQUEST_STORAGE=1016;
    final int PERMISSION_READ_PHONE_STATE=1017;

    public static String token="";

Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context=this;
    }

    @Override
    public void onClick(View view) {

    }
    public boolean hasPermission(String perm) {
        try {
            if (Build.VERSION.SDK_INT >= 23)
                return (PackageManager.PERMISSION_GRANTED == getApplicationContext().checkSelfPermission(perm));
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        return true;
    }
   /* private boolean checkPlayServices(final Context context) {
        final GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        final int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        apiAvailability.getErrorDialog((Activity)context, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST).show();
                    }
                },200);


            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }
*/
    public void setLocale(String lang) {
        Locale myLocale;
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

    }
    public void updateActivity() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }





    public File getFile(String imageName) {

        File file;
        boolean success = true;
        if (isExternalStorageAvailable()) {
            String root = Environment.getExternalStorageDirectory()+ "/MyStayApp_Sqlite";
            success=new File(root).mkdirs();
            file = new File(root, imageName);

            if (success) {
                // Do something on success
                Log.i("success","success "+success);
            } else {
                // Do something else on failure
                Log.i("success","success "+success);
            }
        } else {
            file = new File(getFilesDir(), imageName);
        }

        Log.i("file","file "+file.getAbsolutePath());
        return file;
    }

    public String getFilePath(String imageName) {
        String root =null;
        if (isExternalStorageAvailable()) {
            root = Environment.getExternalStorageDirectory()+ "/MyStayApp_Sqlite";
        } else {
            root = getFilesDir().getAbsolutePath();
        }

        Log.i("root","root "+root+imageName);
        return root+"/"+imageName;

    }

    // to check externalStorage is mounted or not-----

    private boolean isExternalStorageAvailable() {

        String state = Environment.getExternalStorageState();
        boolean mExternalStorageAvailable = false;
        boolean mExternalStorageWriteable = false;

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // We can read and write the media
            mExternalStorageAvailable = mExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // We can only read the media
            mExternalStorageAvailable = true;
            mExternalStorageWriteable = false;
        } else {
            // Something else is wrong. It may be one of many other states, but
            // all we need
            // to know is we can neither read nor write
            mExternalStorageAvailable = mExternalStorageWriteable = false;
        }

        if (mExternalStorageAvailable
                && mExternalStorageWriteable) {
            return true;
        } else {
            return false;
        }
    }


    public String parseFileName(String url){

        if (TextUtils.isEmpty(url))
            return "";
        else
            return url.substring(url.lastIndexOf('/') + 1);
    }
    protected boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
