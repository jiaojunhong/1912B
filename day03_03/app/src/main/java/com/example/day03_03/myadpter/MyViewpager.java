package com.example.day03_03.myadpter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.day03_03.bane.Studnet;
import com.example.day03_03.bane.Teacher;
import com.example.day03_03.padgert.Fragments;

import java.util.ArrayList;
import java.util.List;

public class MyViewpager extends FragmentPagerAdapter {
    private ArrayList<Studnet.BodyBean.ResultBean> mList;

    public MyViewpager(@NonNull FragmentManager fm, ArrayList<Studnet.BodyBean.ResultBean> list) {
        super(fm);
        mList = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //数据

        return  Fragments.getInstance(mList);
    }

    @Override
    public int getCount() {
        return 3;
    }

   /* @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position).getDescription();
    }*/
}
