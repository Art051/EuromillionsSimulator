package com.company.generators;

import java.util.*;
import java.util.stream.IntStream;


public class NumberGenerator {

    //https://www.national-lottery.co.uk/games/euromillions/about-euromillions
    // regular nums limit is 50 - lucky star limit is 12

    private final int standardNums = 5;
    private final int standardMax = 50;
    private final int luckyStarNums = 2;
    private final int luckyStarMax = 12;

    Random random = new Random();

    public int[] generateNums() {
        int[] standardNumsGenerated = random.ints(1, standardMax + 1).distinct().limit(standardNums).sorted().toArray();
        int[] luckyStarNumsGenerated = random.ints(1, luckyStarMax + 1).distinct().limit(luckyStarNums).sorted().toArray();

        return IntStream.concat(Arrays.stream(standardNumsGenerated), Arrays.stream(luckyStarNumsGenerated)).toArray();

    }
}