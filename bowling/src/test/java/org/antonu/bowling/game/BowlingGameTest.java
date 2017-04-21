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
        assertEquals(12, game.getTotalScore());
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

    @Test
    public void testRoundSwitch() throws Exception {
        Round round1 = game.getCurrentRound();
        game.toss(4);
        game.toss(5);
        Round round2 = game.getCurrentRound();
        assertNotEquals(round1, round2);
    }

    @Test
    public void testGameFinish() throws Exception {
        for (int i = 0; i < 12; i++) {
            game.toss(10);
        }
        assertTrue(game.isFinished());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePins() throws Exception {
        game.toss(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPinsOverflow() throws Exception {
        game.toss(7);
        game.toss(7);
    }

    @Test
    public void testSpareRound() throws Exception {
        Round round = game.getCurrentRound();
        game.toss(7);
        game.toss(3);
        assertTrue(round.isSpare());
    }

    @Test
    public void testStrikeRound() throws Exception {
        Round round = game.getCurrentRound();
        game.toss(10);
        assertTrue(round.isStrike());
    }

    @Test
    public void testRound() throws Exception {
        Round round = game.getCurrentRound();
        round.toss(5);
        assertFalse(round.isFinished());
        round.toss(1);
        assertFalse(round.isStrike());
        assertFalse(round.isSpare());
        assertTrue(round.isFinished());
    }

    @Test
    public void testLastSpareNoBonus() throws Exception {
        for (int i = 0; i < 17; i++) {
            game.toss(1);
        }
        game.toss(9);
        game.toss(0);
        game.toss(0);
        assertEquals(26, game.getTotalScore());
    }

    @Test
    public void testLastStrikeNoBonus() throws Exception {
        for (int i = 0; i < 16; i++) {
            game.toss(1);
        }
        game.toss(10);
        game.toss(0);
        game.toss(0);
        assertEquals(26, game.getTotalScore());
    }
}