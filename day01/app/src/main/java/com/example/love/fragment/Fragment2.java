package com.example.love.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.love.day01.R;

/**
 * Created by love on 2019/8/21.
 */

public class Fragment2 extends Fragment {
    private WebView mFragment2Web;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, null);
        initview(view);
        return view;


    }

    private void initview(View view) {
        mFragment2Web = view.findViewById(R.id.fragment2_web);
        mFragment2Web.loadUrl("http://www.baidu.com/");
    }
}
