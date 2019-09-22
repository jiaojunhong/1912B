package com.example.day03_03.padgert;

import com.example.day03_03.bane.Studnet;
import com.example.day03_03.bane.Teacher;
import com.example.day03_03.modler.MyModler2;
import com.example.day03_03.view.MyView2;

import java.util.ArrayList;
import java.util.List;

public class Mypagert2 implements MyModler2.Oncreatk2 {
    private MyView2 mMyView2;
    private MyModler2 mMyModler2;

    public Mypagert2(MyView2 myView2) {
        mMyView2 = myView2;
        mMyModler2 = new MyModler2();

    }

    public void addtate() {
        mMyModler2.addtate(this);
    }

    @Override
    public void addtext(List<Studnet.BodyBean.ResultBean> list) {
        mMyView2.addListab(list);
    }

    @Override
    public void onFion(String str) {
        mMyView2.showtite(str);
    }
}
