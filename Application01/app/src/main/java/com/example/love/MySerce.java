package com.example.love;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by love on 2019/9/10.
 */

public class MySerce extends Service {
    //构造
    public MySerce() {
    }


    //只走一次
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("MyService", "--------onCreate: ");
    }

    //每次通过 startService  启动服务 onStartCommand 都会执行
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MyService", "----------onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("MyService", "---------onUnbind: ");
        return super.onUnbind(intent);
    }

    //服务销毁时执行一次
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("MyService", "--------onDestroy: ");
    }

    //绑定后执行
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i("MyService", "--------onBind: ");
        return null;
    }
}
