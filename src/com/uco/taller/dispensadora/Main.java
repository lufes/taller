package com.uco.taller.dispensadora;

import com.uco.taller.dispensadora.dominio.Dispensadora;

public class Main {

    public static void main(String[] args) {
        Dispensadora dispensadora = new Dispensadora();

        // Agregar un snack a la maquina dispensadora
        addTestSnacks(dispensadora);

        // Sacar una unidad de un snack determinado dado su código.
        // En este caso, removemos 3 chocolatinas
        removeSnackByCode(dispensadora);

        // Obtener el nombre y la cantidad de unidades que quedan de todos los
        // snacks en el dispensador - Todos deben tener 6 unidades, excepto
        // chocolatina que tiene 3
        dispensadora.getInventory();

        // Sacar una unidad de un snack determinado dado su nombre.
        // remover otras 3 chocolatinas, pero ahora usando el nombre
        removeSnackByName(dispensadora);

        // mostrar que las chocolatinas se acabaron
        dispensadora.sellSnack("chocolatina");

        // Vender un código equivocado
        dispensadora.sellSnack(12532);

        // Aumentar la cantidad de unidades a un snack determinado dado su código
        dispensadora.restock(9);

        // Aumentar la cantidad de unidades a un snack determinado dado su nombre
        dispensadora.restock("chocolatina");

        // En este punto deberíamos tener dos chocolatinas
        dispensadora.getInventory(9);

        // Aumentar la cantidad si ya hay 6 unidades
        dispensadora.restock(8);

        // Quitar un snack de la maquina dispensadora.
        dispensadora.removeSnack(8);

        // Mostrar otra vez el inventario y verificar que el #8 ya no existe
        dispensadora.getInventory();

        // Obtener la cantidad de unidades que quedan de un snack determinado
        dispensadora.getInventory(3);

        // Obtener la cantidad de unidades que quedan de un snack inexistente
        dispensadora.getInventory(8);

        // Obtener los nombres de los snacks que se encuentran agotados. No hay agotados
        dispensadora.getSoldOut();

        // Vender algunos snacks hasta agotarlos
        dispensadora.sellSnack(9);
        dispensadora.sellSnack(9);
        dispensadora.sellSnack(4);
        dispensadora.sellSnack(4);
        dispensadora.sellSnack(4);
        dispensadora.sellSnack(4);
        dispensadora.sellSnack(4);
        dispensadora.sellSnack(4);

        // Obtener los nombres de los snacks que se encuentran agotados. Ya hay agotados
        dispensadora.getSoldOut();

        // Obtener la lista de snacks ordenada por su valor de mayor a menor
        dispensadora.orderByPrice();

        // Vender algunos snacks antes de ordenar por cantidad
        dispensadora.sellSnack(3);
        dispensadora.sellSnack(3);
        dispensadora.sellSnack(7);
        dispensadora.sellSnack(10);
        dispensadora.sellSnack(11);
        dispensadora.sellSnack(11);
        dispensadora.sellSnack(11);
        dispensadora.sellSnack(14);
        dispensadora.sellSnack(14);
        dispensadora.sellSnack(14);
        dispensadora.sellSnack(14);

        // Obtener la lista de snacks ordenada por su cantidad de menor a mayor
        dispensadora.orderByAmount();
    }

    private static void addTestSnacks (Dispensadora dispensadora) {
        // añadir 6 snacks
        dispensadora.addSnack(3, "aritos de cebolla", 2000);
        dispensadora.addSnack(4, "papitas", 2100);
        dispensadora.addSnack(5, "doritos", 2500);
        dispensadora.addSnack(6, "bonbonbum", 1000);
        dispensadora.addSnack(7, "de todito", 2800);
        dispensadora.addSnack(8, "chocorramo", 1900);

        // añadir un snack que ya existe
        dispensadora.addSnack(9, "doritos", 2500);

        // añadir otros 6 snacks para alcanzar el máximo
        dispensadora.addSnack(9, "chocolatina", 600);
        dispensadora.addSnack(10, "festival", 800);
        dispensadora.addSnack(11, "nucita", 1200);
        dispensadora.addSnack(12, "cocosette", 700);
        dispensadora.addSnack(13, "bocadillo", 500);
        dispensadora.addSnack(14, "barrilete", 400);

        // añadir un snack cuando el máximo se alcanzó
        dispensadora.addSnack(15, "quipitos", 900);
    }

    private static void removeSnackByCode (Dispensadora dispensadora) {
        // sacar chocolatina
        dispensadora.sellSnack(9);
        dispensadora.sellSnack(9);
        dispensadora.sellSnack(9);
    }

    private static void removeSnackByName (Dispensadora dispensadora) {
        // sacar chocolatina
        dispensadora.sellSnack("chocolatina");
        dispensadora.sellSnack("chocolatina");
        dispensadora.sellSnack("chocolatina");
    }
}
