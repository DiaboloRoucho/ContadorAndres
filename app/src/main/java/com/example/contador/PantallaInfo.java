package com.example.contador;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class PantallaInfo extends ListActivity implements AdapterView.OnItemClickListener {
    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_info);
        volver = findViewById(R.id.volverInfo);
        List<Persona> p = Arrays.asList(
                new Persona("Andrés Delgado", "Barros", R.drawable.person_pin_fill0_wght400_grad0_opsz24),
                new Persona("Andrés Delgado", "Barros", R.drawable.person_pin_fill0_wght400_grad0_opsz24),
                new Persona("Andrés Delgado", "Barros", R.drawable.person_pin_fill0_wght400_grad0_opsz24)
        );
        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.activity_item_listview, p);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
        Persona persona = (Persona) adapterView.getItemAtPosition(i);
        Toast.makeText(this, persona.getNombre(), Toast.LENGTH_LONG).show();
    }
    public void volver(View v){
        finish();
    }

}
