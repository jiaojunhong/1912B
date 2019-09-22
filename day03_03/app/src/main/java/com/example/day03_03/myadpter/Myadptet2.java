package com.example.day03_03.myadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day03_03.R;
import com.example.day03_03.bane.Studnet;
import com.example.day03_03.modler.MyModelr;

import java.util.ArrayList;

public class Myadptet2 extends RecyclerView.Adapter {
    private ArrayList<Studnet.BodyBean.ResultBean> mList;
    private Context mContext;


    public Myadptet2(ArrayList<Studnet.BodyBean.ResultBean> list, Context context) {
        mList = list;
        mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item2, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyHolder myHolder = (MyHolder) holder;
        Glide.with(mContext).load(mList.get(position).getTeacherPic()).apply(new RequestOptions().circleCrop()).into(myHolder.mItem2Image);
        myHolder.mItem2Text1.setText(mList.get(position).getTeacherName());
        myHolder.mItem2Text2.setText(mList.get(position).getTitle());
        myHolder.mItem2Text3.setText(mList.get(position)+"#人力资源");
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Oncreate.OncreateC(position);
            }
        });

        myHolder.mItem2Buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = myHolder.mItem2Buton.getText().toString();
                if (s.matches("关注")){

                    myHolder.mItem2Buton.setText("取消");
                    Oncreate.OncreateA(position);
                }else {
                    myHolder.mItem2Buton.setText("关注");
                    Oncreate.OncreateB(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private ImageView mItem2Image;
        private TextView mItem2Text1;
        private TextView mItem2Text2;
        private TextView mItem2Text3;
        private Button mItem2Buton;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mItem2Image = itemView.findViewById(R.id.item2_image);
            mItem2Text1 = itemView.findViewById(R.id.item2_text1);
            mItem2Text2 = itemView.findViewById(R.id.item2_text2);
            mItem2Text3 = itemView.findViewById(R.id.item2_text3);
            mItem2Buton = itemView.findViewById(R.id.item2_buton);
        }
    }
    private Oncreate Oncreate;


    public interface  Oncreate{
        void OncreateA(int position);
        void OncreateB(int position);
        void OncreateC(int position);
    }

    public void setOncreate(Myadptet2.Oncreate oncreate) {
        Oncreate = oncreate;
    }
}
