package com.example.saketp.maps;

public class Player {
    private String name;
    private int wins;
    private int losses;
    private boolean current;


    public Player(String name) {
        this.name = name;
        wins = 0;
        losses = 0;
        current = false;
    }

    public String getName() {
        return name;
    }

    public void activate(){
        current = true;
    }

    public void deactivate() {
        current = false;
    }

    public boolean getStatus() {
        return current;
    }


    private int getWins() {
        return wins;
    }

    private int getLoses() {
        return losses;
    }

    private void win() {
        this.wins += 1;
    }

    private void lose() {
        this.losses += 1;
    }
}