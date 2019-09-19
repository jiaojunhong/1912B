package com.example.love.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.love.day01.Main2Activity;
import com.example.love.day01.Main3Activity;
import com.example.love.day01.R;
import com.example.love.jiexi.Studnet;
import com.example.love.myapter.MyApter;
import com.example.love.myapter.MyApterfragmnet1;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by love on 2019/8/21.
 */

public class Fragment1 extends Fragment {
    private  int mposition;
    private RecyclerView mFragment1Recy;
    private String url = "http://www.wanandroid.com/project/list/1/json?cid=294";
    private ArrayList<Studnet.DataBean.DatasBean> mList =new ArrayList<>();
    private Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Studnet.DataBean bean = (Studnet.DataBean) msg.obj;
            mList.addAll(bean.getDatas());
            mMyApterfragmnet1.notifyDataSetChanged();

        }
    };
    private MyApterfragmnet1 mMyApterfragmnet1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        initview(view);
        return view;


    }

    private void initview(View view) {
        mFragment1Recy =view. findViewById(R.id.fragment1_recy);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mFragment1Recy.setLayoutManager(manager);
        mMyApterfragmnet1 = new MyApterfragmnet1(mList,getActivity());
        mFragment1Recy.setAdapter(mMyApterfragmnet1);
        initdata();
        mMyApterfragmnet1.setOncreate(new MyApterfragmnet1.Oncreate() {
            @Override
            public void Oncreate(int position) {
                mposition = position;
            }
        });
    }

    private void initdata() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .get()
                .url(url)
                .build();

        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String message = e.getMessage();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Studnet studnet = new Gson().fromJson(string, Studnet.class);
                Message message = Message.obtain();
                message.obj = studnet.getData();
                handler.sendMessage(message);
            }
        });
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Intent intent = new Intent(getActivity(), Main3Activity.class);
                Studnet.DataBean.DatasBean datasBean = mList.get(mposition);
                String chapterName1 = datasBean.getChapterName();
                String chapterName2 = datasBean.getChapterName();
                intent.putExtra("chapterName1",chapterName1);
                intent.putExtra("chapterName2",chapterName2);
                startActivityForResult(intent,1);
                break;
            case 2:
                    mList.remove(mposition);
                    mMyApterfragmnet1.notifyDataSetChanged();
                break;

        }
        return super.onContextItemSelected(item);
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode==1 && resultCode ==2){
//            String name1 = data.getStringExtra("name1");
//            String name2 = data.getStringExtra("name2");
//            Studnet.DataBean.DatasBean datasBean = mList.get(mposition);
//            datasBean.setChapterName(name1);
//            datasBean.setChapterName(name2);
//
//           // mMyApterfragmnet1.notifyDataSetChanged();
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}
