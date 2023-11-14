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

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Persona> ll ) {
        super(context, resource, ll);
    }
    @NonNull
    @Override
    public  View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Persona p = getItem(position);
        if (convertView==null)
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.item_listview2, parent, false);
        ((ImageView)convertView.findViewById(R.id.itemImageView)).setImageResource(p.getImagen());
        ((TextView)convertView.findViewById(R.id.itemTextView1)).setText(p.getNombre());
        ((TextView)convertView.findViewById(R.id.itemTextView2)).setText(p.getLocalidad());
        return convertView;
    }
}
