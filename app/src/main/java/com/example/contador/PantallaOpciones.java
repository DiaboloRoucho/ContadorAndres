package com.example.contador;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaOpciones extends AppCompatActivity {

    Button volver;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_opciones);
        volver = findViewById(R.id.volverOps);
        AlertDialog.Builder constructor = new AlertDialog.Builder(this);
        constructor.setMessage("De momento no hay nada en el menu de opciones, en futuras actualizaciones se espera crear todo un apartado de opciones")
                .setTitle("Coming Soon").setIcon(R.drawable.pepisicon);
        AlertDialog dialog = constructor.create();
        dialog.show();
    }
    public void volver(View v){
        finish();
    }
}
