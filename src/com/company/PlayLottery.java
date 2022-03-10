package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayLottery {

    WinningNumbers winningNumbers = new WinningNumbers();
    Ticket ticket = new Ticket();

    long countPlays = 0;
    double totalSpend = 0;
    double totalWinnings = 0;
    double ticketPrice = 2.5;

    List<int[]> winningNumsList = new ArrayList<>();
    List<int[]> ticketsList = new ArrayList<>();
    int[] winningNums;
    int[] ticketNums;

    public boolean checkWin(int[] winNums, int[] current){
        return (Arrays.equals(winNums, current));
    }

    public void play() {
        do {
            winningNums = winningNumbers.generateNums();
            ticketNums = ticket.generateNums();
            totalSpend += ticketPrice;
            countPlays++;
            winningNumsList.add(winningNums);
            ticketsList.add(ticketNums);
            totalWinnings += calculatePrize(winningNums, ticketNums);
            checkWin(winningNums, ticketNums);
        }
        while (!(checkWin(winningNums, ticketNums)));
    }

    public double calculatePrize(int[] winNums, int[] current){
        // Jackpot taken from https://www.national-lottery.co.uk/results/euromillions/draw-history/prize-breakdown/1507
        //Table of winning values taken from that page - the percentages etc. obviously would vary from game to game based on the actual amount of tickets with matching numbers,
        // but for the sake of this I've done basic calculations to calculate the spread

        double jackpot = 55075675;
        double prize = 0;
        int regularMatches = 0;
        int luckyStarMatches = 0;

        for(int i = 0; i < 5; i++){
            if(winNums[i] == current[i]){
                regularMatches++;
            }
        }

        for(int i = 5; i < 7; i++){
            if(winNums[i] == current[i]){
                luckyStarMatches++;
            }
        }

        if(regularMatches == 5){
            if(luckyStarMatches == 2) {
                prize = jackpot;
            }
            else if(luckyStarMatches == 1) {
                prize = jackpot * 0.00734244292058155 * 0.2;
            }
            else {
                prize = jackpot * 0.00171603888649572 * 0.0909090909090909;
            }
        }

        if(regularMatches == 4){
            if(luckyStarMatches == 2) {
                prize = jackpot * 0.000534453731161715 * 0.0217391304347826;
            }
            else if(luckyStarMatches == 1) {
                prize = jackpot * 0.000984554433513525 * 0.00138312586445367;
            }
            else {
                prize = jackpot * 0.000731163076984531 * 0.000668002672010688;
            }
        }

        if(regularMatches == 3) {
            if (luckyStarMatches == 2) {
                prize = jackpot * 0.00104060095495879 * 0.000574052812858783;
            }
            else if (luckyStarMatches == 1) {
                prize = jackpot * 0.00407085342122452 * 0.0000334515287348632;
            }
            else {
                prize = jackpot * 0.00750665697696851 * 0.0000166894756166761;
            }
        }

        if(regularMatches == 2){
            if(luckyStarMatches == 2) {
                prize = jackpot * 0.00362671905519088 * 0.0000400512656199936;
            }
            else if(luckyStarMatches == 1) {
                prize = jackpot * 0.0283761497249012 * 0.00000236749150070551;
            }
            else {
                prize = jackpot * 0.0459013166883565 * 0.00000118668726755763;
            }
        }

        if(regularMatches == 1 && luckyStarMatches == 2) {
            prize = jackpot * 0.00912699481213803 * 0.00000755955035794471;
        }
        DecimalFormat df = new DecimalFormat("#########.##");
        return Double.parseDouble(df.format(prize));
    }
}

