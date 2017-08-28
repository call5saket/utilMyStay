package com.libmod_mystay.util_mystayapp_lib.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Saket on 14/06/17.
 */
public class Others
{

    public static boolean isScrollingDone = false;


    public static boolean isNeedToLogoutCurrentDevice = true;






    public static void setFontRutanEditText(Context context, EditText editText)
    {

        Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/SanFranciscoDisplay-Regular.ttf");
        editText.setTypeface(type);
    }



    public static void setFontRutanTextView(Context context, TextView textView)
    {

        Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/SanFranciscoDisplay-Regular.ttf");
        textView.setTypeface(type);
    }

    public static void setFontRutanTextViewBold(Context context, TextView textView)
    {

        Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/SanFranciscoDisplay-Regular.ttf");
        textView.setTypeface(type);
    }

    public static void setFontRutanButton(Context context, Button button)
    {

        Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/SanFranciscoDisplay-Regular.ttf");
        button.setTypeface(type);
    }

    public static int compareRequestDates(String requestDate)
    {
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = Calendar.getInstance().getTime();

        format.setTimeZone(TimeZone.getTimeZone("UTC"));

        String today = format.format(date);


        int day = 0;
        try
        {


            //Log.e("s", "Request Differnace : "+requestDate.split("T")[0]+" Current "+today);

            Date requestDateTime = format.parse(requestDate.split("T")[0]);
            Date currentDateTime = format.parse(today);



            DateTime requestDateData = new DateTime(requestDateTime);
            //     Log.e("d",requestDateData.getZone()+"----------------");
            DateTime currentData = new DateTime(currentDateTime);
            //System.out.println(currentData.getZone());

            day = currentData.compareTo(requestDateData);
          //  Log.d("---", "Differnace Day "+day);
            if(day <= 0)
            {
                day = 0;
            }
            else
            {
                day = Days.daysBetween(requestDateData, currentData).getDays();
            }

           // Log.e("---", "Differnace Day "+day);

/*
             day = Days.daysBetween(requestDateData, currentData).getDays() % 7;
            int hour = Hours.hoursBetween(requestDateData, currentData).getHours() % 24;
            int minutes = Minutes.minutesBetween(requestDateData, currentData).getMinutes() % 60;
            int seconds = Seconds.secondsBetween(requestDateData, currentData).getSeconds() % 60;

            Log.e("---", "Differnace Day "+day);*/

        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return day;
    }


    public static boolean compareDates(String dateString1, String dateString2)
    {
        boolean isCompared = false;
        try
        {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-mm");


            //String str1 = "12/10/2013";
            Date date1 = formatter.parse(dateString1);

            //String str2 = "13/10/2013";
            Date date2 = formatter.parse(dateString2);

            if (date1.compareTo(date2) <= 0)
            {
                //System.out.println("date2 is Greater than my date1");
                isCompared =true;

            }
            else
            {
                isCompared = false;
            }

        }catch (ParseException e1)
        {
            e1.printStackTrace();
        }
        return isCompared;

    }



    public static int WIDTH_SIZE = 0;


/*
    public static int getColorFromAlertLevel(Context context, int level )
    {
        if( level == 0 )
        {
            return R.color.green;
        }
        else  if( level == 1 )
        {
            return R.color.darkGray;
        }
        else  if( level == 2 )
        {
            return R.color.green_cream;
        }
        else  if( level == 3 )
        {
            return R.color.green_dark_bg;
        }
        else  if( level == 4 )
        {
            return R.color.darkBlue;
        }
        else  if( level == 5 )
        {
            return R.color.darkPurple;
        }
        else  if( level == 6 )
        {
            return R.color.orange4;
        }
        else  if( level == 7 )
        {
            return R.color.red_color;
        }
        else
        {
            return R.color.gray_light_new;
        }
    }*/


}
