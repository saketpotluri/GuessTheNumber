package com.example.saketp.maps;

import java.util.Random;

/**
 * Created by saketp on 9/9/2015.
 */
public class Game {
    private int guesses;
    private int randNum;

    public int getMinGuess() {
        return minGuess;
    }

    public void setMinGuess(int minGuess) {
        this.minGuess = minGuess;
    }

    public int getMaxGuess() {
        return maxGuess;
    }

    public void setMaxGuess(int maxGuess) {
        this.maxGuess = maxGuess;
    }

    private int minGuess;
    private int maxGuess;
    private Player currentPlayer;

    public Game() {
        reset();
    }

    public void setCurrentPlayer(Player p) {
        currentPlayer = p;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void reset() {
        guesses = 0;
        Random rand = new Random();
        randNum =  (rand.nextInt(100)) + 1; //random number between 1 and 100
    }

    public int getRandNum() {
        return randNum;
    }

    public int getGuesses() {
        return guesses;
    }

    public void incrementGuess() {
        guesses += 1;
    }

}
