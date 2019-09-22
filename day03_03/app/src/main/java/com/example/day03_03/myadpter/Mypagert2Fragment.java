package com.example.day03_03.myadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03_03.R;
import com.example.day03_03.bane.Studnet;
import com.example.day03_03.bane.Teacher;

import java.util.ArrayList;

public class Mypagert2Fragment extends RecyclerView.Adapter {
    private ArrayList<Studnet.BodyBean.ResultBean> mList;
    private Context mContext;

    public Mypagert2Fragment(ArrayList<Studnet.BodyBean.ResultBean> list, Context context) {
        mList = list;
        mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item3, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        myHolder.mtext.setText(mList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    class MyHolder extends RecyclerView.ViewHolder{
        private TextView mtext;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mtext = itemView.findViewById(R.id.item3_text1);
        }
    }

}
