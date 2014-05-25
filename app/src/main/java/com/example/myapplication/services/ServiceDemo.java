package com.example.myapplication.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


import com.example.myapplication.R;

import java.util.Random;

public class ServiceDemo extends Service {


    public static final String ACTION = "com.example.myapplication.services.ServiceDemo";

    public ServiceDemo() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("", "onBind");
        return null;
    }


    @Override
    public void onCreate() {
        Log.d("", "onCreate");
        super.onCreate();

        Context context = getApplicationContext();
        final NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(NOTIFICATION_SERVICE);


        int icon = R.drawable.ic_stat_device_access_alarms; //通知栏的图标
        CharSequence cs = "Text1"; //通知栏的消息
        long when = System.currentTimeMillis();

        final Notification notification = new Notification(icon, cs, when);
        CharSequence contentTitle = "Text2"; //通知栏下拉后的标题
        CharSequence contentText = "Text3"; //通知栏下拉后的通知具体内容
        Intent notificationIntent = new Intent(); //点这个通知干什么事情
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
        notification.setLatestEventInfo(context, contentTitle, contentText,
                contentIntent);

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                            Log.d("","ServiceDemo is running...");
                            notificationManager.notify(new Random().nextInt(3), notification); //不同的id代表不同的通知，相同的id只会在通知栏显示一次
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
}
