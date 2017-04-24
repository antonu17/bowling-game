package org.antonu.bowling;

import org.antonu.bowling.game.BowlingGame;
import org.antonu.bowling.game.BowlingGameImpl;
import org.antonu.bowling.game.Round;
import org.antonu.bowling.util.Utils;

import java.util.Scanner;

import static org.antonu.bowling.game.BowlingGame.MAX_ROUNDS;

/**
 * Created by kit on 4/20/17.
 */
public class ConsoleBowlingGame {

    public static final String STRIKE = "X";
    public static final String SPARE = "/";
    public static final String ZERO = "-";

    public void play() {
        Scanner scanner = new Scanner(System.in);
        BowlingGame game = new BowlingGameImpl();

        while (!game.isFinished()) {
            System.out.print("Enter pins or hit enter for random: ");

            String line = scanner.nextLine();
            Integer pins = null;
            try {
                pins = Integer.parseInt(line);
            } catch (NumberFormatException ignored) {
            }

            int pinsLeft = game.getCurrentRound().getRemainingPins();
            if (pins == null || pins < 0 || pins > pinsLeft) {
                pins = Utils.randInt(0, pinsLeft);
            }
            game.toss(pins);
            printScoreTable(game);
        }
    }

    /*
    Score table sample
 -------------------------------------------------------------------
| - - |   X | 5 / | 1 1 | - / | 1 1 | 3 / | 1 1 | 2 - | 9 / X |     |
|   0 |     |     |     |     |     |     |     |     |       | 300 |
 -------------------------------------------------------------------
     */
    private void printScoreTable(BowlingGame game) {
        StringBuilder pinsSB = new StringBuilder();
        StringBuilder scoreSB = new StringBuilder();
        pinsSB.append("|");
        scoreSB.append("|");
        for (int i = 0; i < MAX_ROUNDS; i++) {
            if (game.getRounds().size() < i + 1) {
                if (i + 1 == MAX_ROUNDS) {
                    pinsSB.append("       |").append("     |");
                    scoreSB.append("       |").append(String.format(" %3d |", game.getTotalScore()));
                } else {
                    pinsSB.append("     |");
                    scoreSB.append("     |");
                }
                continue;
            }
            Round round = game.getRounds().get(i);
            if (!round.isLastRound()) {
                scoreSB.append(round.isScored() ? String.format(" %3d |", game.getTotalScore(i + 1)) : "     |");

                if (round.isStrike()) {
                    pinsSB.append("   X |");
                    continue;
                }
                if (round.isSpare()) {
                    pinsSB.append(" ")
                            .append(convertPins(round.getBowledPins(0)))
                            .append(" ")
                            .append(SPARE)
                            .append(" |");
                    continue;
                }
                pinsSB.append(" ")
                        .append(convertPins(round.getBowledPins(0)))
                        .append(" ")
                        .append(convertPins(round.getBowledPins(1)))
                        .append(" |");
            } else {
                pinsSB.append(" ")
                        .append(convertPins(round.getBowledPins(0)))
                        .append(" ");
                pinsSB.append(round.isSpare() ? SPARE : convertPins(round.getBowledPins(1)));
                pinsSB.append(" ");
                pinsSB.append(convertPins(round.getBowledPins(2)))
                        .append(" |")
                        .append("     |");

                scoreSB.append(round.isScored() ? String.format("   %3d |", game.getTotalScore(i + 1)) : "       |");
                scoreSB.append(String.format(" %3d |", game.getTotalScore()));
            }
        }
        System.out.println(" ------------------------------------------------------------------- ");
        System.out.println(pinsSB.toString());
        System.out.println(scoreSB.toString());
        System.out.println(" ------------------------------------------------------------------- ");
    }

    private String convertPins(Integer pins) {
        if (pins == null) {
            return " ";
        }
        if (pins.equals(0)) {
            return ZERO;
        }
        if (pins.equals(10)) {
            return STRIKE;
        }
        return pins.toString();
    }

}
