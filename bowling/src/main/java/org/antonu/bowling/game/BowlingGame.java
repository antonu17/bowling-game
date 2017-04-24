package org.antonu.bowling.game;

import java.util.List;

/**
 * Created by kit on 4/24/17.
 */
public interface BowlingGame {
    int MAX_PINS = 10;
    int MAX_ROUNDS = 10;

    String getGameId();

    void toss(int pins);

    int getTotalScore();

    int getTotalScore(int round);

    Round getCurrentRound();

    List<Round> getRounds();

    boolean isFinished();
}
