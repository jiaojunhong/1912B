package com.example.day03_03.bane;

import java.util.ArrayList;

public class PbMog {
    private ArrayList<Studnet.BodyBean.ResultBean> mArrayList;
    private int post;

    public PbMog(ArrayList<Studnet.BodyBean.ResultBean> arrayList, int post) {
        mArrayList = arrayList;
        this.post = post;
    }

    public ArrayList<Studnet.BodyBean.ResultBean> getArrayList() {
        return mArrayList;
    }

    public void setArrayList(ArrayList<Studnet.BodyBean.ResultBean> arrayList) {
        mArrayList = arrayList;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }
}
