package com.example.day02.perviet;

import com.example.day02.bane.Studnet;
import com.example.day02.mode.MyMode;
import com.example.day02.view.MyView;

import java.util.ArrayList;

public class MyPafert implements MyMode.Oncreatek {
    private MyMode mMyMode;
    private MyView mMyView;

    public MyPafert(MyView myView) {
        mMyView = myView;
        mMyMode= new MyMode();
    }

    public void addlist() {
        mMyMode.addlist(this);
    }

    @Override
    public void addtteit(ArrayList<Studnet.DataBean.DatasBean> list) {
        mMyView.addList(list);
    }

    @Override
    public void onfion(String str) {
        mMyView.showtito(str);
    }
}
