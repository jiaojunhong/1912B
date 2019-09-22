package com.example.day03_02;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.day03_02.baen.PbMog;
import com.example.day03_02.baen.Studnet;
import com.example.day03_02.viewpager.MyViewPager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mMain2Viewpager;
    private TextView mMain2Text;
    private ArrayList<Studnet.ResultsBean> mLiist;
    private int mPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initview();
        EventBus.getDefault().register(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void  getbpMog(PbMog pbMog){
       if (pbMog!=null){
           mLiist = pbMog.getLiist();
           mPost = pbMog.getPost();
           initte();
       }


    }
    private void initview() {
        mMain2Viewpager = findViewById(R.id.main2_viewpager);
    }
    private void initte() {
        MyViewPager myViewPager = new MyViewPager(mLiist,this);
        mMain2Viewpager.setAdapter(myViewPager);
        mMain2Viewpager.setCurrentItem(mPost);
    }
}
