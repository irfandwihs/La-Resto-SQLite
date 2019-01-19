package com.irfandwihs.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView btn_masak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_masak = findViewById(R.id.btn_masak);

        btn_masak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent masak = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(masak);
            }
        });
    }
}
