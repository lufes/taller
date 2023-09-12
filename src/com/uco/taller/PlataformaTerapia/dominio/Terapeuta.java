package com.uco.taller.PlataformaTerapia.dominio;

import java.util.ArrayList;
import java.util.List;

public class Terapeuta {
    private String nombre;
    private int tarifa;
    private List<Especialidad> especialidades;

    public Terapeuta(String nombre, int tarifa) {
        this.nombre = nombre;
        this.tarifa = tarifa;

        this.especialidades = new ArrayList<>();

        Especialidad especialidad = new Especialidad();
        this.especialidades.add(especialidad);
    }

    public void addEspecialidad(String descripcion) {
        Especialidad especialidad = new Especialidad(descripcion);
        this.especialidades.add(especialidad);
    }

    public String getNombre() {
        return nombre;
    }

    public int getTarifa() {
        return tarifa;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }
}
