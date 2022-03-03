package com.github.playernguyen.game;

import com.github.playernguyen.ticket.BetTicket;
import com.github.playernguyen.ticket.PlayerTicket;
import com.github.playernguyen.player.SimplePlayer;

import java.util.HashMap;

public abstract class Game {

    private final SimplePlayer player;
    private final GameRollEngine engine = new GameRollEngine();
    private final HashMap<Integer, Double> awards = new HashMap<>();

    public Game(SimplePlayer player) {
        // Init player
        this.player = player;
        // Generate awards, change awards price here
        awards.put(0, 0D);
        awards.put(1, 10D);
        awards.put(2, 10D);
        awards.put(3, 100D);
        awards.put(4, 1000D);
        awards.put(5, 5e4D);
        awards.put(6, 5e6D);
    }

    public abstract void onExecute();

    public GameRollEngine getEngine() {
        return engine;
    }

    public HashMap<Integer, Double> getAwards() {
        return awards;
    }

    public SimplePlayer getPlayer() {
        return player;
    }

    public BetTicket getCurrentBetTicket() {
        return this.engine.getBetTicket();
    }

    public PlayerTicket getCurrentPlayerTicket() {
        return this.engine.getPlayerTicket();
    }
}
