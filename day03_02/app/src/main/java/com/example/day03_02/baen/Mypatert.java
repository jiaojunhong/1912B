package com.example.day03_02.baen;

import com.example.day03_02.baen.Studnet;
import com.example.day03_02.baen.MyModer;
import com.example.day03_02.baen.MyView;

import java.util.List;

public class Mypatert implements MyModer.OncreatLong {
    private MyView mMyView;
    private MyModer mMyModer;

    public Mypatert(MyView myView) {
        mMyView = myView;
        mMyModer = new MyModer();
    }

    public void addtete() {
        mMyModer.adtate(this);

    }

    @Override
    public void addtite(List<Studnet.ResultsBean> list) {
        mMyView.addList(list);
    }

    @Override
    public void onfint(String str) {
        mMyView.showtie(str);
    }
}
