package com.example.ratha.localnotificationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetail=findViewById(R.id.tv_detail);
        Intent intent=getIntent();
        if(intent!=null){
            String detailText=intent.getStringExtra("detail");
            tvDetail.setText(detailText);
        }

    }
}
