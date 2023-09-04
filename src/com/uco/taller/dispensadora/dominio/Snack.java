package com.uco.taller.dispensadora.dominio;

public class Snack {
    private int amount;
    private int code;
    private String name;
    private long price;

    protected Snack(int code, String name, long price) {
        this.amount = 6;
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
