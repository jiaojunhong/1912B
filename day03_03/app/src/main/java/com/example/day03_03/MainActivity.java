package com.example.day03_03;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03_03.bane.PbMog;
import com.example.day03_03.bane.Studnet;
import com.example.day03_03.myadpter.MyAdpter;
import com.example.day03_03.padgert.Mypaetet;
import com.example.day03_03.view.MyView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyView {

    private Toolbar mMainToolbar;
    private RecyclerView mMainRecycler;
    private ImageView mMainImage;
    private ArrayList<Studnet.BodyBean.ResultBean> mList;
    private MyAdpter mAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        inpagett();

    }

    private void inpagett() {
        Mypaetet mypaetet = new Mypaetet(this);
        mypaetet.addtoonst();
    }

    private void initview() {
        mMainImage = findViewById(R.id.main_image);
        mMainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mMainToolbar = findViewById(R.id.main_toolbar);

        mMainToolbar.setTitle("");

        setSupportActionBar(mMainToolbar);

        mMainRecycler = findViewById(R.id.main_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mMainRecycler.setLayoutManager(linearLayoutManager);
        mList = new ArrayList<>();
        //创建适配器对象
        mAdpter = new MyAdpter(mList,this);
        mMainRecycler.setAdapter(mAdpter);
        mMainRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        mAdpter.setOncreate(new MyAdpter.Oncreate() {
            @Override
            public void OncreateA(int position) {
                Toast.makeText(MainActivity.this,"关注",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OncreateB(int position) {
                Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OncreateC(int position) {
                Toast.makeText(MainActivity.this,"点击 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Studnet.BodyBean.ResultBean resultBean = mList.get(position);
                EventBus.getDefault().postSticky(resultBean);
                startActivity(intent);
            }
        });
    }

    @Override
    public void addlist(List<Studnet.BodyBean.ResultBean> list) {
        mList.addAll(list);
        mAdpter.notifyDataSetChanged();
    }

    @Override
    public void showtite(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem add = menu.add(1, 1, 1, "搜索");
        add.setIcon(R.mipmap.afg);
        add.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);
    }

}
