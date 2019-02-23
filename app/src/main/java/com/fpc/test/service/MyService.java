package com.fpc.test.service;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;

import com.fpc.test.util.SystemUtil;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private String TAG = "MyService";

    public static int GRAY_SERVICE_ID = 100;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                Log.i(TAG, "--------检测服务.......");
                Message m =  handler.obtainMessage();
                m.what = 1;
                handler.sendMessageDelayed(m, 3000);
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "服务启动了");
        handler.removeMessages(1);
        handler.sendEmptyMessage(1);
//        ActivityManager.ACTION_REPORT_HEAP_LIMIT
//        grayGuard();
//        openStart(this);
    }
    /*打开自启动管理页*/
    public static void openStart(Context context){
        if(Build.VERSION.SDK_INT < 23){
            return;
        }
        String system = SystemUtil.getSystem();
        Intent intent = new Intent();
        if(system.equals(SystemUtil.SYS_EMUI)){//华为
            ComponentName componentName = new ComponentName("com.huawei.systemmanager","com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
            intent.setComponent(componentName);
        }else if(system.equals(SystemUtil.SYS_MIUI)){//小米
            ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
            intent.setComponent(componentName);
        }
        try{
            context.startActivity(intent);
        }catch (Exception e){//抛出异常就直接打开设置页面
            intent=new Intent(Settings.ACTION_SETTINGS);
            context.startActivity(intent);
        }
    }

    private void grayGuard() {
        if (Build.VERSION.SDK_INT < 18) {
            //API < 18 ，此方法能有效隐藏Notification上的图标
            startForeground(GRAY_SERVICE_ID, new Notification());
        } else {
            Log.w(TAG, "API < 18， 启动前台隐身服务");
            Intent innerIntent = new Intent(this, DaemonInnerService.class);
            startService(innerIntent);
            startForeground(GRAY_SERVICE_ID, new Notification());
        }
//        //发送唤醒广播来促使挂掉的UI进程重新启动起来
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Intent alarmIntent = new Intent();
//        alarmIntent.setAction(WakeReceiver.GRAY_WAKE_ACTION);
//        PendingIntent operation = PendingIntent.getBroadcast(this,
//                WAKE_REQUEST_CODE, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            alarmManager.setWindow(AlarmManager.RTC_WAKEUP,
//                    System.currentTimeMillis(), ALARM_INTERVAL, operation);
//        }else {
//            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,
//                    System.currentTimeMillis(), ALARM_INTERVAL, operation);
//        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.w(TAG, "服务重新唤醒");
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "服务被杀了");
    }


    /**
     * 给 API >= 18 的平台上用的灰色保活手段
     */
    public static class DaemonInnerService extends Service {
        private String TAG = "DaemonInnerService";
        @Override
        public void onCreate() {
            Log.w(TAG, "DaemonInnerService 保活服务启动");
            super.onCreate();
        }
        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            Log.w(TAG, "DaemonInnerService -> onStartCommand");
            startForeground(GRAY_SERVICE_ID, new Notification());
            stopForeground(true);
            stopSelf();
            return super.onStartCommand(intent, flags, startId);
        }

        @Override
        public IBinder onBind(Intent intent) {
            throw new UnsupportedOperationException("Not yet implemented");
        }
        @Override
        public void onDestroy() {
            Log.w(TAG, "DaemonInnerService -> onDestroy");
            super.onDestroy();
        }
    }
}
