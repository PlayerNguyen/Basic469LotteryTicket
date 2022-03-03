package com.github.playernguyen.player;

public class SimplePlayer implements Player {

    private double balance = 0;

    public SimplePlayer(double balance) {
        this.balance = balance;
    }

    public SimplePlayer() {
    }

    public void take(double amount) {
        this.balance -= amount;
    }

    public void add(double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
