package com.github.playernguyen.ticket;

public class BetTicket extends Ticket {

    @Override
    public void setNumbers(int[] numbers) {
        throw new IllegalStateException("Cannot set a number to bet ticket");
    }

}
