package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

public class Registro extends AppCompatActivity {

    BigInteger suma, click, incremento, precio, precioraton, valGordo, inc2, precio2, inc3, precio3, n1, n2, n3;
    EditText usuario, contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usuario = findViewById(R.id.textUsuario);
        contraseña = findViewById(R.id.textPassword);

    }
    public void registrarse(View v){

        Intent i =  new Intent(Registro.this, MainActivity.class);
        DbHelper db = new DbHelper(Registro.this);
        String us = usuario.getText().toString().trim();
        db.añadirUsuario(us, contraseña.getText().toString().trim());
        i.putExtra("usuario", us);
        startActivity(i);
        finish();
    }
    public void login (View v){
        Intent i  = new Intent(Registro.this, MainActivity.class);
        DbHelper db = new DbHelper(this);
        String pw = contraseña.getText().toString().trim();
        Cursor cursor = db.ReadData(pw);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
        } else if (cursor.getString(2).equals(pw)) {
            i.putExtra("usuario", pw);
            startActivity(i);
            finish();
        } else Toast.makeText(this, "Contraseña invalida", Toast.LENGTH_SHORT).show();
    }
}