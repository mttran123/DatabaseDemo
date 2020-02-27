package com.example.gohasu.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)"); //VARCHAR aka String, 3 - 3 digits

//        myDatabase.execSQL("INSERT INTO newUsers (name,age) VALUES ('Mai', 31)");
//        myDatabase.execSQL("INSERT INTO newUsers (name,age) VALUES ('Vi An', 5)");
//        myDatabase.execSQL("INSERT INTO newUsers (name,age) VALUES ('Duong', 32)");

        myDatabase.execSQL("DELETE FROM newUsers WHERE id=3");

        Cursor c = myDatabase.rawQuery("SELECT * FROM newUsers", null);

        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");
        int idIndex = c.getColumnIndex("id");

        c.moveToFirst();

        while(!c.isAfterLast()) {
            Log.i("UserResult - name", c.getString(nameIndex));
            Log.i("UserResult - age", c.getString(ageIndex));
            Log.i("UserResult - id", c.getString(idIndex));

            c.moveToNext();
        }
    }
}
