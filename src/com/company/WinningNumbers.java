package com.company;

import java.util.Arrays;

public class WinningNumbers extends NumberGenerator{

    public int[] numbers;

    public WinningNumbers() {
        this.numbers = Arrays.stream(generateNums()).sorted().toArray();
    }
}
