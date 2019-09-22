package com.example.day03_03.padgert;

import com.example.day03_03.bane.Studnet;
import com.example.day03_03.modler.MyModelr;
import com.example.day03_03.view.MyView;

import java.util.List;

public class Mypaetet implements MyModelr.Oncreatk {
    private MyView mMyView;
    private MyModelr mMyModelr;

    public Mypaetet(MyView myView) {
        mMyView = myView;
        mMyModelr = new MyModelr();
    }

    public void addtoonst() {
        MyModelr.addtext(this);
    }

    @Override
    public void addtext(List<Studnet.BodyBean.ResultBean> list) {
        mMyView.addlist(list);
    }

    @Override
    public void onFion(String str) {
        mMyView.showtite(str);
    }
}
