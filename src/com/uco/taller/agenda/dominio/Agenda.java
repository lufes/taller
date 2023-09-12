package com.uco.taller.agenda.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;

    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    public Contacto buscarPorCelular(long celularABuscar) {
        return this.contactos.stream()
                .filter(contacto -> contacto.getCelular() == celularABuscar)
                .findFirst().orElse(null);
    }

    public List<Contacto> buscarPorNombre(String nombreABuscar) {
        return this.contactos.stream()
                .filter(contact -> contact.getNombre().equalsIgnoreCase(nombreABuscar) || contact.getApellido().equalsIgnoreCase(nombreABuscar))
                .toList();
    }

    public void cambiarCelular(long celularActual, long nuevoCelular) {
        Contacto contactoExistente = this.buscarPorCelular(celularActual);

        if (contactoExistente != null) {
            contactoExistente.celular = nuevoCelular;
        }
    }

    public void crearContacto (String nombre, String apellido, long celular) {
        Contacto c = this.buscarPorCelular(celular);

        if (this.contactos.size() < 50 && c == null) {
            Contacto contactoAAgregar = new Contacto(nombre, apellido, celular);
            this.contactos.add(contactoAAgregar);
        } else {
            System.out.println("El contacto no se pudo crear.");
        }
    }

    public boolean eliminarContacto (long celularAEliminar) {
        Contacto contactoExistente = this.buscarPorCelular(celularAEliminar);

        if (contactoExistente != null) {
            this.contactos.remove(contactoExistente);
            return true;
        }

        return false;
    }

    public List<Contacto> ordenarAlfabeticamente() {
        Comparator<Contacto> nameComparator = Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido);

        this.contactos.sort(nameComparator);

        for (Contacto contacto : this.contactos) {
            System.out.println(contacto.getNombre() + ' ' + contacto.getApellido());
        }

        return this.contactos;
    }
}
