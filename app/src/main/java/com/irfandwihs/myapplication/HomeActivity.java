package com.irfandwihs.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class HomeActivity extends AppCompatActivity {
    ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        close = findViewById(R.id.ic_tutup);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button tntng = findViewById(R.id.about);
        tntng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder bl = new AlertDialog.Builder(HomeActivity.this);
                bl.setTitle("La Resto");
                bl.setMessage("Dibuat oleh Irfan Dwi Haryo Sena");
                    /*bl.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    });*/
                bl.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                });
                bl.setIcon(R.mipmap.la_resto);
                bl.show();


            }
        });

    }


    public void icAppetizer(View view) {
        Intent readAppetizer = new Intent(HomeActivity.this, Read1Activity.class);
        startActivity(readAppetizer);
    }

}
