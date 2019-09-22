package com.example.day02.fragment;


import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.example.day02.Main2Activity;
import com.example.day02.MyService;
import com.example.day02.R;
import com.example.day02.bane.Bpment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Fragment2 extends Fragment implements View.OnClickListener {

    private ProgressBar mBar;
    private TextView mText;
    private Button mButton;
    private File mFile;
    private float mF;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment2, null);
        initview(view);
        EventBus.getDefault().register(this);//注册
        intiDatat();
        return view;


    }

    private void intiDatat() {
        int i = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
        if (i!= PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
        }
        int j = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (j!=PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(getActivity(),new String []{Manifest.permission.WRITE_EXTERNAL_STORAGE},200);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void  getPbmode(Bpment bpment){
        mBar.setMax((int) bpment.getMax());  //长度
        mBar.setProgress(bpment.getProgress());
       float mF = (float) bpment.getProgress()/bpment.getMax();
        int round = Math.round(mF * 100);

        mText.setText("下载进度"+round+"%");

        if (bpment.getMax()==bpment.getProgress()){
            //通知：
            inittongzhu();
        }
    }

    private void inittongzhu() {
        NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        String chang= "0";
        String changlong= "0";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(chang, changlong, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        Intent intent2 = new Intent(getActivity(), Main2Activity.class);
        PendingIntent intent1 = PendingIntent.getActivities(getContext(),1, new Intent[]{intent2}, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new NotificationCompat.Builder(getContext(), chang)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("标题")
                .setContentText("下载成功")
                .setContentIntent(intent1)
                .build();

        manager.notify(1,notification);

    }

    private void initview(View view) {
        mBar = view.findViewById(R.id.Bar);
        mText = view.findViewById(R.id.text);
        mButton = view.findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                new Thread(){
                    @Override
                    public void run() {
                        Intent intent = new Intent(getContext(), MyService.class);
                        getActivity().startService(intent);

                    }

                }.start();

                break;

        }
    }

}
