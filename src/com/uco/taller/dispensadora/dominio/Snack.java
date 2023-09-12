package com.uco.taller.dispensadora.dominio;

public class Snack {
    private static final int CAPACITY = 6;
    private int amount;
    private final int code;
    private final String name;
    private final long price;

    protected Snack(int code, String name, long price) {
        this.amount = CAPACITY;
        this.code = code;
        this.name = name;
        this.price = price;
    }

    protected int getAmount() {
        return amount;
    }

    protected int getCode() {
        return code;
    }

    protected String getName() {
        return name;
    }

    protected long getPrice() {
        return price;
    }

    protected void setAmount(int amount) {
        this.amount = amount;
    }
}
