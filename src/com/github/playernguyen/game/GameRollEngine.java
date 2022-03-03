package com.github.playernguyen.game;

import com.github.playernguyen.ticket.BetTicket;
import com.github.playernguyen.ticket.PlayerTicket;
import com.github.playernguyen.ticket.Ticket;

public class GameRollEngine {

    private final BetTicket betTicket = new BetTicket();
    private PlayerTicket playerTicket = new PlayerTicket();
    private int matchedPairs = 0;

    public void refresh(Ticket playerTicket) {
        // Set matched pairs to 0
        this.matchedPairs = 0;

        // Generate a new bet numbers
        this.betTicket.roll();
//        System.out.println("-" +Arrays.toString(this.betTicket.getNumbers()));

        // Set a number from ticket
//        System.out.println("+" + Arrays.toString(playerTicket.getNumbers()));
        this.playerTicket.setNumbers(playerTicket.getNumbers());

        // Then find how many matched pairs
        for (int i = 0; i < Ticket.LENGTH_SIZE; i++) {
            if (betTicket.getNumbers()[i] == playerTicket.getNumbers()[i]) {
                this.matchedPairs ++;
            }
        }
//        System.out.println("Matched pairs: " + this.matchedPairs);
    }

    public int getMatchedPairs() {
        return matchedPairs;
    }

    public void setPlayerTicket(PlayerTicket playerTicket) {
        this.playerTicket = playerTicket;
    }

    public BetTicket getBetTicket() {
        return betTicket;
    }

    public PlayerTicket getPlayerTicket() {
        return playerTicket;
    }
}
