package test;

import com.company.generators.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class NumberGeneratorTest {

    NumberGenerator numberGenerator = new NumberGenerator();

    // Seeing usage of repeated tests to confirm methods pass more than just once by chance
    // The generated numbers utilise Java Utils methods so the methods don't need to be tested - we know they'll be correct.
    // This was more to see RepeatedTest and confirm correct usage of the util methods

    int[] generatedNums;

    @RepeatedTest(1000)
    void testNumbersWithinLimits() {
        for(int i = 0; i < 5; i++) {
            generatedNums = numberGenerator.generateNums();
            Assertions.assertTrue(generatedNums[i] >= 1 && generatedNums[i] <= 50);
        }
        for(int i = 5; i < 7; i++) {
            generatedNums = numberGenerator.generateNums();
            Assertions.assertTrue(generatedNums[i] >= 1 && generatedNums[i] <= 12);
        }
    }

    @RepeatedTest(1000)
    void testOrderRegulars() {
        for(int i = 0; i < 4; i++) {
            generatedNums = numberGenerator.generateNums();
            Assertions.assertTrue(generatedNums[i] < generatedNums[(i+1)]);
        }
    }

    @RepeatedTest(1000)
    void testOrderLuckyStars() {
        generatedNums = numberGenerator.generateNums();
        Assertions.assertTrue(generatedNums[5] < generatedNums[6]);
    }
}