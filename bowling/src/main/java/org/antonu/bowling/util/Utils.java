package org.antonu.bowling.util;

import java.util.Random;

/**
 * Created by kit on 4/20/17.
 */
public class Utils {

    private static Random random = new Random();

    public static int randInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
