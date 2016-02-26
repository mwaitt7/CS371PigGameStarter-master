package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState newPigGameState;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        newPigGameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(playerIdx == newPigGameState.getTurnID()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof PigHoldAction) {
            if (newPigGameState.getTurnID() == 0) {
                newPigGameState.setPlayer0Score(newPigGameState.getRunningTotal() + newPigGameState.getPlayer0Score());
                newPigGameState.setRunningTotal(0);
                if (this.playerNames.length == 2) {
                    newPigGameState.setTurnID(1);
                }
            }

            else if (newPigGameState.getTurnID() == 1) {
                newPigGameState.setPlayer1Score(newPigGameState.getRunningTotal() + newPigGameState.getPlayer1Score());
                newPigGameState.setRunningTotal(0);
                if (this.playerNames.length == 2) {
                    newPigGameState.setTurnID(0);
                }
            }
            return true;
        }
        else if (action instanceof PigRollAction) {
            if (newPigGameState.getTurnID() == 0) {
                Random rand = new Random();
                int randomNum = rand.nextInt((6) + 1);
                newPigGameState.setDieValue(randomNum);
                if (newPigGameState.getDieValue()>1) {
                    newPigGameState.setRunningTotal(newPigGameState.getDieValue()+newPigGameState.getRunningTotal());
                }
                else if (newPigGameState.getDieValue() == 1) {
                    newPigGameState.setRunningTotal(0);
                    if (this.playerNames.length == 2) {
                        newPigGameState.setTurnID(1);
                    }
                }
            }
            else if (newPigGameState.getTurnID() == 1) {
                Random rand = new Random();
                int randomNum = rand.nextInt((6) + 1);
                newPigGameState.setDieValue(randomNum);
                if (newPigGameState.getDieValue()>1) {
                    newPigGameState.setRunningTotal(newPigGameState.getDieValue()+newPigGameState.getRunningTotal());
                }
                else if (newPigGameState.getDieValue() == 1) {
                    newPigGameState.setRunningTotal(0);
                    if (this.playerNames.length == 2) {
                        newPigGameState.setTurnID(0);
                    }
                }
            }
            return true;
        }
        else {
            return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState newPigGameState2 = new PigGameState(newPigGameState);
        p.sendInfo(newPigGameState2);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (newPigGameState.getPlayer0Score() >= 50) {
            return "Game over! " +playerNames[0]+" wins!! Their score was: "+newPigGameState.getPlayer0Score();
        }
        else if (newPigGameState.getPlayer1Score()>= 50) {
            return "Game over! " +playerNames[1]+" wins!! Their score was: "+newPigGameState.getPlayer1Score();
        }
        else
        {
            return null;
        }
    }

}// class PigLocalGame
