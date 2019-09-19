package com.example.love.day01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {

    private ImageView mMain3Image;
    private EditText mMain3Edit1;
    private EditText mMain3Edit2;
    private Button mMain3Button;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mIntent = getIntent();
        String chapterName1 = mIntent.getStringExtra("chapterName1");
        String chapterName2 = mIntent.getStringExtra("chapterName2");
        mMain3Edit1.setText(chapterName1);
        mMain3Edit1.setText(chapterName2);
        initeview();

    }

    private void initeview() {
        //mMain3Image = findViewById(R.id.main3_image);
        mMain3Edit1 = findViewById(R.id.main3_edit1);
        mMain3Edit2 = findViewById(R.id.main3_edit2);
        mMain3Button = findViewById(R.id.main3_button);
        mMain3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = mMain3Edit1.getText().toString();
                String name2 = mMain3Edit2.getText().toString();
                mIntent.putExtra("name1",name1);
                mIntent.putExtra("name2",name2);
                setResult(2,mIntent);
                finish();
            }
        });
    }
}
