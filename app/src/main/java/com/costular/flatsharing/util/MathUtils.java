package com.costular.flatsharing.util;

import java.util.Random;

/**
 * Created by diego on 17/12/15.
 */
public class MathUtils {

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
