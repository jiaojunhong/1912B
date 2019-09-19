package com.example.love.application01;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.example.love.fragment.Fragment1;
import com.example.love.fragment.Fragment2;

public class MainActivity extends AppCompatActivity {

    private Toolbar mMainToolbar;
    private FrameLayout mMainFragment;
    private TabLayout mMainTab;
    private Fragment1 mFragment1;
    private Fragment2 mFragment2;
    private FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview() {
        mMainToolbar = findViewById(R.id.main_toolbar);
        mMainToolbar.setTitle("首页");
        setSupportActionBar(mMainToolbar);

        mMainTab = findViewById(R.id.main_tab);
        mMainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0){
                    mManager.beginTransaction().replace(R.id.main_fragment, mFragment1).commit();
                }else {
                    mManager.beginTransaction().replace(R.id.main_fragment, mFragment2).commit();
                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        intframgnet();
        mMainTab.addTab(mMainTab.newTab().setText("首页").setIcon(R.drawable.tab1));
        mMainTab.addTab(mMainTab.newTab().setText("下载").setIcon(R.drawable.tab2));
    }

    private void intframgnet() {
        mFragment1 = new Fragment1();
        mFragment2 = new Fragment2();
        mManager = getSupportFragmentManager();
        mManager.beginTransaction().replace(R.id.main_fragment, mFragment1).commit();
    }


}
