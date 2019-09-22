package com.example.day03_03.padgert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03_03.R;
import com.example.day03_03.bane.Studnet;
import com.example.day03_03.bane.Teacher;
import com.example.day03_03.myadpter.Mypagert2Fragment;
import com.example.day03_03.view.MyView2;

import java.util.ArrayList;
import java.util.List;

public class Fragments extends Fragment implements MyView2 {
    private RecyclerView mFragmentRecycler;

    private ArrayList<Studnet.BodyBean.ResultBean> mList;
    private Mypagert2Fragment mMypagert2Fragment;

    private static ArrayList<Studnet.BodyBean.ResultBean> mTabId;  //刷新不同的数据
    private static int mPage = 191; // 刷新
    public static Fragments getInstance(ArrayList<Studnet.BodyBean.ResultBean> id) {
        mTabId = id;
        return new Fragments();

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment, null);
        initview(view);
        initpagert();
        return view;


    }

    private void initpagert() {
        Mypagert2 mypagert2 = new Mypagert2(this);
        mypagert2.addtate();
    }

    private void initview(View view) {
        mFragmentRecycler = view.findViewById(R.id.fragment_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mFragmentRecycler.setLayoutManager(layoutManager);
        mList = new ArrayList<>();

        //适配器对象
        mMypagert2Fragment = new Mypagert2Fragment(mList,getContext());
        mFragmentRecycler.setAdapter(mMypagert2Fragment);


    }

    @Override
    public void addListab(List<Studnet.BodyBean.ResultBean> list) {
        mList.addAll(list);
        mMypagert2Fragment.notifyDataSetChanged();
    }

    @Override
    public void showtite(String str) {
        Toast.makeText(getContext(),str,Toast.LENGTH_SHORT).show();
    }


}
