package com.company.gameplay;

import com.company.generators.Ticket;
import com.company.generators.WinningNumbers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayLottery {

    private WinningNumbers winningNumbers = new WinningNumbers();
    private Ticket ticket = new Ticket();

    private double jackpot = 55075675;
    private long countPlays = 0;
    private double totalSpend = 0;
    private double totalWinnings = 0;
    private double ticketPrice = 2.5;
    private final DecimalFormat decimalFormat = new DecimalFormat("#########.##");

    private List<int[]> winningNumsList = new ArrayList<>();
    private List<int[]> ticketsList = new ArrayList<>();

    private int[] winningNums;
    private int[] ticketNums;

    public boolean checkWin(int[] winNums, int[] current){
        return (Arrays.equals(winNums, current));
    }

    public void playOnce() {
        setWinningNums(getWinningNumbers().generateNums());
        setTicketNums(getTicket().generateNums());
        setTotalSpend(getTotalSpend() + getTicketPrice());
        setCountPlays(getCountPlays() + 1);
        getWinningNumsList().add(getWinningNums());
        getTicketsList().add(getTicketNums());
        setTotalWinnings(getTotalWinnings() + calculatePrize(getWinningNums(), getTicketNums()));
        checkWin(getWinningNums(), getTicketNums());
    }

    public void playNTimes(long maxPlays) {
        while(countPlays < maxPlays) {
            playOnce();
        }
    }
    public void playToTargetValue(double targetWinnings) {
        while(totalWinnings < targetWinnings) {
            playOnce();
        }
    }

    public double calculatePrize(int[] winNums, int[] current){
        // Jackpot taken from https://www.national-lottery.co.uk/results/euromillions/draw-history/prize-breakdown/1507
        //Table of winning values taken from that page - the percentages etc. obviously would vary from game to game based on the actual amount of tickets with matching numbers,
        // but for the sake of this I've done basic calculations to calculate the spread

        double prize = 0;
        int[] matches = {0, 0};

        for(int i = 0; i < 7; i++) {
            if (i < 5) {
                if (winNums[i] == current[i]) {
                    matches[0]++;
                }
            }
            else {
                if (winNums[i] == current[i]) {
                    matches[1]++;
                }
            }
        }

        if(matches[0] == 5){
            switch (matches[1]) {
                case (2) -> prize = getJackpot();
                case (1) -> prize = getJackpot() * 0.00734244292058155 * 0.2;
                case (0) -> prize = getJackpot() * 0.00171603888649572 * 0.0909090909090909;
            }
        }
        if(matches[0] == 4){
            switch (matches[1]) {
                case (2) -> prize = getJackpot() * 0.000534453731161715 * 0.0217391304347826;
                case (1) -> prize = getJackpot() * 0.000984554433513525 * 0.00138312586445367;
                case (0) -> prize = getJackpot() * 0.000731163076984531 * 0.000668002672010688;
            }
        }
        if(matches[0] == 3){
            switch (matches[1]) {
                case (2) -> prize = getJackpot() * 0.00104060095495879 * 0.000574052812858783;
                case (1) -> prize = getJackpot() * 0.00407085342122452 * 0.0000334515287348632;
                case (0) -> prize = getJackpot() * 0.00750665697696851 * 0.0000166894756166761;
            }
        }
        if(matches[0] == 2){
            switch (matches[1]) {
                case (2) -> prize = getJackpot() * 0.00362671905519088 * 0.0000400512656199936;
                case (1) -> prize = getJackpot() * 0.0283761497249012 * 0.00000236749150070551;
                case (0) -> prize = getJackpot() * 0.0459013166883565 * 0.00000118668726755763;
            }
        }
        if(matches[0] == 1){
            if (matches[1] == 2) {
                prize = getJackpot() * 0.00912699481213803 * 0.00000755955035794471;
            }
        }

        DecimalFormat df = new DecimalFormat("#########.##");
        return Double.parseDouble(df.format(prize));
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getJackpot() {
        return jackpot;
    }

    public void setJackpot(double jackpot) {
        this.jackpot = jackpot;
    }

    public long getCountPlays() {
        return countPlays;
    }

    public void setCountPlays(long countPlays) {
        this.countPlays = countPlays;
    }

    public double getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(double totalSpend) {
        this.totalSpend = totalSpend;
    }

    public double getTotalWinnings() {
        return Double.parseDouble(decimalFormat.format(totalWinnings));
    }

    public void setTotalWinnings(double totalWinnings) {
        this.totalWinnings = totalWinnings;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public List<int[]> getWinningNumsList() {
        return winningNumsList;
    }

    public void setWinningNumsList(List<int[]> winningNumsList) {
        this.winningNumsList = winningNumsList;
    }

    public List<int[]> getTicketsList() {
        return ticketsList;
    }

    public void setTicketsList(List<int[]> ticketsList) {
        this.ticketsList = ticketsList;
    }

    public int[] getWinningNums() {
        return winningNums;
    }

    public void setWinningNums(int[] winningNums) {
        this.winningNums = winningNums;
    }

    public int[] getTicketNums() {
        return ticketNums;
    }

    public void setTicketNums(int[] ticketNums) {
        this.ticketNums = ticketNums;
    }
}