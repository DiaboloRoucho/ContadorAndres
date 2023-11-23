package com.example.contador.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbVariables extends DbHelper{

    Context context;
    public DbVariables(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarVariable (String nombre, String valor){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            //values.put("usuario", usuario);
            //values.put("password", password);
            values.put("nombre", nombre);
            values.put("valor", valor);
            id = db.insert(TABLE_VARIABLES, null, values);
        } catch (Exception e){
            e.toString();
        }
        return id;
    }
}
