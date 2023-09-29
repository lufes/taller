package com.uco.taller.piedra.dominio;

import java.util.Random;

public class Juego {

    private static final String[] OPTIONS = { "Piedra", "Papel", "Tijera" };

    private final int computerChoice;
    private int playerChoice;

    public Juego() {
        Random random = new Random();
        this.computerChoice = random.nextInt(3);
    }

    public String getComputerChoice() {
        return OPTIONS[computerChoice].toUpperCase();
    }

    public String getPlayerChoice() {
        return OPTIONS[playerChoice].toUpperCase();
    }

    public String[] getOptions() {
        return OPTIONS;
    }

    public String getResultMessage() {
        String text = "Tú seleccionaste: " + getPlayerChoice();
        text += "\nLa computadora: " + getComputerChoice() + "\n\n";

        int result = getResult();

        if (result == 0) text += "\n\nEs un empate";
        else text += result == -1 ? "PERDISTE" : "GANASTE";

        return text;
    }

    public int getResult() {
        if (this.computerChoice == this.playerChoice) return 0;

        int nextOption = this.playerChoice == OPTIONS.length - 1 ? 0 : this.playerChoice + 1;

        return this.computerChoice == nextOption ? -1 : 1;
    }

    public void setPlayerChoice(Object choice) {
        int index = -1;
        String option = choice.toString().toUpperCase();

        for (int i = 0; i < OPTIONS.length; i++) {
            if (OPTIONS[i].equalsIgnoreCase(option)) index = i;
        }

        this.playerChoice = index;
    }
}
