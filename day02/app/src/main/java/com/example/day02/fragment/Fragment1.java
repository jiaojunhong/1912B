package com.example.day02.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02.R;
import com.example.day02.bane.Studnet;
import com.example.day02.myadpter.MyAdpterFragment;
import com.example.day02.perviet.MyPafert;
import com.example.day02.view.MyView;

import java.util.ArrayList;

public class Fragment1 extends Fragment implements MyView {
    private RecyclerView mFragment1Rdcler;
    private ArrayList<Studnet.DataBean.DatasBean> mList;
    private MyAdpterFragment mAdpterFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment1, null);
        intiveiw(view);
        inip();
        return view;

    }

    private void inip() {
        MyPafert myPafert = new MyPafert(this);
        myPafert.addlist();
    }

    private void intiveiw(View view) {
        mFragment1Rdcler =view. findViewById(R.id.fragment1_rdcler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mFragment1Rdcler.setLayoutManager(manager);
        mList = new ArrayList<>();
        mAdpterFragment = new MyAdpterFragment(mList,getContext());
        mFragment1Rdcler.setAdapter(mAdpterFragment);


    }

    @Override
    public void addList(ArrayList<Studnet.DataBean.DatasBean> list) {
        mList.addAll(list);
        mAdpterFragment.notifyDataSetChanged();

    }

    @Override
    public void showtito(String str) {

    }
}
