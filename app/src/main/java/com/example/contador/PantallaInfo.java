package com.example.contador;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class PantallaInfo extends AppCompatActivity {
    Button volver;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_info);
        volver = findViewById(R.id.volverInfo);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerViewInfo);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<Persona> l = Arrays.asList(
                new Persona("Joselito", "Laviana", R.drawable.person_pin_fill0_wght400_grad0_opsz24),
                new Persona("Andrecho", "Barros", R.drawable.person_pin_fill0_wght400_grad0_opsz24),
                new Persona("Macarrón", "Italia", R.drawable.person_pin_fill0_wght400_grad0_opsz24),
                new Persona("Ambrosio", "Cuturrasu", R.drawable.person_pin_fill0_wght400_grad0_opsz24)
        );
        rv.setAdapter(new PersonaAdapter(l));
    }
    public void volver(View v){
        finish();
    }

}
