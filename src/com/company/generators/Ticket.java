package com.company.generators;

import java.util.Arrays;

public class Ticket extends NumberGenerator{

    public int[] numbers;

    public Ticket() {
        this.numbers = Arrays.stream(generateNums()).sorted().toArray();
    }
}
