package org.antonu.bowling.game.factory;

import org.antonu.bowling.game.BowlingGame;
import org.antonu.bowling.game.BowlingGameFactory;
import org.antonu.bowling.game.BowlingGameImpl;

/**
 * Created by kit on 5/11/17.
 */
public class StandardBowlingGameFactory implements BowlingGameFactory {

    @Override
    public BowlingGame createBowlingGame() {
        return new BowlingGameImpl();
    }
}
