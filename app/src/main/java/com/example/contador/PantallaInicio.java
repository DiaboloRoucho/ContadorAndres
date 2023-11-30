package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaInicio extends AppCompatActivity {
    Button jugar, autores, salir;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
    }

    public void irMainActivity(View v){
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
    }
    public void irAutores(View v){
        Intent i = new Intent(this, PantallaInfo.class);
        startActivity(i);
    }
    public void irOpciones(View v){
        Intent i = new Intent(this, PantallaOpciones.class);
        startActivity(i);
    }
    public void finalizar (View v){
        finish();
    }
}
