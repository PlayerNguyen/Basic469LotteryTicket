package com.github.playernguyen.game;

import com.github.playernguyen.ticket.PlayerTicket;
import com.github.playernguyen.ticket.Ticket;
import com.github.playernguyen.helper.MathHelper;
import com.github.playernguyen.player.SimplePlayer;

import java.util.Scanner;

public class SingleGame extends Game {
    public SingleGame(SimplePlayer player) {
        super(player);
    }

    @Override
    public void onExecute() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Do you want to pick your own ticket numbers [Y/n]");

            PlayerTicket playerTicket = new PlayerTicket();
            int[] bet = new int[Ticket.LENGTH_SIZE];

            if (scanner.next().equalsIgnoreCase("y")) {

                // Enter the number list
                System.out.println("Enter 6 numbers of your ticket:");
                for (int i = 0; i < Ticket.LENGTH_SIZE; i++) {
                    int inputValue = scanner.nextInt();
                    while (inputValue <= 0 || inputValue > 50) {
                        System.out.println("Value must be lower than 50 and greater than 0");
                        inputValue = scanner.nextInt();

                    }
                    bet[i] = inputValue;
                }
            } else {
                // Generate a random value from [1, 49] then put to the bet
                for (int i = 0; i < 6; i++) {
                    bet[i] = (int) MathHelper.boundRandom(1, 49);
                }
            }

            // Set player ticket
            playerTicket.setNumbers(bet);

            this.getEngine().refresh(playerTicket);

            // Ticket fee
            this.getPlayer().take(Ticket.FEE);

            // The Bet ticket
            System.out.print("Bet ticket (-) Your ticket (+) \n\r");
            // The winning ticket is:
            this.printBetTicket();
            this.printPlayerTicket();

            int matchedPairs = this.getEngine().getMatchedPairs();
            System.out.printf("Your ticket has matched %d(s)\r\n", matchedPairs);

            // Print out the winning cost and put to player balance
            this.getPlayer().add(matchedPairs);
            System.out.printf("You have won %.2f $ \r\n", this.getAwards().get(matchedPairs));

        }
    }

    public void printBetTicket() {
        System.out.println(" (-) ");
        for (int value : this.getCurrentPlayerTicket().getNumbers()) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    public void printPlayerTicket() {
        System.out.println(" (+) ");
        for (int value : this.getCurrentBetTicket().getNumbers()) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}
