package com.uco.taller.piedra.app;

import com.uco.taller.piedra.dominio.Juego;

import javax.swing.*;
import java.util.Arrays;

public class PiedraApp {
    private static final Object[] OPTIONS = Arrays.asList("Ver resultados", "Jugar", "Ver instrucciones").toArray();

    private static final int RESULTS = 0;
    private static final int PLAY = 1;
    private static final int INSTRUCTIONS = 2;

    private static final String TITLE = "POO - Piedra, Papel o Tijera";

    private static int losses = 0;
    private static int draws = 0;

    private static int wins = 0;

    public static void main(String[] args) {
        while (true) {
            int choice = showMenu();

            switch (choice) {
                case INSTRUCTIONS -> showInstructions();

                case PLAY -> startGame();

                case RESULTS -> showResults();
            }
        }
    }

    public static void showInstructions () {
        String instructions = "El objetivo del juego es escoger un gesto con la mano. Hay tres posibilidades: piedra, papel, tijera.\n\nPiedra vence a tijera\nTijera vence a papel\nPapel vence a piedra\n\nLa computadora escogerá una de las tres opciones disponibles. En caso de escoger la misma opción, habrá un empate para esa ronda. Buena suerte!";

        showMessage(instructions);
    }

    public static void showMessage(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, TITLE, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int showMenu() {
        int option =  JOptionPane.showOptionDialog(null,
                "Bienvenid@!\nQué quieres hacer?",
                TITLE,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                OPTIONS,
                null);

        if (option == JOptionPane.CLOSED_OPTION) {
            System.exit(option);
        }

        return option;
    }

    public static void showResults() {
        String text = "Tú: " + wins + " partidas ganadas";
        text += "\nComputadora: " + losses + " partidas ganadas";
        text += "\nEmpates: " + draws + " partidas.";

        showMessage(text);
    }

    public static void startGame () {
        Juego juego = new Juego();
        String[] options = juego.getOptions();

        Object option = JOptionPane.showInputDialog(null, "Juguemos!\nPor favor, selecciona una opción:", TITLE, JOptionPane.QUESTION_MESSAGE, null, options, null);

        juego.setPlayerChoice(option);
        String message = juego.getResultMessage();

        int result = juego.getResult();

        if (result == -1) losses++;
        else if (result == 0) draws++;
        else if (result == 1) wins++;

        showMessage(message);
    }
}
