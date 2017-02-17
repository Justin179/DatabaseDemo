package com.example.justin179.databasedemo;

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

        try{
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
            sqLiteDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Justin',35)");
            sqLiteDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Rob',34)");

            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users",null);
            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");

            cursor.moveToFirst();
            while(cursor!=null){
                Log.i("name",cursor.getString(nameIndex));
                Log.i("age",String.valueOf(cursor.getInt(ageIndex)));
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
