package com.uco.taller.agenda;
import com.uco.taller.agenda.dominio.Agenda;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.crearContacto("Luis", "Sanchez", 55555);
        agenda.crearContacto("Jaime", "Limas", 66666);
        agenda.crearContacto("William", "Restrepo", 99999);
        agenda.crearContacto("Maicol", "Oviedo", 77777);
        agenda.crearContacto("Luis", "Gómez", 88888);
        agenda.crearContacto("Andrés", "Alonso", 44444);

        agenda.ordenarAlfabeticamente();
    }
}