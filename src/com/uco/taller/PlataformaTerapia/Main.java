package com.uco.taller.PlataformaTerapia;

import com.uco.taller.PlataformaTerapia.dominio.PlataformaTerapia;
import com.uco.taller.PlataformaTerapia.dominio.Terapeuta;

public class Main {
    public static void main(String[] args) {
        PlataformaTerapia plataforma = new PlataformaTerapia();

        // registrar algunos terapeutas
        plataforma.registrarTerapeuta("luis", 700);
        plataforma.registrarTerapeuta("jaime", 400);
        plataforma.registrarTerapeuta("gabriel", 500);
        plataforma.registrarTerapeuta("maicol", 600);

        // ordenar por tarifa descendente
        plataforma.ordenarTerapeutasPorTarifa();

        // eliminar no existente
        plataforma.eliminarTerapeuta("luke");

        // eliminar existente
        plataforma.eliminarTerapeuta("luis");

        // ordenar nuevamente para demostrar eliminado
        plataforma.ordenarTerapeutasPorTarifa();

        // registrar terapeuta con tarifa ya existente para mostrar lista
        plataforma.registrarTerapeuta("alejo", 600);

        // buscar lista de terapeutas por precio
        plataforma.buscar(600).forEach(terapeuta -> System.out.println(terapeuta.getNombre() + ": tarifa $" + terapeuta.getTarifa()));

        // añadir especialidades
        Terapeuta alejo = plataforma.buscar("alejo");
        alejo.addEspecialidad("depresión");

        Terapeuta maicol = plataforma.buscar("maicol");
        maicol.addEspecialidad("depresión");

        // buscar por especialidad
        System.out.println("\nLista de terapeutas por especialidad: depresión");

        plataforma.buscarPorEspecialidad("depresión").forEach(terapeuta -> System.out.println(terapeuta.getNombre()));

        // buscar con más de dos especialidades
        System.out.println("\nLista de terapeutas con dos o más especialidades:");

        plataforma.getTerapeutasConMasDeDosEspecialidades().forEach(terapeuta -> System.out.println(terapeuta.getNombre()));

    }
}
