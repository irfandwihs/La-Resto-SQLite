package com.irfandwihs.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    protected Cursor cursor;
    DBHelper dbHelper;
    Button update_1, back_1;
    EditText ed_no_1, ed_judul_1, ed_kategori_1, ed_bahan_1, ed_intruksi_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbHelper = new DBHelper(this);
        ed_no_1 = (EditText) findViewById(R.id.edt_no_1);
        ed_judul_1 = (EditText) findViewById(R.id.edt_judul_1);
        ed_kategori_1 = (EditText) findViewById(R.id.edt_kategori_1);
        ed_bahan_1 = (EditText) findViewById(R.id.edt_bahan_1);
        ed_intruksi_1 = (EditText) findViewById(R.id.edt_intruksi_1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM resep WHERE judul = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            ed_no_1.setText(cursor.getString(0).toString());
            ed_judul_1.setText(cursor.getString(1).toString());
            ed_kategori_1.setText(cursor.getString(2).toString());
            ed_bahan_1.setText(cursor.getString(3).toString());
            ed_intruksi_1.setText(cursor.getString(4).toString());
        }
        update_1 = (Button) findViewById(R.id.btn_update_1);
        back_1 = (Button) findViewById(R.id.btn_back_1);

        update_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update resep set judul='"+
                        ed_judul_1.getText().toString() +"', kategori='" +
                        ed_kategori_1.getText().toString()+"', bahan='"+
                        ed_bahan_1.getText().toString() +"', intruksi='" +
                        ed_intruksi_1.getText().toString() + "' where no='" +
                        ed_no_1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
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
