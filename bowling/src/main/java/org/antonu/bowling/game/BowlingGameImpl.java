package org.antonu.bowling.game;

import lombok.Getter;
import org.antonu.bowling.game.factory.RoundFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by kit on 4/20/17.
 */
public class BowlingGameImpl implements BowlingGame, Serializable {
    private final RoundFactory roundFactory = RoundFactory.INSTANCE;

    @Getter
    private List<Round> rounds;
    private List<Round> bonusRounds;
    @Getter
    private Round currentRound;

    public BowlingGameImpl() {
        rounds = new ArrayList<>(MAX_ROUNDS);
        bonusRounds = new ArrayList<>();
        currentRound = roundFactory.createRound(false);
        rounds.add(currentRound);
    }

    public void toss(int pins) {
        if (isFinished()) {
            throw new IllegalStateException("Game is over!");
        }

        currentRound.toss(pins);
        updateScore(pins);

        if (currentRound.isFinished()) {
            if (rounds.size() < MAX_ROUNDS) {
                currentRound = roundFactory
                        .createRound(rounds.size() == (MAX_ROUNDS - 1));
                rounds.add(currentRound);
            }
        }
    }

    private void updateScore(int pins) {
        for (Iterator<Round> iterator = bonusRounds.iterator(); iterator.hasNext(); ) {
            Round bonusRound = iterator.next();
            bonusRound.addBonus(pins);
            if (bonusRound.getBonusTossLeft() == 0) {
                iterator.remove();
            }
        }
        if (currentRound.isLastRound()) {
            return;
        }
        if (currentRound.isStrike()) {
            currentRound.setBonusTossLeft(2);
            bonusRounds.add(currentRound);
        }
        if (currentRound.isSpare()) {
            currentRound.setBonusTossLeft(1);
            bonusRounds.add(currentRound);
        }
    }

    public boolean isFinished() {
        return rounds.size() == MAX_ROUNDS &&
                rounds.get(rounds.size() - 1).isFinished();
    }

    public Integer getCurrentRoundNumber() {
        return rounds.size() + 1;
    }

    public int getTotalScore() {
        return getTotalScore(rounds.size());
    }

    public int getTotalScore(int roundCount) {
        List<Round> roundList = rounds.size() == roundCount ? rounds : rounds.subList(0, roundCount);
        return roundList.stream()
                .filter(Round::isFinished)
                .mapToInt(Round::getScore)
                .sum();
    }
}
