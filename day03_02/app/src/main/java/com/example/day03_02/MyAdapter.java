package com.example.day03_02;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03_02.baen.Studnet;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter {
    private ArrayList<Studnet.ResultsBean> mList;
    private Context mContext;


    public MyAdapter(ArrayList<Studnet.ResultsBean> list, Context context) {
        mList = list;
        mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("TAG", "onCreateViewHolder: "+mList.size());
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyHolder myHolder = (MyHolder) holder;
       // myHolder.mText.setText(mList.get(position).getTitle());
        Glide.with(mContext).load(mList.get(position).getUrl_1()).into(myHolder.mItemImage);
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Oncreate.oncreatelong(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private ImageView mItemImage;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mItemImage = itemView.findViewById(R.id.item_image);

        }
    }
    private Oncreate Oncreate;
    public  interface Oncreate{
        void  oncreatelong(int position);

    }

    public void setOncreate(MyAdapter.Oncreate oncreate) {
        Oncreate = oncreate;
    }
}
