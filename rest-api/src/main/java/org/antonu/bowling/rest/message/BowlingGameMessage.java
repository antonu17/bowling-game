package org.antonu.bowling.rest.message;

import lombok.Getter;
import lombok.Setter;
import org.antonu.bowling.game.BowlingGame;

/**
 * Created by kit on 4/24/17.
 */

public class BowlingGameMessage {
    @Getter
    @Setter
    private String gameId;
    @Getter
    @Setter
    private boolean finished;
    @Getter
    @Setter
    private int currentRound;
    @Getter
    @Setter
    private int totalScore;

    public BowlingGameMessage(BowlingGame game, String gameId) {
        this.gameId = gameId;
        this.finished = game.isFinished();
        this.currentRound = game.getRounds().indexOf(game.getCurrentRound()) + 1;
        this.totalScore = game.getTotalScore();
    }
}
