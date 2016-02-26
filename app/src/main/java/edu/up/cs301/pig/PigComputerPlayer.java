package edu.up.cs301.pig;

import android.drm.DrmStore;

import java.util.Random;

import edu.up.cs301.game.Game;
import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if(this.playerNum == 0)
            return;
        else if (this.playerNum == 1)
        {
            double rand = Math.random();

            if (rand < 0.5)
            {
                PigRollAction pigRollAction = new PigRollAction(this);
                game.sendAction(pigRollAction);
            }
            else
            {
                PigHoldAction pigHoldAction = new PigHoldAction(this);
                game.sendAction(pigHoldAction);
            }
        }
    }//receiveInfo

}
