package com.example.day02.bane;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public  class Intexiazai {
     static  String  fileUrl = "http://cdn.banmi.com/banmiapp/apk/banmi_330.apk ";//文件的网络路径
    private static File mFile;

    public  static  void  initdatat() {
        mFile = new File("/storage/emulated/legacy/aa.apk");

        try {
            mFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(fileUrl)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

               final InputStream in = response.body().byteStream();
                final long max = response.body().contentLength();
                suen(in,max);

            }
        });

    }

    private  static void suen(InputStream in, long max) {
        int leng = 0;
        byte[] bytes = new byte[4096];
        int count = 0;
        FileOutputStream fileout = null;
        try {
            fileout = new FileOutputStream(mFile);
            while ((leng = in.read(bytes)) != -1) {
                fileout.write(bytes, 0, leng);
                count += leng;
                EventBus.getDefault().post(new Bpment(count,max));
                Log.i("TAG", "sent: 总的大小：" + max + "下载" + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (fileout!=null){
                    fileout.close();
                }
                if (in!=null){
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }



}
