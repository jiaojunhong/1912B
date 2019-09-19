package com.example.love.day01;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.love.fragment.Fragment1;
import com.example.love.fragment.Fragment2;
import com.example.love.myapter.MyApter;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private Toolbar mMain2Toolbar;

    private TabLayout mMain2Tab;
    private NavigationView mMain2Navigtion;
    private DrawerLayout mMain2Drwer;
    private ViewPager mMain2Viewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initview();


    }

    private void initview() {
        mMain2Toolbar = findViewById(R.id.main2_toolbar);
        mMain2Toolbar.setTitle("标题");
        setSupportActionBar(mMain2Toolbar);
        mMain2Tab = findViewById(R.id.main2_tab);
        mMain2Viewpager = findViewById(R.id.main2_viewpager);
        mMain2Tab.setupWithViewPager(mMain2Viewpager);
        MyApter myApter = new MyApter(getSupportFragmentManager(),initDtat());
        mMain2Viewpager.setAdapter(myApter);
        mMain2Tab.getTabAt(0).setText("首页").setIcon(R.drawable.tab1);
        mMain2Tab.getTabAt(1).setText("我的").setIcon(R.drawable.tab1);
        mMain2Navigtion = findViewById(R.id.main2_navigtion);
        mMain2Drwer = findViewById(R.id.main2_drwer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mMain2Drwer, mMain2Toolbar, R.string.app_name, R.string.app_name);
        mMain2Drwer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private ArrayList<Fragment> initDtat() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        fragments.add(fragment1);
        fragments.add(fragment2);
        return fragments;
    }




}
