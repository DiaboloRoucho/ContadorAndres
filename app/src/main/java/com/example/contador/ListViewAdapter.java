package com.example.contador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Persona> {
    List<Persona> ll;

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Persona> ll ) {
        super(context, resource, ll);
    }
    public  View getView(int posicion, @Nullable View convertView, @NonNull ViewGroup parent){
        Persona p = getItem(posicion);
        if (convertView==null)
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.activity_item_listview, parent, false);
        ((ImageView)convertView.findViewById(R.id.itemImageView)).setImageResource(p.getImagen());
        ((TextView)convertView.findViewById(R.id.itemTextView1)).setText(p.getNombre());
        ((TextView)convertView.findViewById(R.id.itemTextView2)).setText(p.getLocalidad());
        return convertView;
    }
}
