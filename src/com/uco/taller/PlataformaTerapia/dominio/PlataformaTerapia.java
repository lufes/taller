package com.uco.taller.PlataformaTerapia.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlataformaTerapia {
    public static byte CAPACIDAD = 80;
    private List<Terapeuta> terapeutas;
    private String nombre;

    public PlataformaTerapia() {
        this.terapeutas = new ArrayList<>();
    }

    public Terapeuta buscar(String nombre) {
        return this.terapeutas
                .stream()
                .filter(terapeuta -> terapeuta.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<Terapeuta> buscar(int tarifa) {
        return this.terapeutas
                .stream()
                .filter(terapeuta -> terapeuta.getTarifa() == tarifa)
                .toList();
    }

    public List<Terapeuta> buscarPorEspecialidad (String especialidad) {
        return this.terapeutas
                .stream()
                .filter(terapeuta -> {
                    List<Especialidad> especialidades = terapeuta.getEspecialidades();

                    return !especialidades
                            .stream()
                            .filter(especialidad1 -> especialidad1.getNombre().equals(especialidad))
                            .toList().isEmpty();
                })
                .toList();
    }

    public List<Terapeuta> getTerapeutasConMasDeDosEspecialidades () {
        List<Terapeuta> terapeutas1 = new ArrayList<>();

        this.terapeutas.forEach(terapeuta -> {
            if (terapeuta.getEspecialidades().size() > 1) terapeutas1.add(terapeuta);
        });

        return terapeutas1;
    }

    public void eliminarTerapeuta (String nombre) {
        Terapeuta registrado = this.buscar(nombre);

        if (registrado == null) {
            System.out.println("El terapeuta " + nombre + " no se encontró");
        } else {
            this.terapeutas.remove(registrado);
        }
    }

    public List<Terapeuta> ordenarTerapeutasPorTarifa () {
        Comparator<Terapeuta> tarifaComparator = Comparator.comparing(Terapeuta::getTarifa);

        System.out.println("\nLista ordenada por cantidad de mayor a menor");

        this.terapeutas.sort(tarifaComparator);
        Collections.reverse(this.terapeutas);
        this.terapeutas.forEach(terapeuta -> {
            System.out.print(terapeuta.getNombre() + " - " + terapeuta.getTarifa() + "\n");

            terapeuta.getEspecialidades().forEach(especialidad -> System.out.println("\t" + especialidad.getNombre() + "\n"));
        });

        return this.terapeutas;
    }

    public boolean registrarTerapeuta (String nombre, int tarifa) {
        if (this.terapeutas.size() >= CAPACIDAD) {
            System.out.println("Se alcanzó la máxima capacidad de terapeutas");
            return false;
        }

        Terapeuta registrado = this.buscar(nombre);

        if (registrado == null) {
            Terapeuta terapeuta = new Terapeuta(nombre, tarifa);
            this.terapeutas.add(terapeuta);
            return true;
        } else {
            System.out.println("El terapeuta " + nombre + " ya está registrado");
            return false;
        }
    }
}
