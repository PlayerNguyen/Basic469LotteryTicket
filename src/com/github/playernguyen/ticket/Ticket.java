package com.github.playernguyen.ticket;

import com.github.playernguyen.helper.MathHelper;

import java.util.Arrays;

public abstract class Ticket {

    public static final int LENGTH_SIZE = 6;
    public static final int MINIMAL_VALUE = 1;
    public static final int MAXIMAL_VALUE = 49;
    public static final double FEE = 4.0D;

    // Immutable var
    private int[] numbers = new int[LENGTH_SIZE];

    public Ticket(int[] numbers) {
        this.numbers = numbers;
    }

    public Ticket() {
    }

    public void roll() {
        this.numbers = MathHelper.generateRandomList(LENGTH_SIZE, MINIMAL_VALUE, MAXIMAL_VALUE);
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * A number array
     *
     * @return a list of generated number
     */
    public int[] getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}
