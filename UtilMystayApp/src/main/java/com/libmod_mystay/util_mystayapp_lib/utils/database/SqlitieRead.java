package com.libmod_mystay.util_mystayapp_lib.utils.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;


import com.libmod_mystay.util_mystayapp_lib.utils.dto.Movie_List_dto;
import com.libmod_mystay.util_mystayapp_lib.utils.dto.Promotions_dto;
import com.libmod_mystay.util_mystayapp_lib.utils.dto.Tv_Channels_dto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saket on 10/7/17.
 */

public class SqlitieRead {

    private Handler handler;
    private SQLiteDatabase db_entertainment;
    private SQLiteDatabase db = null;
    private SQLiteDatabase dbPromotion = null;
    Context context;

    //Table --------------tvChannel-


    private static final String TV_CHANNEL = "tvchannels";
    private static final String TV_CHANNEL_CATAGORY = "tvchannel_category";
    private static final String TV_CHANNEL_CAT_MAPPING = "tvchannel_category_mapping";
    private static final String PROMOTIONS = "promotions";
    private static final String POSITION = "position";
    private static final String MOVIE_ALL = "vd_movie";


    public SqlitieRead(Context context) {
        this.context = context;

        try {

//| SQLiteDatabase.OPEN_READWRITE



            db = SQLiteDatabase.openDatabase(getFile("Tvchannel.sqlite").toString(), null, SQLiteDatabase.OPEN_READONLY);


            dbPromotion = SQLiteDatabase.openDatabase(getFile("Promotion.sqlite").toString(), null, SQLiteDatabase.OPEN_READONLY);
            db_entertainment = SQLiteDatabase.openDatabase(getFile("newmymovie.sqlite").toString(), null, SQLiteDatabase.OPEN_READONLY);

        } catch (Exception e) {

           // db_entertainment = SQLiteDatabase.openDatabase(getFile("newmymovie.sqlite").toString(), null,SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.OPEN_READWRITE);

            e.printStackTrace();
        }

    }
//Context.MODE_PRIVATE

//SELECT * From tvchannel_category_mapping INNER JOIN tvchannels ON tvchannel_category_mapping.tvchannel_id=tvchannels.id where tvchannel_category_mapping.tvchannel_category_id =1 And is_active LIKE 1 AND is_deleted LIKE 0

    public List<Tv_Channels_dto> getFilterChnl(String pos, String lmt) {
        List<Tv_Channels_dto> lst = new ArrayList<Tv_Channels_dto>();

        if (!db.isOpen()) {

            db = SQLiteDatabase.openDatabase(getFile("Tvchannel.sqlite").toString(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);

        }

        try {
            Cursor cursor = db.rawQuery("SELECT * FROM tvchannel_category_mapping cMap INNER JOIN tvchannels tvCh ON cMap.tvchannel_id=tvCh.id where cMap.tvchannel_category_id=?" + " And " + " is_active " + " LIKE ?" + " And " + " is_deleted " + " LIKE ?" + " ORDER BY " + " position " + "LIMIT ?", new String[]{pos, "%" + "1" + "%", "%" + "0" + "%", lmt});

            if (cursor.getCount() > 0) {

                if (cursor.moveToFirst()) {
                    do {

                        Tv_Channels_dto tvChnl = new Tv_Channels_dto();

                        tvChnl.setId(cursor.getString(cursor.getColumnIndex("id")));
                        tvChnl.setChannel_name(cursor.getString(cursor.getColumnIndex("channel_name")));
                        tvChnl.setChannel_logo(cursor.getString(cursor.getColumnIndex("channel_logo")));
                        tvChnl.setChannel_type(cursor.getString(cursor.getColumnIndex("channel_type")));
                        tvChnl.setIs_updated(cursor.getString(cursor.getColumnIndex("is_updated")));
                        tvChnl.setIs_updated(cursor.getString(cursor.getColumnIndex("is_active")));
                        tvChnl.setIs_deleted(cursor.getString(cursor.getColumnIndex("is_deleted")));
                        tvChnl.setChannel_color(cursor.getString(cursor.getColumnIndex("ch_color_code")));
                        tvChnl.setChannel_command(cursor.getString(cursor.getColumnIndex("channel_command")));
                        tvChnl.setChannel_position(cursor.getString(cursor.getColumnIndex("position")));

                        Tv_Channels_dto.setInstance(tvChnl);
                        lst.add(tvChnl);


                    } while (cursor.moveToNext());
                }
                cursor.close();
                db.close();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return lst;
    }

    //Tv Channels-----list ......Saket
    public List<Tv_Channels_dto> getChnl(int lmt) {
        List<Tv_Channels_dto> lst = new ArrayList<Tv_Channels_dto>();

        if (!db.isOpen()) {

            db = SQLiteDatabase.openDatabase(getFile("Tvchannel.sqlite").toString(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);

        }

        try {
            Cursor cursor = db.rawQuery("SELECT * FROM " + TV_CHANNEL + " where " + " is_active " + " LIKE ?" + " And " + " is_deleted " + " LIKE ?" + " ORDER BY " + " position " + "LIMIT ?", new String[]{"%" + "1" + "%", "%" + "0" + "%", String.valueOf(lmt)});

            if (cursor.getCount() > 0) {


                if (cursor.moveToFirst()) {

                    do {

                        Tv_Channels_dto tvChnl = new Tv_Channels_dto();

                        tvChnl.setId(cursor.getString(cursor.getColumnIndex("id")));
                        tvChnl.setChannel_name(cursor.getString(cursor.getColumnIndex("channel_name")));
                        tvChnl.setChannel_logo(cursor.getString(cursor.getColumnIndex("channel_logo")));
                        tvChnl.setChannel_type(cursor.getString(cursor.getColumnIndex("channel_type")));
                        tvChnl.setIs_updated(cursor.getString(cursor.getColumnIndex("is_updated")));
                        tvChnl.setIs_updated(cursor.getString(cursor.getColumnIndex("is_active")));
                        tvChnl.setIs_deleted(cursor.getString(cursor.getColumnIndex("is_deleted")));
                        tvChnl.setChannel_color(cursor.getString(cursor.getColumnIndex("ch_color_code")));
                        tvChnl.setChannel_command(cursor.getString(cursor.getColumnIndex("channel_command")));
                        tvChnl.setChannel_position(cursor.getString(cursor.getColumnIndex("position")));


                        Tv_Channels_dto.setInstance(tvChnl);
                        lst.add(tvChnl);


                    } while (cursor.moveToNext());
                }
                cursor.close();
                db.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    //Tv Channel category......Saket

    public List<Tv_Channels_dto> getChnl_catg() {
        List<Tv_Channels_dto> tvLst = new ArrayList<Tv_Channels_dto>();

        if (!db.isOpen()) {

            db = SQLiteDatabase.openDatabase(getFile("Tvchannel.sqlite").toString(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);

        }

        try {

            Cursor cursor = db.rawQuery("SELECT * FROM " + TV_CHANNEL_CATAGORY + " ORDER BY " + POSITION, null);

            if (cursor.getCount() > 0) {

                if (cursor.moveToFirst()) {
                    do {
                        Tv_Channels_dto tvCatg = new Tv_Channels_dto();

                        tvCatg.setCatgId(cursor.getString(cursor.getColumnIndex("id")));
                        tvCatg.setCategory_name(cursor.getString(cursor.getColumnIndex("category_name")));
                        tvCatg.setCatg_position(cursor.getString(cursor.getColumnIndex("position")));
                        tvCatg.setCatg_is_active(cursor.getString(cursor.getColumnIndex("is_active")));
                        tvCatg.setCatg_is_deleted(cursor.getString(cursor.getColumnIndex("is_deleted")));
                        tvCatg.setCatg_creation_date(cursor.getString(cursor.getColumnIndex("creation_date")));
                        tvCatg.setCatg_created_by(cursor.getString(cursor.getColumnIndex("created_by")));
                        tvCatg.setCatg_modification_date(cursor.getString(cursor.getColumnIndex("modification_date")));
                        tvCatg.setCatg_modified_by(cursor.getString(cursor.getColumnIndex("modified_by")));

                        Tv_Channels_dto.setInstance(tvCatg);
                        tvLst.add(tvCatg);


                    } while (cursor.moveToNext());
                }

                cursor.close();
                db.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return tvLst;
    }


    public List<Promotions_dto> getPromotion() {
        List<Promotions_dto> proLst = new ArrayList<Promotions_dto>();

        if (!dbPromotion.isOpen()) {

            dbPromotion = SQLiteDatabase.openDatabase(getFile("Promotion.sqlite").toString(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);

        }

        try {
            Cursor cursor = dbPromotion.rawQuery("SELECT * FROM " + PROMOTIONS, null);

            if (cursor.getCount() > 0) {


                if (cursor.moveToFirst()) {


                    do {
                        Promotions_dto proDto = new Promotions_dto();

                        proDto.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                        proDto.setDescriptions(cursor.getString(cursor.getColumnIndex("descriptions")));
                        proDto.setImage(cursor.getString(cursor.getColumnIndex("image")));
                        proDto.setImage_large(cursor.getString(cursor.getColumnIndex("image_large")));
                        proDto.setPromotion_type(cursor.getString(cursor.getColumnIndex("promotion_type")));
                        proDto.setPromotion_url(cursor.getString(cursor.getColumnIndex("promotion_url")));
                        proDto.setPosition(cursor.getString(cursor.getColumnIndex("position")));
                        proDto.setVisibility(cursor.getString(cursor.getColumnIndex("visibility")));

                        Promotions_dto.setInstance(proDto);
                        proLst.add(proDto);

                    } while (cursor.moveToNext());
                }
                cursor.close();
                dbPromotion.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return proLst;
    }


    //Movie category...method ------saket.

    public List<Movie_List_dto> getMovCatg() {
        List<Movie_List_dto> catLst = new ArrayList<Movie_List_dto>();

        if (!db_entertainment.isOpen()) {
            db_entertainment = SQLiteDatabase.openDatabase(getFile("newmymovie.sqlite").toString(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        }

        Cursor cursor = db_entertainment.rawQuery("SELECT * FROM movie_subcat  ORDER BY id",null);

        if (cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {

                do {

                    Movie_List_dto movDto = new Movie_List_dto();

                    movDto.setMov_cat_name(cursor.getString(cursor.getColumnIndex("name")));
                    movDto.setMov_cat_id(cursor.getString(cursor.getColumnIndex("id")));


                    Movie_List_dto.setInstance(movDto);
                    catLst.add(movDto);


                } while (cursor.moveToNext());
            }
            cursor.close();
            db_entertainment.close();

        }

        return catLst;
    }

    // Movie all list......

    public List<Movie_List_dto> getAll_Movie(String limit) {
        List<Movie_List_dto> moviAll = new ArrayList<Movie_List_dto>();

        if (!db_entertainment.isOpen()) {
            db_entertainment = SQLiteDatabase.openDatabase(getFile("newmymovie.sqlite").toString(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        }

        Cursor cursor = db_entertainment.rawQuery("SELECT * From " + MOVIE_ALL + " ORDER BY " + POSITION + " LIMIT ?", new String[]{limit});

        if (cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {

                do {
                    Movie_List_dto movie_list_dto = new Movie_List_dto();

                    movie_list_dto.setVd_movie_code(cursor.getString(cursor.getColumnIndex("vd_movie_code")));
                    //movie_list_dto.setMov_visibility(cursor.getString(cursor.getColumnIndex("visibility")));
                    movie_list_dto.setVd_movie_title(cursor.getString(cursor.getColumnIndex("vd_movie_title")));
                    movie_list_dto.setVd_movie_genre(cursor.getString(cursor.getColumnIndex("vd_movie_genre")));
                    movie_list_dto.setLang(cursor.getString(cursor.getColumnIndex("lang")));
                    movie_list_dto.setKeywords(cursor.getString(cursor.getColumnIndex("keywords")));
                    movie_list_dto.setVd_movie_image(cursor.getString(cursor.getColumnIndex("vd_movie_image")));
                    movie_list_dto.setNo_files(cursor.getString(cursor.getColumnIndex("no_files")));
                    movie_list_dto.setVd_movie_filename(cursor.getString(cursor.getColumnIndex("vd_movie_filename")));
                    movie_list_dto.setDirector(cursor.getString(cursor.getColumnIndex("director")));
                    movie_list_dto.setWriter(cursor.getString(cursor.getColumnIndex("writer")));
                    movie_list_dto.setCast(cursor.getString(cursor.getColumnIndex("cast")));
                    movie_list_dto.setRelease_date(cursor.getString(cursor.getColumnIndex("release_date")));
                    movie_list_dto.setRating(cursor.getString(cursor.getColumnIndex("rating")));
                    movie_list_dto.setCounter(cursor.getString(cursor.getColumnIndex("counter")));
                    movie_list_dto.setEntry_date(cursor.getString(cursor.getColumnIndex("entry_date")));
                    movie_list_dto.setProducer(cursor.getString(cursor.getColumnIndex("producer")));
                    movie_list_dto.setMusic_director(cursor.getString(cursor.getColumnIndex("music_director")));

                    movie_list_dto.setRates(cursor.getString(cursor.getColumnIndex("rates")));
                    movie_list_dto.setSynopsis(cursor.getString(cursor.getColumnIndex("synopsis")));
                    movie_list_dto.setMovie_distributor(cursor.getString(cursor.getColumnIndex("movie_distributor")));
                    movie_list_dto.setMovie_studio(cursor.getString(cursor.getColumnIndex("movie_studio")));
                    movie_list_dto.setHd(cursor.getString(cursor.getColumnIndex("hd")));
                    movie_list_dto.setLicensed(cursor.getString(cursor.getColumnIndex("licensed")));
                    movie_list_dto.setDuration(cursor.getString(cursor.getColumnIndex("duration")));
                    movie_list_dto.setIs_deleted(cursor.getString(cursor.getColumnIndex("is_deleted")));
                    movie_list_dto.setRemoval_date(cursor.getString(cursor.getColumnIndex("removal_date")));
                    movie_list_dto.setEnd_date(cursor.getString(cursor.getColumnIndex("end_date")));
                    movie_list_dto.setVd_movie_certificate(cursor.getString(cursor.getColumnIndex("vd_movie_certificate")));
                    movie_list_dto.setSubtitle(cursor.getString(cursor.getColumnIndex("subtitle")));
                    movie_list_dto.setAudio_track(cursor.getString(cursor.getColumnIndex("audio_track")));
                    movie_list_dto.setDimension(cursor.getString(cursor.getColumnIndex("dimension")));
                    movie_list_dto.setPosition(cursor.getString(cursor.getColumnIndex("position")));

                    moviAll.add(movie_list_dto);

                } while (cursor.moveToNext());
            }
            cursor.close();
            db_entertainment.close();
        }

        return moviAll;
    }


    // Movie list category wise..

    public List<Movie_List_dto> get_Movie_Filter(String id, String lmt){
        List<Movie_List_dto> moviAll = new ArrayList<Movie_List_dto>();

        if (!db_entertainment.isOpen()) {
            db_entertainment = SQLiteDatabase.openDatabase(getFile("newmymovie.sqlite").toString(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        }

        Cursor cursor = db_entertainment.rawQuery("SELECT * From movie_list INNER JOIN vd_movie ON movie_list.movie_id=vd_movie.vd_movie_code where movie_list.cat_id =?" + " AND " + " is_deleted " +  " LIKE ?" + " ORDER BY " + " position "+ "LIMIT ?",new String[]{id,"%" + "0" + "%",lmt});

        if (cursor.getCount()>0){

            if (cursor.moveToFirst()){

                do{

                    Movie_List_dto movie_list_dto = new Movie_List_dto();

                    movie_list_dto.setVd_movie_code(cursor.getString(cursor.getColumnIndex("vd_movie_code")));
                    //movie_list_dto.setMov_visibility(cursor.getString(cursor.getColumnIndex("visibility")));
                    movie_list_dto.setVd_movie_title(cursor.getString(cursor.getColumnIndex("vd_movie_title")));
                    movie_list_dto.setVd_movie_genre(cursor.getString(cursor.getColumnIndex("vd_movie_genre")));
                    movie_list_dto.setLang(cursor.getString(cursor.getColumnIndex("lang")));
                    movie_list_dto.setKeywords(cursor.getString(cursor.getColumnIndex("keywords")));
                    movie_list_dto.setVd_movie_image(cursor.getString(cursor.getColumnIndex("vd_movie_image")));
                    movie_list_dto.setNo_files(cursor.getString(cursor.getColumnIndex("no_files")));
                    movie_list_dto.setVd_movie_filename(cursor.getString(cursor.getColumnIndex("vd_movie_filename")));
                    movie_list_dto.setDirector(cursor.getString(cursor.getColumnIndex("director")));
                    movie_list_dto.setWriter(cursor.getString(cursor.getColumnIndex("writer")));
                    movie_list_dto.setCast(cursor.getString(cursor.getColumnIndex("cast")));
                    movie_list_dto.setRelease_date(cursor.getString(cursor.getColumnIndex("release_date")));
                    movie_list_dto.setRating(cursor.getString(cursor.getColumnIndex("rating")));
                    movie_list_dto.setCounter(cursor.getString(cursor.getColumnIndex("counter")));
                    movie_list_dto.setEntry_date(cursor.getString(cursor.getColumnIndex("entry_date")));
                    movie_list_dto.setProducer(cursor.getString(cursor.getColumnIndex("producer")));
                    movie_list_dto.setMusic_director(cursor.getString(cursor.getColumnIndex("music_director")));

                    movie_list_dto.setRates(cursor.getString(cursor.getColumnIndex("rates")));
                    movie_list_dto.setSynopsis(cursor.getString(cursor.getColumnIndex("synopsis")));
                    movie_list_dto.setMovie_distributor(cursor.getString(cursor.getColumnIndex("movie_distributor")));
                    movie_list_dto.setMovie_studio(cursor.getString(cursor.getColumnIndex("movie_studio")));
                    movie_list_dto.setHd(cursor.getString(cursor.getColumnIndex("hd")));
                    movie_list_dto.setLicensed(cursor.getString(cursor.getColumnIndex("licensed")));
                    movie_list_dto.setDuration(cursor.getString(cursor.getColumnIndex("duration")));
                    movie_list_dto.setIs_deleted(cursor.getString(cursor.getColumnIndex("is_deleted")));
                    movie_list_dto.setRemoval_date(cursor.getString(cursor.getColumnIndex("removal_date")));
                    movie_list_dto.setEnd_date(cursor.getString(cursor.getColumnIndex("end_date")));
                    movie_list_dto.setVd_movie_certificate(cursor.getString(cursor.getColumnIndex("vd_movie_certificate")));
                    movie_list_dto.setSubtitle(cursor.getString(cursor.getColumnIndex("subtitle")));
                    movie_list_dto.setAudio_track(cursor.getString(cursor.getColumnIndex("audio_track")));
                    movie_list_dto.setDimension(cursor.getString(cursor.getColumnIndex("dimension")));
                    movie_list_dto.setPosition(cursor.getString(cursor.getColumnIndex("position")));

                    moviAll.add(movie_list_dto);

                } while (cursor.moveToNext());
            }
            cursor.close();
            db_entertainment.close();
        }
        return moviAll;
    }

    /*
      from ..New Movie.sqlite Data Base

     SELECT * From movie_list INNER JOIN vd_movie ON movie_list.movie_id=vd_movie.vd_movie_code where movie_list.cat_id =1 And is_deleted =0 ORDER BY position LIMIT 10//query to fetch movie catgrywise from ..new Movie Data Base...Saket
     SELECT * FROM movie_subcat  ORDER BY id // query to fetch catagory of movie..

     */

    /*
     - Entertainment.sqlite-- now not using for movie

      // SELECT * From dv5_movie_cat_map INNER JOIN dv5_movie ON dv5_movie_cat_map.movie_id=dv5_movie.id where dv5_movie_cat_map.category_id =1 AND visibility= 1 ORDER BY position // query to fetch movie catgrywise...Saket
    //SELECT * FROM dv5_movie_cat where visibility=1 ORDER BY position // query to fetch catagory of movie... orderby position.....Saket
    //SELECT * From dv5_movie ORDER BY position Limit 10 // fetch all movie list and with limit....Saket


     */



    public File getFile(String imageName) {

        File file;
        boolean success = true;
        if (isExternalStorageAvailable()) {
            String root = Environment.getExternalStorageDirectory() + "/MyStayApp_Sqlite";
            success = new File(root).mkdirs();
            file = new File(root, imageName);

            if (success) {
                // Do something on success
                Log.i("success", "success " + success);
            } else {
                // Do something else on failure
                Log.i("success", "success " + success);
            }
        } else {
            file = new File(context.getFilesDir(), imageName);
        }

        Log.i("file----", "file " + file.getAbsolutePath());
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

}
