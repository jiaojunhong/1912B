package com.example.love.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.love.MySerce;
import com.example.love.application01.R;
import com.example.love.bane.ApService;
import com.example.love.bane.PbMsg;
import com.example.love.bane.ThreadManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by love on 2019/9/10.
 */

public class Fragment2 extends Fragment implements View.OnClickListener{
    String fileUrl = "http://cdn.banmi.com/banmiapp/apk/banmi_330.apk ";//文件的网络路径
    private ProgressBar mFragment2Bar;
    private TextView mFragment2Text;
    private Button mFragment2Button;
    private File mFile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, null);
        initview(view);
        checkPremisstion();
        EventBus.getDefault().register(this); //注册

        return view;

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getMsg(PbMsg pbMsg){
        switch (pbMsg.getI()){
            case 0://访问失败
                Toast.makeText(getActivity(), "访问失败，请求检查网络", Toast.LENGTH_SHORT).show();
                break;
            case 1://设置pb的最大值和文件一致
                mFragment2Bar.setMax((int)pbMsg.getMax());//如果max值超过21亿，不能够这样，需要进行百分比的转换
                break;
            case 2:
                mFragment2Bar.setProgress(pbMsg.getProgress());//把进度设置到进度条中
                //Log.i("111", "getMsg22222222222222: "+pbMsg.getProgress());
                break;
            case 3:
                Toast.makeText(getActivity(), "下载完成", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void checkPremisstion() {
        //检查 sdcard读权限
        int i = ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (i != PackageManager.PERMISSION_GRANTED) {//没有权限，申请权限
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }

        int j = ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
        if (j != PackageManager.PERMISSION_GRANTED) {//没有权限，申请权限
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
        }

    }

    private void initview(View view) {
        mFragment2Bar = view.findViewById(R.id.fragment2_bar);
        mFragment2Text = view.findViewById(R.id.fragment2_text);
        mFragment2Button = view.findViewById(R.id.fragment2_button);
        mFragment2Button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment2_button:
               // getActivity().startService(new Intent(getActivity(),MySerce.class));
                intDatat();
                break;
        }
    }

    private void intDatat() {
        new Thread(){
            @Override
            public void run() {
                Ok();
            }


        }.start();
    }
    private void Ok() {
        mFile = new File("/storage/emulated/0/a.apk");
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(fileUrl)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                EventBus.getDefault().post(new PbMsg(0,0,0));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inputStream = response.body().byteStream();
                long length = response.body().contentLength();
                Swetfragm(inputStream,length);
            }


        });

    }
    private void Swetfragm(InputStream inputStream, long length) throws IOException {
        EventBus.getDefault().post(new PbMsg(1,0,length)); //获取进度
        int leng = 0;
        byte[] bytes = new byte[4096];
        int count = 0;
       /* int available = inputStream.available();
        int progress = count * 100 / available;*/
        FileOutputStream fileOutputStream =null;
        try {
        fileOutputStream = new FileOutputStream(mFile);
        while ((leng =inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,leng);
            count+=leng;
            EventBus.getDefault().post(new PbMsg(2,count,leng));

         mFragment2Text.setText("上传进度:"+count/100+"%");




          //  ThreadManager.(progress);

            Log.i("111", "savaFile: 总大小："+length+",当前下载了："+count);
        }
            EventBus.getDefault().post(new PbMsg(3,0,0));
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (inputStream!=null){
                    inputStream.close();
                }
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
