package com.example.love.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.love.application01.MainActivity;
import com.example.love.application01.R;
import com.example.love.bane.Studnet;
import com.example.love.myadpter.MyAdpter;
import com.example.love.perset.Longperset;
import com.example.love.view.LongView;

import java.util.ArrayList;

/**
 * Created by love on 2019/9/10.
 */

public class Fragment1 extends Fragment implements LongView{
    private RecyclerView mRecyclerview;
    private ArrayList<Studnet.DataBean.DatasBean> mList;
    private Longperset mLongperset;
    private MyAdpter mMyAdpter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        intview(view);
        intviDatat();
        return view;

    }

    private void intviDatat() {
        mLongperset = new Longperset(this);
        mLongperset.addtiti();
    }

    private void intview(View view) {
        mRecyclerview = view.findViewById(R.id.fragment_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRecyclerview.setLayoutManager(manager);
        mList = new ArrayList<>();
        mMyAdpter = new MyAdpter(mList,getActivity());
        mRecyclerview.setAdapter(mMyAdpter);
        mRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
    }


    @Override
    public void addData(ArrayList<Studnet.DataBean.DatasBean> list) {
        mList.addAll(list);
        mMyAdpter.notifyDataSetChanged();
    }

    @Override
    public void showTilt(String str) {
        Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
    }
}
