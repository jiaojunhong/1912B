package com.example.day02.myadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day02.R;
import com.example.day02.bane.Studnet;
import com.example.day02.view.MyView;

import java.util.ArrayList;

public class MyAdpterFragment extends RecyclerView.Adapter {
    private ArrayList<Studnet.DataBean.DatasBean> mlist;
    private Context mContext;


    public MyAdpterFragment(ArrayList<Studnet.DataBean.DatasBean> mlist, Context context) {
        this.mlist = mlist;
        mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_item, null);
        return new Myholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Myholder myholder = (Myholder) holder;
        myholder.mItemText.setText(mlist.get(position).getTitle());
        Glide.with(mContext).load(mlist.get(position).getEnvelopePic()).into(myholder.mItemImage);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class Myholder extends RecyclerView.ViewHolder {
        private ImageView mItemImage;
        private TextView mItemText;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            mItemImage = itemView.findViewById(R.id.item_image);
            mItemText =itemView.findViewById(R.id.item_text);
        }
    }
}
