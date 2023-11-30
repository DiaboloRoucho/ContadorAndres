package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        Intent intent =  new Intent(Registro.this, MainActivity.class);
        DbHelper db = new DbHelper(Registro.this);
        db.añadirUsuario(usuario.getText().toString().trim(), contraseña.getText().toString().trim());
        intent.putExtra("usuario", usuario.getText().toString().trim());
        startActivity(intent);
        finish();
    }
    public void login (View v){
        Intent i  = new Intent(Registro.this, MainActivity.class);
        i.putExtra("usuario", usuario.getText().toString().trim());
        startActivity(i);
        finish();
    }
}