package com.example.contador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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

    void añadirUsuario(String usuario, String contraseña){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USUARIO, usuario.toUpperCase());
        cv.put(COLUMN_CONTRASEÑA, contraseña);
        cv.put(COLUMN_SUMA, "0");
        cv.put(COLUMN_PRECIO1, "100");
        cv.put(COLUMN_PRECIO2, "150");
        cv.put(COLUMN_PRECIO3, "300");
        cv.put(COLUMN_PRECIO4, "600");
        cv.put(COLUMN_INCREMENTO1, "0");
        cv.put(COLUMN_INCREMENTO2, "0");
        cv.put(COLUMN_INCREMENTO3, "0");
        cv.put(COLUMN_CLICK, "1");
        cv.put(COLUMN_N1, "0");
        cv.put(COLUMN_N2, "0");
        cv.put(COLUMN_N3, "0");

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "No se ha podido guardar", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Guardado", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor ReadData(String usuario){
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_USUARIO + " = " + usuario + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    Cursor buscarUsuario(String usuario){
        String query = "SELECT " + COLUMN_CONTRASEÑA + " FROM " + TABLE_NAME + " WHERE " + COLUMN_USUARIO + " = " + usuario + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    void guardarDatos(String usuario, String suma, String precio1, String precio2, String precio3, String precio4, String incremento1, String incremento2, String incremento3, String click, String n1, String n2, String n3){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_SUMA, suma);
        cv.put(COLUMN_PRECIO1, precio1);
        cv.put(COLUMN_PRECIO2, precio2);
        cv.put(COLUMN_PRECIO3, precio3);
        cv.put(COLUMN_PRECIO4, precio4);
        cv.put(COLUMN_INCREMENTO1, incremento1);
        cv.put(COLUMN_INCREMENTO2, incremento2);
        cv.put(COLUMN_INCREMENTO3, incremento3);
        cv.put(COLUMN_CLICK, click);
        cv.put(COLUMN_N1, n1);
        cv.put(COLUMN_N2, n2);
        cv.put(COLUMN_N3, n3);
        long result = db.update(TABLE_NAME, cv, COLUMN_USUARIO + " = ?", new String[]{usuario.toUpperCase()});
        if (result == -1){
            Toast.makeText(context, "Fallo al guardar", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Guardado", Toast.LENGTH_SHORT).show();
        }
    }

}
