package com.example.contador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.ViewHolder> {
    List <Persona> personas;
    public PersonaAdapter(List<Persona> userModelList){this.personas =userModelList;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_listview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(personas.get(position));
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }
    static  class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView nombre, localidad;
        private final ImageView imagen;
        public ViewHolder(View v){
            super(v);
            nombre = (TextView) v.findViewById(R.id.itemTextView1);
            localidad = (TextView) v.findViewById(R.id.itemTextView2);
            imagen = v.findViewById(R.id.itemImageView);
        }
        void bind(Persona persona){
            nombre.setText(persona.getNombre());
            localidad.setText(persona.getLocalidad());
            imagen.setImageResource(persona.getImagen());
        }
    }
}
