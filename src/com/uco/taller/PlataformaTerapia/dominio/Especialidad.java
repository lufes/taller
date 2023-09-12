package com.uco.taller.PlataformaTerapia.dominio;

public class Especialidad {
    private String nombre;

    public Especialidad() {
        this.nombre = "Ansiedad";
    }

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
