package com.irfandwihs.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Read1Activity extends AppCompatActivity {

    String[] daftar;
    ListView listAppet;
    Menu menu;
    protected Cursor cursor;
    DBHelper dbcenter;
    public static Read1Activity read1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read1);

        Button btn=(Button)findViewById(R.id.tambahAppetizer);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent inte = new Intent(Read1Activity.this,CreateResep.class);
                startActivity(inte);
            }
        });


        read1 = this;
        dbcenter = new DBHelper(this);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM resep",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        listAppet = findViewById(R.id.listAppetizer);
        listAppet.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar));
        listAppet.setSelected(true);
        listAppet.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2]; //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Lihat Resep", "Edit Resep", "Hapus Resep"};
                AlertDialog.Builder builder = new AlertDialog.Builder(Read1Activity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), ReadResep1.class);
                                i.putExtra("judul", selection);
                                startActivity(i);
                                break;
                            case 1 :
                                Intent in = new Intent(getApplicationContext(), UpdateActivity.class);
                                in.putExtra("judul", selection);
                                startActivity(in);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from resep where judul = '"+selection+"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter)listAppet.getAdapter()).notifyDataSetInvalidated();
    }
}
