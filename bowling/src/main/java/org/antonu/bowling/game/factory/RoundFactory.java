package org.antonu.bowling.game.factory;

import org.antonu.bowling.game.Round;

/**
 * RoundFactory implemented as singleton.
 * Joshua Bloch recommends single-element enum type
 * as the best way to implement a singleton.
 *
 * Created by kit on 4/20/17.
 */
public enum RoundFactory {

    /**
     * RoundFactory instance
     */
    INSTANCE;

    public Round createRound(boolean lastRound) {
        return new Round(lastRound);
    }
}
