package com.company;

import com.company.gameplay.PlayLottery;

import java.util.Scanner;

public class Main {

    static PlayLottery playLottery = new PlayLottery();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the no. of times to play:");
        int playTimes = scanner.nextInt();
        System.out.println("Enter the target winnings:" + "\n" + "(Dont greedy, otherwise this could take some time!)");
        double targetWinnings = scanner.nextDouble();

        playLottery.playNTimes(playTimes);
        System.out.println(printStats());

        playLottery.playToTargetValue(targetWinnings);
        System.out.println(printStats());
    }

    private static String printStats(){
        return " Total plays: " + playLottery.getCountPlays() +
                "\n Total winnings: " + playLottery.getTotalWinnings() +
                "\n Total spent: " + playLottery.getTotalSpend() +
                "\n Net profit: " + (playLottery.getTotalWinnings() - playLottery.getTotalSpend());
    }
}