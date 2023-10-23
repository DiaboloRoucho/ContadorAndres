package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaInfo extends AppCompatActivity {
    Button volver;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_info);
        volver = findViewById(R.id.volverInfo);
    }
    public void volver(View v){
        finish();
    }

}
