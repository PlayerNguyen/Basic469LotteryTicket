package com.github.playernguyen;

import com.github.playernguyen.game.MultipleGame;
import com.github.playernguyen.game.Game;
import com.github.playernguyen.game.SingleGame;
import com.github.playernguyen.player.SimplePlayer;

import java.util.Scanner;

public class Main {

    private static final SimplePlayer player = new SimplePlayer();

    public static void main(String[] args) {
        Game game;
        System.out.printf("You current balance %.2f $\r\n", player.getBalance());
        try {
            Scanner scanner = new Scanner(System.in);

            // Let player decide how many turn they want to player
            int turn;
            System.out.println("How many game you want to play?");
            turn = scanner.nextInt();

            game = (turn == 1)
                    ? new SingleGame(player)
                    : new MultipleGame(player, turn);
            game.onExecute();

            System.out.printf("Player balance %.2f", player.getBalance());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
