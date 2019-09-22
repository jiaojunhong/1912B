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

import java.util.ArrayList;

public class MyAdpter extends RecyclerView.Adapter {
    private ArrayList<Studnet.BodyBean.ResultBean> mList;
    private Context mContext;


    public MyAdpter(ArrayList<Studnet.BodyBean.ResultBean> list, Context context) {
        mList = list;
        mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item1, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyHolder myHolder = (MyHolder) holder;
        myHolder.mItemText1.setText(mList.get(position).getTeacherName());
        myHolder.mItemText2.setText(mList.get(position).getTitle());
        Glide.with(mContext).load(mList.get(position).getTeacherPic()).apply(new RequestOptions().circleCrop()).into(myHolder.mItemImage);
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Oncreate.OncreateC(position);
            }
        });
        myHolder.mItemText3.setText(mList.get(position)+"#11111");
        myHolder.mItemButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = myHolder.mItemButon.getText().toString();
                if (s.matches("关注")){

                    myHolder.mItemButon.setText("取消");
                    Oncreate.OncreateA(position);
                }else {
                    myHolder.mItemButon.setText("关注");
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
        private ImageView mItemImage;
        private TextView mItemText1;
        private TextView mItemText2;
        private TextView mItemText3;
        private Button mItemButon;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mItemImage = itemView.findViewById(R.id.item_image);
            mItemText1 = itemView.findViewById(R.id.item_text1);
            mItemText2 = itemView.findViewById(R.id.item_text2);
            mItemText3 = itemView.findViewById(R.id.item_text3);
            mItemButon = itemView.findViewById(R.id.item_buton);
        }
    }
    private  Oncreate Oncreate;

    public void setOncreate(MyAdpter.Oncreate oncreate) {
        Oncreate = oncreate;
    }

    public  interface Oncreate{
        void OncreateA(int position);
        void OncreateB(int position);
        void OncreateC(int position);
    }
}
