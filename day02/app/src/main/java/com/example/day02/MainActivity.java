package com.example.day02;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day02.bane.Studnet;
import com.example.day02.fragment.Fragment1;
import com.example.day02.fragment.Fragment2;
import com.example.day02.myadpter.MyAdpter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mMainToo;
    private ViewPager mMainViewpager;
    private TabLayout mMainTab;
    private ArrayList<Studnet.DataBean.DatasBean> mList;
    private MyAdpter mAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        mMainToo = findViewById(R.id.main_too);
        mMainToo.setTitle("too");
        setSupportActionBar(mMainToo);
        mMainViewpager = findViewById(R.id.main_viewpager);
        mMainTab = findViewById(R.id.main_tab);
        mMainTab.setupWithViewPager(mMainViewpager);
        mAdpter = new MyAdpter(getSupportFragmentManager(),intiDatat());
        mMainViewpager.setAdapter(mAdpter);
        mMainTab.getTabAt(0).setText("首页").setIcon(R.drawable.tab1);
        mMainTab.getTabAt(1).setText("下载").setIcon(R.drawable.tab2);
    }

    private ArrayList<Fragment> intiDatat() {
        ArrayList<Fragment> list = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        list.add(fragment1);
        list.add(fragment2);

        return list;
    }
}
