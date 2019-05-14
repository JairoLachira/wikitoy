package com.example.jairo.wikitoy2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE operaciones(nombre text, correctas int, incorrectas int)");
        db.execSQL("INSERT INTO operaciones VALUES('suma',0,0)");
        db.execSQL("INSERT INTO operaciones VALUES('resta',0,0)");
        db.execSQL("INSERT INTO operaciones VALUES('multi',0,0)");
        db.execSQL("INSERT INTO operaciones VALUES('divi',0,0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DELETE FROM operaciones");

    }
}
