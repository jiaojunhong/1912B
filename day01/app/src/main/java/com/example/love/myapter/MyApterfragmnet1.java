package com.example.love.myapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.love.day01.R;
import com.example.love.jiexi.Studnet;

import java.util.ArrayList;

/**
 * Created by love on 2019/8/21.
 */

public class MyApterfragmnet1 extends RecyclerView.Adapter{
    private ArrayList<Studnet.DataBean.DatasBean> mList;
    private Context context;

    public MyApterfragmnet1(ArrayList<Studnet.DataBean.DatasBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            View view = LayoutInflater.from(context).inflate(R.layout.fragment1_item1, parent, false);
            return  new Myholder1(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.fragment1_item2, parent, false);
            return  new Myholder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        if (viewType==0){
            Myholder1 myholder1 = (Myholder1) holder;
            myholder1.mText1.setText(mList.get(position).getChapterName());
            myholder1.mText2.setText(mList.get(position).getChapterName());
            Glide.with(context).load(mList.get(position).getEnvelopePic()).into(myholder1.mImag);
        }else {
            Myholder2 myholder2 = (Myholder2) holder;
            Glide.with(context).load(mList.get(position).getEnvelopePic()).into(myholder2.mImage1);
            Glide.with(context).load(mList.get(position).getEnvelopePic()).into(myholder2.mImage2);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Oncreate.Oncreate(position);
            }
        });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return  0;

        }else {
            return 1;
        }
    }

    class  Myholder1 extends RecyclerView.ViewHolder{

        private final ImageView mImag;
        private final TextView mText1;
        private final TextView mText2;

        public Myholder1(View itemView) {
            super(itemView);
            mImag = itemView.findViewById(R.id.item1_image);
            mText1 = itemView.findViewById(R.id.item1_text1);
            mText2 = itemView.findViewById(R.id.item1_text2);
            itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                    contextMenu.add(1,1,1,"修改");
                    contextMenu.add(1,2,1,"删除");
                }
            });

        }
    }
    class  Myholder2 extends RecyclerView.ViewHolder{


        private final ImageView mImage1;
        private final ImageView mImage2;

        public Myholder2(View itemView) {
            super(itemView);
            mImage1 = itemView.findViewById(R.id.item2_image1);
            mImage2 = itemView.findViewById(R.id.item2_image2);

        }
    }
    public  interface  Oncreate{
        void  Oncreate(int position);
    }
    Oncreate Oncreate;

    public void setOncreate(Oncreate oncreate) {
        Oncreate = oncreate;
    }
}
