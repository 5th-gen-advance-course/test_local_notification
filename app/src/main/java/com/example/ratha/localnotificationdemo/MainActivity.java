package com.example.ratha.localnotificationdemo;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ratha.localnotificationdemo.notification.Channel;
import com.example.ratha.localnotificationdemo.notification.NotificationChannel;

import java.security.acl.NotOwnerException;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    public static  final String TAG="MainActivity";
    public static final int CREATE_NOTIFICATION=0;
    public static final int DELETE_NOTIFICATION=1;
    private View customView;
    private EditText tvName;
    private EditText tvDesc;
    private EditText tvId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void pushBasicNotification(View view) {
        String channelId="personal_id";
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,channelId);
        builder.setContentTitle("some post on your timeline");
        builder.setSmallIcon(R.drawable.ic_stat_onesignal_default);
        String content="the pass==remind the present==think about the future==miss";
        builder.setContentText(content);
        builder.setTicker("new post");

        Uri sound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(sound);

        Intent resultIntent=new Intent(this,DetailActivity.class);
        resultIntent.putExtra("detail",content);

        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent pendingIntent= stackBuilder.getPendingIntent(
                0,PendingIntent.FLAG_UPDATE_CURRENT
        );
        builder.setContentIntent(pendingIntent);
        NotificationManager mManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId= (int) (System.currentTimeMillis()/1000);
        mManager.notify(notificationId,builder.build());

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void pushSmallNotification(View view) {
        String channelId="business_id";
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,channelId);
        builder.setContentTitle("some post on your timeline");
        builder.setSmallIcon(R.drawable.ic_stat_onesignal_default);
        String content="push with small image";
        builder.setContentText(content);
        builder.setTicker("new post");

        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.navdrawer_header));
        builder.setAutoCancel(true);

        Intent resultIntent=new Intent(this,DetailActivity.class);
        resultIntent.putExtra("detail",content);

        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent pendingIntent= stackBuilder.getPendingIntent(
                0,PendingIntent.FLAG_UPDATE_CURRENT
        );
        builder.setContentIntent(pendingIntent);
        NotificationManager mManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId= (int) (System.currentTimeMillis()/1000);
        mManager.notify(notificationId,builder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void pushBigBoxstyleNotification(View view) {
        String channelId="business_id";
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,channelId);
        builder.setContentTitle("expanded layout");
        builder.setSmallIcon(R.drawable.ic_stat_onesignal_default);
        String content="Applying an expanded layout to a notification";
        builder.setContentText(content);
        builder.setTicker("new post");

        NotificationCompat.InboxStyle inboxStyle=new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("When you need to issue a notification multiple...  ");
        inboxStyle.addLine("When you need to issue a notification multiple times for the same type of event, you should avoid making a completely new notification. Instead, you should consider updating a previous notification, either by changing some of its values or by adding to it, or both.");
        inboxStyle.setSummaryText("When you need to issue a notification multiple times for");
        builder.setStyle(inboxStyle);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.navdrawer_header));
        builder.setAutoCancel(true);

        Intent resultIntent=new Intent(this,DetailActivity.class);
        resultIntent.putExtra("detail",content);

        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent pendingIntent= stackBuilder.getPendingIntent(
                0,PendingIntent.FLAG_ONE_SHOT
        );
        builder.setContentIntent(pendingIntent);
        NotificationManager mManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId= (int) (System.currentTimeMillis()/1000);
        mManager.notify(notificationId,builder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void pushBigPictureStyleNotification(View view) {
        String channelId="business_id";
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,channelId);
        builder.setContentTitle("expanded layout");
        builder.setAutoCancel(true);
        builder.setSmallIcon(R.drawable.ic_stat_onesignal_default);
        String content="Applying an expanded layout to a notification";
        builder.setContentText(content);
        builder.setTicker("new post");
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.navdrawer_header));


        NotificationCompat.BigPictureStyle bigPictureStyle=new NotificationCompat.BigPictureStyle();

        bigPictureStyle.setSummaryText("Remember that expanded ...");
        bigPictureStyle.setBigContentTitle("Remember that expanded notifications are not available on platforms prior to Android 4.1.");
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.navdrawer_header));
        bigPictureStyle.bigLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.bell_group));

        builder.setStyle(bigPictureStyle);

        Intent resultIntent=new Intent(this,DetailActivity.class);
        resultIntent.putExtra("detail",content);

        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent pendingIntent= stackBuilder.getPendingIntent(
                0,PendingIntent.FLAG_CANCEL_CURRENT
        );
        builder.setContentIntent(pendingIntent);
        NotificationManager mManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId= (int) (System.currentTimeMillis()/1000);
        mManager.notify(notificationId,builder.build());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.create_channel:
                createSweetAlert("Create new Channel" ,CREATE_NOTIFICATION).show();
                break;
            case R.id.create_channel_group:
                createSweetAlert("Create new Channel group",CREATE_NOTIFICATION).show();
                break;
            case R.id.delete_channel:
                createSweetAlert("Delete channel group",DELETE_NOTIFICATION).show();
                break;
        }
        return false;
    }

    public SweetAlertDialog createSweetAlert(final String title , final int type){
        SweetAlertDialog dialog=new SweetAlertDialog(this);
        dialog.setTitle(title);
        dialog.setCancelable(false);

        final Channel channel=new Channel();
        if(type==CREATE_NOTIFICATION){
            customView = LayoutInflater.from(this).inflate(R.layout.create_notification_channel_sweet_alert_layout,null);
            tvName=customView.findViewById(R.id.tv_channel_name);
            tvDesc=customView.findViewById(R.id.tv_channel_desc);
            RadioGroup radioGroup=customView.findViewById(R.id.rdGroup);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton rd= customView.findViewById(group.getCheckedRadioButtonId());
                    int priority=0;
                    if(rd.isChecked()){
                        if(rd.getId()==R.id.importance)
                            priority=NotificationManager.IMPORTANCE_MAX;
                        else if(rd.getId()==R.id.medium)
                            priority=NotificationManager.IMPORTANCE_DEFAULT;
                        else if(rd.getId()==R.id.low)
                            priority=NotificationManager.IMPORTANCE_LOW;

                        channel.setPriority(priority);
                    }

                }
            });
        }else if(type==DELETE_NOTIFICATION){
            customView=LayoutInflater.from(this).inflate(R.layout.delete_notification_channel_sweet_alert_layout,null);
            tvId=customView.findViewById(R.id.tv_channel_id);
        }

        dialog.setCustomView(customView);
        dialog.setConfirmText("Save")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        Toast.makeText(MainActivity.this, " save", Toast.LENGTH_SHORT).show();
                        sweetAlertDialog.dismiss();
                        final SweetAlertDialog sweetAlert= showProgressBar();
                        sweetAlert.show();
                        if(type==CREATE_NOTIFICATION){
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    channel.setId(tvName.getText().toString()+"_id");
                                    channel.setName(tvName.getText().toString());
                                    channel.setDesc(tvDesc.getText().toString());
                                    createNotificationChannel(channel);
                                    sweetAlert.dismiss();
                                }
                            },1500);
                        }else if(type==DELETE_NOTIFICATION){
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    deleteNotificationChannel(tvId.getText().toString());
                                    sweetAlert.dismiss();
                                }
                            },1500);
                        }

                    }
                });

        dialog.setCancelText("Cancel")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        Toast.makeText(MainActivity.this, " save", Toast.LENGTH_SHORT).show();
                        sweetAlertDialog.cancel();
                    }
                });
        return dialog;

    }

    private void createNotificationChannel(Channel channel){
        NotificationChannel.createNotificationChannel(this,channel,"personally_01");

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void deleteNotificationChannel(String channelId){
        NotificationChannel.deleteChannel(this,channelId);
        Toast.makeText(this, channelId +" is deleted", Toast.LENGTH_SHORT).show();
    }

    private SweetAlertDialog showProgressBar(){
        SweetAlertDialog dialog=new SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE);
        dialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        dialog.setTitleText("Loading");
        dialog.setCancelable(false);
        return dialog;
    }



}
