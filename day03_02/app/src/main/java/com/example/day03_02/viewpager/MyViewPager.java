package com.example.day03_02.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.day03_02.R;
import com.example.day03_02.baen.Studnet;

import java.util.ArrayList;

public class MyViewPager extends PagerAdapter{
    private ArrayList<Studnet.ResultsBean> mList;
    private Context mContext;

    public MyViewPager(ArrayList<Studnet.ResultsBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_pager, null);
        ImageView image = view.findViewById(R.id.item_image);
        TextView text = view.findViewById(R.id.item_text);
        text.setText(position+"/20");
        Glide.with(mContext).load(mList.get(position).getUrl_1()).into(image);
        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
