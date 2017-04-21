package org.antonu.bowling;

import org.antonu.bowling.game.BowlingGame;
import org.antonu.bowling.game.Round;
import org.antonu.bowling.util.Utils;

import java.util.Scanner;

/**
 * Created by kit on 4/20/17.
 */
public class ConsoleBowlingGame {

    public void play() {
        Scanner scanner = new Scanner(System.in);
        BowlingGame game = new BowlingGame();

        while (!game.isFinished()) {
            Round currentRound = game.getCurrentRound();
            System.out.println(String.format("Round %d:", game.getCurrentRoundNumber()));

            while (!currentRound.isFinished()) {
                System.out.println("Enter pins or hit enter for random:");
                String line = "";//scanner.nextLine();
                Integer pins = null;
                try {
                    pins = Integer.parseInt(line);
                } catch (NumberFormatException ignored) {
                }

                int pinsLeft = currentRound.getRemainingPins();
                if (pins == null || pins < 0 || pins > pinsLeft) {
                    pins = Utils.randInt(0, pinsLeft);
                }

                System.out.println(pins);
                game.toss(pins);
                printScoreTable(game);
            }
        }
    }

    private void printScoreTable(BowlingGame game) {
        //game.getCommittedRounds();
        System.out.println("Total score: " + game.getTotalScore());
    }
}
