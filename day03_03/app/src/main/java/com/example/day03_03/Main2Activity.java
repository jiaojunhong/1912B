package com.example.day03_03;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.day03_03.bane.PbMog;
import com.example.day03_03.bane.Studnet;
import com.example.day03_03.bane.Teacher;
import com.example.day03_03.bane.Teacher.BodyBean.ResultBean;
import com.example.day03_03.myadpter.MyViewpager;
import com.example.day03_03.myadpter.Myadptet2;
import com.example.day03_03.padgert.Mypagert2;
import com.example.day03_03.view.MyView2;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements MyView2 {

    private ImageView mMain2Image;
    private Toolbar mMain2Toolbar;
    private RecyclerView mMain2Recycler;
    private TabLayout mMain2Tab;
    private ViewPager mMain2Pager;
    private ArrayList<Studnet.BodyBean.ResultBean> mList;
    private Myadptet2 mMyadptet2;
    //private ArrayList<ResultBean> mList1;
    private MyViewpager mViewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initzt();
        initview();
        EventBus.getDefault().register(this); //注册
        inittab();


    }



    private void inittab() {

        mMain2Tab.setupWithViewPager(mMain2Pager); //联动
        mViewpager = new MyViewpager(getSupportFragmentManager(),mList);
        mMain2Pager.setAdapter(mViewpager);
        mMain2Tab.getTabAt(0).setText("介绍");
        mMain2Tab.getTabAt(1).setText("课程");
        mMain2Tab.getTabAt(2).setText("视频");



    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void  getPbMog( Studnet.BodyBean.ResultBean resultBean){
      if (resultBean!=null){
            mList.add(resultBean);
          mMyadptet2.notifyDataSetChanged();

      }
    }

    private void initzt() {
        mMain2Image = findViewById(R.id.main2_image);
        mMain2Tab = findViewById(R.id.main2_tab);
        mMain2Pager = findViewById(R.id.main2_pager);
        mMain2Recycler = findViewById(R.id.main2_recycler);
        mMain2Toolbar = findViewById(R.id.main2_toolbar);
    }

    private void initview() {
        mMain2Toolbar.setTitle("");
        setSupportActionBar(mMain2Toolbar);
        //管理器对象
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mMain2Recycler.setLayoutManager(manager);
        mList = new ArrayList<>();

        //适配器对象
        mMyadptet2 = new Myadptet2(mList,this);
        mMain2Recycler.setAdapter(mMyadptet2);

        mMain2Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mMyadptet2.setOncreate(new Myadptet2.Oncreate() {
            @Override
            public void OncreateA(int position) {
                Toast.makeText(Main2Activity.this,"关注",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OncreateB(int position) {
                Toast.makeText(Main2Activity.this,"取消",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OncreateC(int position) {
                Toast.makeText(Main2Activity.this,"点击",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void addListab(List<Studnet.BodyBean.ResultBean> list) {
        mList.addAll(list);
        mViewpager.notifyDataSetChanged();
    }

    @Override
    public void showtite(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem add = menu.add(1, 1, 1, "搜索");
        add.setIcon(R.mipmap.afg);
        add.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);
    }
}
