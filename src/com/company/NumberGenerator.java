package com.company;

import java.util.Random;


public class NumberGenerator {

    //https://www.national-lottery.co.uk/games/euromillions/about-euromillions
    // regular nums limit is 50 - lucky star limit is 12

    Random random = new Random();

    public int[] generateNums() {

        int[] numberSelection = new int[7];

        int standardNums = 5;
        int luckyStarNums = 2;
        for (int i = 0; i < (standardNums + luckyStarNums); i++) {
            int previousSelection = 0;
            int selection;
            int standardMax = 50;
            if (i < standardNums) {
                selection = random.nextInt(1, standardMax + 1);
            }
            else {
                int luckyStarMax = 12;
                selection = random.nextInt(1, luckyStarMax + 1);
            }
            while(selection == previousSelection){
                selection = random.nextInt(1, standardMax + 1);
            }
            numberSelection[i] = selection;
        }
        return numberSelection;
    }
}