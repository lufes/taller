package com.uco.taller.dispensadora.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dispensadora {
    private static final int TOTAL_SLOTS = 12;
    private final List<Snack> snacks;

    public Dispensadora() {
        this.snacks = new ArrayList<>();
    }

    public boolean addSnack (int code, String name, long price) {
        Snack currentSnack = this.findSnack(name);
        String msg = "Se añadió correctamente el snack: " + name;
        boolean wasAdded = false;

        if (currentSnack == null && this.snacks.size() < TOTAL_SLOTS) {
            Snack snack = new Snack(code, name, price);
            this.snacks.add(snack);
            wasAdded = true;
        } else {
            msg = currentSnack != null ? "snack repetido: " + name : "ya no caben más snacks en la máquina";
        }

        System.out.println(msg);
        return wasAdded;
    }

    private Snack findSnack (String name) {
        return this.snacks
                .stream()
                .filter(snack -> snack.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private Snack findSnack (int code) {
        return this.snacks
                .stream()
                .filter(snack -> snack.getCode() == code)
                .findFirst()
                .orElse(null);
    }

    public List<Snack> getInventory () {
        System.out.println("\nsnack: \tcantidad");
        this.snacks.forEach(this::printSnack);
        return this.snacks;
    }

    public void getInventory (int code) {
        Snack snack = this.findSnack(code);

        System.out.println("\nsnack: \t\tcantidad");
        if (snack == null) System.out.println("Ese snack no existe: " + code);
        else this.printSnack(snack);
    }

    public List<Snack> getSoldOut () {
        List<Snack> list = this.snacks.stream().filter(snack -> snack.getAmount() == 0).toList();

        System.out.println("\nSnacks agotados:");

        if (!list.isEmpty()) list.forEach(this::printSnack);
        else System.out.println("Ninguno");

        return list;
    }

    public List<Snack> orderByAmount () {
        Comparator<Snack> priceComparator = Comparator.comparing(Snack::getAmount);

        System.out.println("\nLista ordenada por cantidad de menor a mayor");

        this.snacks.sort(priceComparator);
        this.snacks.forEach(this::printSnack);

        return this.snacks;
    }

    public List<Snack> orderByPrice () {
        Comparator<Snack> priceComparator = Comparator.comparing(Snack::getPrice);

        System.out.println("\nLista ordenada por precio de mayor a menor");

        this.snacks.sort(priceComparator);
        Collections.reverse(this.snacks);

        this.snacks.forEach(this::printSnack);

        return this.snacks;
    }

    private void printSnack (Snack snack) {
        System.out.println(snack.getCode() + " - " + snack.getName() + " $" + snack.getPrice() + ": \t " + snack.getAmount());
    }

    public boolean removeSnack (int code) {
        Snack snack = this.findSnack(code);
        boolean wasRemoved = false;

        if (snack == null) System.out.println("Ese snack no existe: " + code);
        else {
            this.snacks.remove(snack);
            wasRemoved = true;
        }

        return wasRemoved;
    }

    public boolean sellSnack(int code) {
        Snack snack = this.findSnack(code);
        return this._sellSnack(snack);
    }

    public boolean sellSnack(String name) {
        Snack snack = this.findSnack(name);
        return this._sellSnack(snack);
    }

    private boolean _sellSnack(Snack snack) {
        if (snack == null) {
            System.out.println("Ese snack no existe");
            return false;
        }

        boolean wasSold = false;
        int amount = snack.getAmount();

        if (amount == 0) System.out.println("Ese snack ya se acabó: " + snack.getName());
        else {
            amount--;
            snack.setAmount(amount);
            wasSold = true;
        }

        return wasSold;
    }

    public boolean restock(int code) {
        Snack snack = this.findSnack(code);
        return this._restock(snack);
    }

    public boolean restock(String name) {
        Snack snack = this.findSnack(name);
        return this._restock(snack);
    }

    private boolean _restock(Snack snack) {
        int currentAmount = snack.getAmount();
        boolean wasRestocked = false;

        if (currentAmount >= 6) System.out.println("Se alcanzó el máximo número de snacks: " + snack.getName());
        else {
            currentAmount++;
            snack.setAmount(currentAmount);
            wasRestocked = true;
        }

        return wasRestocked;
    }
}
