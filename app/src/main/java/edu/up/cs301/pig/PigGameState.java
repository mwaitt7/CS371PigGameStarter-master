package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by waitt18 on 2/25/2016.
 */
public class PigGameState extends GameState {
    private int turnID;
    private int player0Score;
    private int player1Score;
    private int runningTotal;
    private int dieValue;


    public PigGameState() {
        turnID = 0;
        player0Score = 0;
        player1Score = 0;
        runningTotal = 0;
        dieValue = 1;
    }

    public PigGameState(PigGameState oldPigGame) {

        turnID = oldPigGame.getTurnID();
        dieValue = oldPigGame.getDieValue();
        player0Score = oldPigGame.getPlayer0Score();
        player1Score = oldPigGame.getPlayer1Score();
        runningTotal = oldPigGame.getRunningTotal();
    }

    public int getTurnID() {
        return turnID;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public int getDieValue() {
        return dieValue;
    }

    public void setPlayer0Score(int newPlayer0Score) {
        this.player0Score = newPlayer0Score;
    }
    public void setPlayer1Score(int newPlayer1Score) {
        this.player1Score = newPlayer1Score;
    }
    public void setRunningTotal(int newRunningTotal) {
        this.runningTotal = newRunningTotal;
    }
    public void setDieValue(int newDieValue) {
        this.dieValue = newDieValue;
    }
    public void setTurnID(int newTurnID) {
        this.turnID = newTurnID;
    }
}
