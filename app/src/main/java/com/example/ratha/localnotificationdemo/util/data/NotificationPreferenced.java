package com.example.ratha.localnotificationdemo.util.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ratha.localnotificationdemo.notification.Channel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ratha on 1/26/2018.
 */

public class NotificationPreferenced {

    public static final String ID="ID";
    public static final String NAME="NAME";
    public static final String PRIORITY="PRIORITY";
    public static final String DESC="DESC";

    private static SharedPreferences sharedPreferences;
    private static Map<String,Object> map =new HashMap();
    private static SharedPreferences createSharePreferencs(Context context){
        return context.getSharedPreferences("notification_channel",Context.MODE_PRIVATE);
    }


}
