package com.example.contador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Usuarios.db";
    private static final int DATABASE_VER = 1;
    private static final String TABLE_NAME = "tabla";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USUARIO = "Usuario";
    private static final String COLUMN_CONTRASEÑA = "Contraseña";
    private static final String COLUMN_SUMA = "Suma";
    private static final String COLUMN_PRECIO1 = "Precio1";
    private static final String COLUMN_PRECIO2 = "Precio2";
    private static final String COLUMN_PRECIO3 = "Precio3";
    private static final String COLUMN_PRECIO4 = "Precio4";
    private static final String COLUMN_INCREMENTO1 = "Incremento1";
    private static final String COLUMN_INCREMENTO2 = "Incremento2";
    private static final String COLUMN_INCREMENTO3 = "Incremento3";
    private static final String COLUMN_CLICK = "Click";
    private static final String COLUMN_N1 = "N1";
    private static final String COLUMN_N2 = "N2";
    private static final String COLUMN_N3 = "N3";
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USUARIO + " TEXT, " +
                COLUMN_CONTRASEÑA + " TEXT, " +
                COLUMN_SUMA + " TEXT, " +
                COLUMN_PRECIO1 + " TEXT, " +
                COLUMN_PRECIO2 + " TEXT, " +
                COLUMN_PRECIO3 + " TEXT, " +
                COLUMN_PRECIO4 + " TEXT, " +
                COLUMN_INCREMENTO1 + " TEXT, " +
                COLUMN_INCREMENTO2 + " TEXT, " +
                COLUMN_INCREMENTO3 + " TEXT, " +
                COLUMN_CLICK + " TEXT, " +
                COLUMN_N1 + " TEXT, " +
                COLUMN_N2 + " TEXT, " +
                COLUMN_N3 + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
