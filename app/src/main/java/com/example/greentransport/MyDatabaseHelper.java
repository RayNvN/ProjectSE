package com.example.greentransport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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

    void addTravel(String currentLocation, String destination, int distance, int cost){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Column_CurrentLocation, currentLocation);
        cv.put(Column_Destination, destination);
        cv.put(Column_Distance, distance);
        cv.put(Column_Cost, cost);
        long result = db.insert(Table_name, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Travel Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + Table_name;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
