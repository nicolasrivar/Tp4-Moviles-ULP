package com.example.tp4.model;

public class Farmacia {
    private String nombre;
    private String horario;
    private int imagenResourceId;

    public Farmacia(String nombre, String horario, int imagenResourceId) {
        this.nombre = nombre;
        this.horario = horario;
        this.imagenResourceId = imagenResourceId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHorario() {
        return horario;
    }

    public int getImagenResourceId() {
        return imagenResourceId;
    }
}