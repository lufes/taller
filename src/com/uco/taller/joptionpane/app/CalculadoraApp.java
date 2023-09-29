package com.uco.taller.joptionpane.app;

import com.uco.taller.joptionpane.dominio.Calculadora;

import javax.swing.*;
import java.util.Arrays;

public class CalculadoraApp {
    private static ImageIcon icono = new ImageIcon(CalculadoraApp.class.getResource("logo_uco.jpg"));
    private static final Object[] OPCIONES = Arrays.asList("Sumar", "Restar", "Multiplicar", "Dividir").toArray();
    private static final int SUMAR = 0;
    private static final int RESTAR = 1;
    private static final int MULTIPLICAR = 2;
    private static final int DIVIDIR = 3;

    public static void main(String[] args) {
        while (true) {
            int opcionElegida = mostrarMenu();

            int n1 = recibirNumero("Ingrese el primer número");
            int n2 = recibirNumero("Ingrese el segundo número");

            switch (opcionElegida) {
                case SUMAR -> mostrarMensaje("La suma es " + Calculadora.sumar(n1, n2));
                case RESTAR -> mostrarMensaje("La resta es " + Calculadora.restar(n1, n2));
                case MULTIPLICAR -> mostrarMensaje("El resultado es " + Calculadora.multiplicar(n1, n2));
                case DIVIDIR -> mostrarMensaje("El resultado es " + Calculadora.dividir(n1, n2));
            }
        }
    }

    public static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Calculadora", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Calculadora", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int mostrarMenu() {
        int opcion =  JOptionPane.showOptionDialog(null,
                "¿Qué operación quieres realizar?", "POO",0,
                JOptionPane.QUESTION_MESSAGE, null, OPCIONES, null);

        if (opcion == JOptionPane.CLOSED_OPTION) {
            System.exit(opcion);
        }

        return opcion;
    }

    public static int recibirNumero(String mensaje) {
        int numeroARetornar = 0;
        boolean numeroValido = false;

        do {
            try {
                numeroARetornar = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                numeroValido = true;
            } catch (NumberFormatException e) {
                mostrarError("El número no es válido. Ingreselo nuevamente.");
                e.printStackTrace();
            }
        } while (!numeroValido);

        return numeroARetornar;
    }
}
