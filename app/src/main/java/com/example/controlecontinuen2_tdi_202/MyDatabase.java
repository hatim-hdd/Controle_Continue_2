package com.example.controlecontinuen2_tdi_202;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {

    public static String DB_NAME="entreprises.db";
    public static String TABLE_NAME="entreprise";
    public static String COL1="id";
    public static String COL2="raison_sociale";
    public static String COL3="adresse";
    public static String COL4="capitale";


    public MyDatabase(Context c){
        super(c,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TABLE_NAME + "("+COL1+" integer primary key autoincrement,"+COL2+" TEXT,"+COL3+" TEXT,"+COL4+" double)";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql= "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);

    }
    public static long add_entreprise(SQLiteDatabase db, entreprise e){
        ContentValues cv = new ContentValues();
        cv.put(COL2,e.getRaison_sociale());
        cv.put(COL3,e.getAdresse());
        cv.put(COL4,e.getCapitale());
        return db.insert(TABLE_NAME,null,cv);
    }
    public static long update_entreprise(SQLiteDatabase sqLiteDatabase, entreprise e){
        ContentValues cv = new ContentValues();
        cv.put(COL2,e.getRaison_sociale());
        cv.put(COL3,e.getAdresse());
        cv.put(COL4,e.getCapitale());
        return sqLiteDatabase.update(TABLE_NAME,cv,"id="+e.getId(),null);
    }
}
