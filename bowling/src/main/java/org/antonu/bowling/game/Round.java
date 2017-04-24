package org.antonu.bowling.game;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static org.antonu.bowling.game.BowlingGame.MAX_PINS;

/**
 * Created by kit on 4/20/17.
 */
public class Round {

    private List<Integer> bowledPinList = new ArrayList<>();
    private final boolean lastRound;
    private int bonusPins;
    @Getter
    @Setter(AccessLevel.PACKAGE)
    private int bonusTossLeft;

    public Round(boolean lastRound) {
        this.lastRound = lastRound;
    }

    public void toss(Integer pins) {
        if (pins < 0) {
            throw new IllegalArgumentException("Negative pins");
        }
        int remainingPins = getRemainingPins();
        if (pins > remainingPins) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected max %d pins, but was %d",
                            MAX_PINS - remainingPins,
                            pins
                    )
            );
        }
        bowledPinList.add(pins);
    }

    /**
     * @return sum of bowled pins
     */
    public int getBowledPins() {
        return bowledPinList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public Integer getBowledPins(int toss) {
        if (bowledPinList.size() < toss + 1) {
            return null;
        }
        return bowledPinList.get(toss);
    }

    /**
     * @return remaining pins
     */
    public int getRemainingPins() {
        return (lastRound && (isStrike() || isSpare())) ? MAX_PINS : MAX_PINS - getBowledPins();
    }

    /**
     * @return strike achieved
     */
    public boolean isStrike() {
        return bowledPinList.size() > 0 && bowledPinList.get(0).equals(10);
    }

    /**
     * @return spare achieved
     */
    public boolean isSpare() {
        return bowledPinList.size() > 1 &&
                bowledPinList.get(0) < 10 &&
                bowledPinList.stream().limit(2).mapToInt(Integer::intValue).sum() == 10;
    }

    public boolean isLastRound() {
        return lastRound;
    }

    public boolean isFinished() {
        if (lastRound) {
            return bowledPinList.size() == 3 ||
                    (bowledPinList.size() == 2 && !isSpare() && getBowledPins(1) != 10);
        } else {
            return bowledPinList.size() == 2 || isStrike();
        }
    }

    public boolean isScored() {
        return isFinished() && bonusTossLeft == 0;
    }

    public int getScore() {
        return bonusTossLeft == 0 ? getBowledPins() + bonusPins : 0;
    }

    void addBonus(int bonus) {
        if (bonusTossLeft == 0) {
            throw new IllegalStateException("Round already scored");
        }
        bonusPins += bonus;
        bonusTossLeft--;
    }
}
