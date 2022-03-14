package test;

import com.company.PlayLottery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayLotteryTest {

    /*
    Expected values based on table here:
    https://www.national-lottery.co.uk/results/euromillions/draw-history/prize-breakdown/1507
     */

    PlayLottery playLottery = new PlayLottery();

    int noMatch = 9;

    int[] winningNumbers = {8, 24, 26, 39, 42, 3, 5};

    int[] match5And2 = {8, 24, 26, 39, 42, 3, 5};
    int[] match5And1 = {8, 24, 26, 39, 42, 3, noMatch};
    int[] match5 = {8, 24, 26, 39, 42, noMatch, noMatch};
    int[] match4And2 = {8, 24, 26, 39, noMatch, 3, 5};
    int[] match4And1 = {8, 24, 26, 39, noMatch, 3, noMatch};
    int[] match3And2 = {8, 24, 26, noMatch, noMatch, 3, 5};
    int[] match4 = {8, 24, 26, 39, noMatch, noMatch, noMatch};
    int[] match2And2 = {8, 24, noMatch, noMatch, noMatch, 3, 5};
    int[] match3And1 = {8, 24, 26, noMatch, noMatch, 3, noMatch};
    int[] match3 = {8, 24, 26, noMatch, noMatch, noMatch, noMatch};
    int[] match1And2 = {8, noMatch, noMatch, noMatch, noMatch, 3, 5};
    int[] match2And1 = {8, 24, noMatch, noMatch, noMatch, 3, noMatch};
    int[] match2 = {8, 24, noMatch, noMatch, noMatch, noMatch, noMatch};


    @Test
    void checkForWin() {
        Assertions.assertTrue(playLottery.checkWin(winningNumbers, match5And2));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match5And1));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match5));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match4And2));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match4And1));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match3And2));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match4));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match2And2));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match3And1));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match3));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match1And2));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match2And1));
        Assertions.assertFalse(playLottery.checkWin(winningNumbers, match2));
    }

    @Test
    void calculatePrize() {

        Assertions.assertEquals(55075675, playLottery.calculatePrize(winningNumbers, match5And2));
        Assertions.assertEquals(80878, playLottery.calculatePrize(winningNumbers, match5And1));
        Assertions.assertEquals(8592, playLottery.calculatePrize(winningNumbers, match5));
        Assertions.assertEquals(639.90, playLottery.calculatePrize(winningNumbers, match4And2));
        Assertions.assertEquals(75, playLottery.calculatePrize(winningNumbers, match4And1));
        Assertions.assertEquals(32.9, playLottery.calculatePrize(winningNumbers, match3And2));
        Assertions.assertEquals(26.9, playLottery.calculatePrize(winningNumbers, match4));
        Assertions.assertEquals(8, playLottery.calculatePrize(winningNumbers, match2And2));
        Assertions.assertEquals(7.5, playLottery.calculatePrize(winningNumbers, match3And1));
        Assertions.assertEquals(6.9, playLottery.calculatePrize(winningNumbers, match3));
        Assertions.assertEquals(3.8, playLottery.calculatePrize(winningNumbers, match1And2));
        Assertions.assertEquals(3.7, playLottery.calculatePrize(winningNumbers, match2And1));
        Assertions.assertEquals(3, playLottery.calculatePrize(winningNumbers, match2));
    }


    @Test
    void playNTimes() {
        int plays = 10;
        playLottery.playNTimes(10);

        long result = playLottery.getCountPlays();
        long expected = 10;
    }

    @Test
    void playToTargetValue() {
    }
}