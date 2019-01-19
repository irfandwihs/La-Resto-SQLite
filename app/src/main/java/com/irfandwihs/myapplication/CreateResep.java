package com.irfandwihs.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateResep extends AppCompatActivity {
    protected Cursor cursor;
    DBHelper dbHelper;
    Button create_1, back_1;
    EditText ed_no_1, ed_judul_1, ed_kategori_1, ed_bahan_1, ed_intruksi_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        dbHelper = new DBHelper(this);
        ed_no_1 = (EditText) findViewById(R.id.edt_no_1);
        ed_judul_1 = (EditText) findViewById(R.id.edt_judul_1);
        ed_kategori_1 = (EditText) findViewById(R.id.edt_kategori_1);
        ed_bahan_1 = (EditText) findViewById(R.id.edt_bahan_1);
        ed_intruksi_1 = (EditText) findViewById(R.id.edt_intruksi_1);
        create_1 = (Button) findViewById(R.id.btn_create_1);
        back_1 = (Button) findViewById(R.id.btn_back_1);

        create_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into resep(no, judul, kategori, bahan, intruksi) values('" +
                        ed_no_1.getText().toString() + "','" +
                        ed_judul_1.getText().toString() + "','" +
                        ed_kategori_1.getText().toString() + "','" +
                        ed_bahan_1.getText().toString() + "','" +
                        ed_intruksi_1.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Resep berhasil ditambahkan", Toast.LENGTH_LONG).show();
                Read1Activity.read1.RefreshList();
                finish();
            }
        });
        back_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                finish();
            }
        });
    }
}
