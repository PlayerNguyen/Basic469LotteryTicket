package com.github.playernguyen.game;

import com.github.playernguyen.player.SimplePlayer;
import com.github.playernguyen.ticket.PlayerTicket;
import com.github.playernguyen.ticket.Ticket;

import java.util.ArrayList;

public class MultipleGame extends Game {

    private final int turn;
    // Push up access without random access
//    private final

    public MultipleGame(SimplePlayer player, int turn) {
        super(player);
        // Set a new turn
        this.turn = turn;
    }

    public void onExecute() {
        int wonGame = 0;
        int specialWonGame = 0;
        double firstBalance = this.getPlayer().getBalance();
        double afterBalance = this.getPlayer().getBalance();
        double ticketCost = 0;
        for (int i = 0; i < turn; i++) {
            // Generate new player ticket and roll random value
            PlayerTicket playerTicket = new PlayerTicket();
            playerTicket.roll();
            // Set ticket cost
            ticketCost += Ticket.FEE;
            this.getPlayer().take(Ticket.FEE);
            // Refresh to the current value
            this.getEngine().refresh(playerTicket);

            // Matched pairs
            int matchedPairs = this.getEngine().getMatchedPairs();
            if (matchedPairs > 1) {
                if (matchedPairs == 6) {
                    specialWonGame++;
                }
                wonGame++;
            }

            // Set money to player
            double additionalBalance = this.getAwards().get(matchedPairs);
            this.getPlayer().add(additionalBalance);
            afterBalance += additionalBalance;

        }

        System.out.printf("Number of game won any money: %d\n", wonGame);
        System.out.printf("Number of game matched 6 pairs: %d\n", specialWonGame);
        System.out.printf("Total money won: $%.0f\n", (afterBalance - firstBalance));
        System.out.printf("Total ticket cost: $%.0f$\n", ticketCost);
        System.out.printf("Profit/Loss: $%.0f$\n", (afterBalance - firstBalance) - ticketCost );

    }

}
