package com.example.day03_02.baen;

import java.util.ArrayList;

public class PbMog {
    private ArrayList<Studnet.ResultsBean> liist;
    private int post;

    public PbMog(ArrayList<Studnet.ResultsBean> liist, int post) {
        this.liist = liist;
        this.post = post;
    }

    public ArrayList<Studnet.ResultsBean> getLiist() {
        return liist;
    }

    public void setLiist(ArrayList<Studnet.ResultsBean> liist) {
        this.liist = liist;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }
}
