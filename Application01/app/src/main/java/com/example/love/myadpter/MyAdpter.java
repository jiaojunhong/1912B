package com.example.love.myadpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.love.application01.R;
import com.example.love.bane.Studnet;

import java.util.ArrayList;

/**
 * Created by love on 2019/9/10.
 */

public class MyAdpter extends RecyclerView.Adapter {


    public MyAdpter(ArrayList<Studnet.DataBean.DatasBean> list, Context context) {
        mList = list;
        this.context = context;

    }

    private ArrayList<Studnet.DataBean.DatasBean> mList;
    private Context context;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item1, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder  = (MyHolder) holder;
        myHolder.mItem1Text.setText(mList.get(position).getTitle());
        Glide.with(context).load(mList.get(position).getEnvelopePic()).into(myHolder.mItem1Image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    class  MyHolder extends RecyclerView.ViewHolder{
        private ImageView mItem1Image;
        private TextView mItem1Text;
        public MyHolder(View itemView) {
            super(itemView);
            mItem1Image = itemView.findViewById(R.id.item1_image);
            mItem1Text = itemView.findViewById(R.id.item1_text);
        }
    }

}
