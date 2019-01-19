package com.irfandwihs.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.irfandwihs.myapplication.DBHelper;
import com.irfandwihs.myapplication.R;

public class ReadResep1 extends AppCompatActivity {
    protected Cursor cursor;
    DBHelper dbHelper;
    Button btn_btl;
    TextView txt_no_1, txt_judul_1, txt_kategori_1, txt_bahan_1, txt_intruksi_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rd1);

        dbHelper = new DBHelper(this);
        txt_no_1 = findViewById(R.id.edt_no_1);
        txt_judul_1 = findViewById(R.id.edt_judul_1);
        txt_kategori_1 = findViewById(R.id.edt_kategori_1);
        txt_bahan_1 = findViewById(R.id.edt_bahan_1);
        txt_intruksi_1 = findViewById(R.id.edt_intruksi_1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM resep WHERE judul = '" +
                getIntent().getStringExtra("judul") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            txt_no_1.setText(cursor.getString(0).toString());
            txt_judul_1.setText(cursor.getString(1).toString());
            txt_kategori_1.setText(cursor.getString(2).toString());
            txt_bahan_1.setText(cursor.getString(3).toString());
            txt_intruksi_1.setText(cursor.getString(4).toString());
        }
        btn_btl = findViewById(R.id.btn_batal_1);
        btn_btl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                finish();
            }
        });
    }
}
