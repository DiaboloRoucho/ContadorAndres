package com.example.contador;

public class Persona {
    private final String nombre, localidad;
    private final int imagen;
    public Persona (String nombre, String localidad, int imagen){
        this.nombre = nombre;
        this.localidad = localidad;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public int getImagen() {
        return imagen;
    }
}
