package com.example.day03_02;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.day03_02.baen.ApService;
import com.example.day03_02.baen.PbMog;
import com.example.day03_02.baen.Studnet;
import com.example.day03_02.baen.Mypatert;
import com.example.day03_02.baen.MyView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MyView{


    private RecyclerView mMainRecy;
    private ArrayList<Studnet.ResultsBean> mList;
    private MyAdapter mMyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initview();
       initpaget();



    }

    private void initpaget() {
        Mypatert mypatert = new Mypatert(this);
        mypatert.addtete();
    }

    private void initview() {

        mMainRecy = findViewById(R.id.main_recy);

       mMainRecy.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        /*mMainRecy.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//不设置的话，图片闪烁错位，有可能有整列错位的情况。
        mMainRecy.addItemDecoration(new GridSpacingItemDecoration(40));//边距和分割线，需要自己定义*/
        mList = new ArrayList<>();

        mMyAdapter = new MyAdapter(mList, this);
        mMainRecy.setAdapter(mMyAdapter);//设置适配器

        mMyAdapter.setOncreate(new MyAdapter.Oncreate() {
            @Override
            public void oncreatelong(int position) {
                Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                EventBus.getDefault().postSticky(new PbMog(mList,position));
                startActivity(intent);
            }
        });


    }



   @Override
    public void addList(List<Studnet.ResultsBean> list) {
        Log.i("TAG", "onNext:Studnet00 "+list.toString());

        mList.addAll(list);
        mMyAdapter.notifyDataSetChanged();
    }

    @Override
    public void showtie(String str) {
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
    }
}
