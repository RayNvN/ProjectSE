package com.example.greentransport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String Database_name = "Travel_Database";
    private static final int Database_version = 1;
    private static final SQLiteDatabase.CursorFactory factory = null;
    private static final String Table_name = "Travel_Table";
    private static final String Column_Id = "ID";
    private static final String Column_CurrentLocation = "Current_location";
    private static final String Column_Destination = "Destination";
    private static final String Column_Distance = "Distance";
    private static final String Column_Cost = "Cost";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, Database_name, factory, Database_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Table_name + " (" + Column_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Column_CurrentLocation + " TEXT, " + Column_Destination + " TEXT, " + Column_Distance + " TEXT, " + Column_Cost + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(db);
    }
}
