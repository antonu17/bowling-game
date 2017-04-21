package org.antonu.bowling.game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kit on 4/21/17.
 */
public class BowlingGameTest {

    BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    @Test
    public void testPerfectGame() throws Exception {
        for (int i = 0; i < 12; i++) {
            game.toss(10);
        }
        assertEquals(300, game.getTotalScore());
    }

    @Test
    public void testAlmostPerfectGame() throws Exception {
        for (int i = 0; i < 11; i++) {
            game.toss(10);
        }
        game.toss(9);
        assertEquals(299, game.getTotalScore());
    }

    @Test
    public void testAllOneGame() throws Exception {
        for (int i = 0; i < 20; i++) {
            game.toss(1);
        }
        assertEquals(20, game.getTotalScore());
    }

    @Test
    public void testAllFiveTossGame() throws Exception {
        for (int i = 0; i < 21; i++) {
            game.toss(5);
        }
        assertEquals(150, game.getTotalScore());
    }

    @Test
    public void testSingleSpare() throws Exception {
        game.toss(6);
        game.toss(4);
        game.toss(2);
        assertEquals(12, game.getCommittedRounds().get(0).getScore());
    }

    @Test
    public void testRegularGame() throws Exception {
        game.toss(10);
        game.toss(1);
        game.toss(5);
        game.toss(2);
        game.toss(4);
        game.toss(7);
        game.toss(2);
        game.toss(6);
        game.toss(4);
        game.toss(3);
        game.toss(7);
        game.toss(8);
        game.toss(0);
        game.toss(0);
        game.toss(1);
        game.toss(9);
        game.toss(1);
        game.toss(7);
        game.toss(3);
        game.toss(2);
        int score = game.getTotalScore();
        assertEquals(106, score);
    }
}