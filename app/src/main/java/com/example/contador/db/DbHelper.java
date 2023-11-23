package com.example.contador.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Contador.db";
    public static final String TABLE_VARIABLES = "Variables";
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_VARIABLES + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                //"usuario TEXT NOT NULL, " +
                //"password TEXT NOT NULL, " +
                "n_variable VARCHAR(10) NOT NULL, " +
                "valor TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_VARIABLES);
        onCreate(sqLiteDatabase);
    }
}
