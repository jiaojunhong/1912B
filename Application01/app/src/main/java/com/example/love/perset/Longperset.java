package com.example.love.perset;

import com.example.love.bane.Studnet;
import com.example.love.moder.LongModer;
import com.example.love.view.LongView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by love on 2019/9/10.
 */

public class Longperset implements LongModer.Oncreate{
    private LongView mLongView;
    private LongModer mLongModer;

    public Longperset(LongView longView) {
        mLongView = longView;
        mLongModer = new LongModer();
    }

    public void addtiti() {
        LongModer.addtiti(this);
    }

    @Override
    public void addtite(List<Studnet.DataBean.DatasBean> list) {
        mLongView.addData((ArrayList<Studnet.DataBean.DatasBean>) list);
    }

    @Override
    public void onFile(String str) {
        mLongView.showTilt(str);
    }
}
