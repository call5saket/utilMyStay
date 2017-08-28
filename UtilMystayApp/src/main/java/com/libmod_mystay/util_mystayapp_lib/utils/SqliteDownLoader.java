package com.libmod_mystay.util_mystayapp_lib.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;


import com.libmod_mystay.util_mystayapp_lib.utils.database.SharedData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Saket on 10/7/17.
 */

public class SqliteDownLoader {

    private static SqliteResponce sendRespons;
    private final SharedData shard;
    private Context context;


    public SqliteDownLoader(Context ctx){
        context=ctx;

        shard = new SharedData(context);
    }



    public class DownloadSqlite extends AsyncTask<String,Void,Boolean> {



        @Override
        protected Boolean doInBackground(String... params) {
            String filNme =params[0];
            String url= params[1];

            return new FileDownloader().downloadFile(url,getFile(filNme));
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if (aBoolean){

                shard.saveTvChnlState("sqlDb",aBoolean);
            }

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //context = DownloadSqlite.this;
        }


    }

    // To Download Image from the Url

    public class FileDownloader {
        private static final int  MEGABYTE = 1024 * 1024;

        public  boolean downloadFile(String fileUrl, File directory){
            try {

                URL url = new URL(fileUrl);
                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                //urlConnection.setRequestMethod("GET");
                //urlConnection.setDoOutput(true);
                urlConnection.setConnectTimeout(50000);
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(directory);
                int totalSize = urlConnection.getContentLength();

                byte[] buffer = new byte[MEGABYTE];
                int bufferLength = 0;

                while((bufferLength = inputStream.read(buffer))>0 ){
                    fileOutputStream.write(buffer, 0, bufferLength);

                    Log.i("insidebuffer","fileOutputStream.write");
                }

             /*   if ((bufferLength =inputStream.read())>0){
                    Log.e("insidebuffer","true");

                    sendRespons.isResponse(true);
                }else {
                    sendRespons.isResponse(false);
                    Log.e("insidebuffer","false");
                }*/

                fileOutputStream.close();

                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                // Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
            } catch (MalformedURLException e) {
                e.printStackTrace();
                //Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                //Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    }
    public  File getFile(String imageName) {

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
            file = new File(context.getFilesDir(), imageName);


        }

        Log.i("file----","file "+file.getAbsolutePath());
        return file;
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

    public interface SqliteResponce{

        public void isResponse(boolean res);
    }

    public static void chechkSqliteResponse(SqliteResponce sqliteResponce){

        sendRespons=sqliteResponce;
    }
}
