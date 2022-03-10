package test;

import com.company.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    NumberGenerator numberGenerator = new NumberGenerator();

    @Test
    void generateNums() {

        int[] generatedNums = numberGenerator.generateNums();

        for(int i = 0; i < 5; i++) {
            Assertions.assertTrue(generatedNums[i] >= 1 && generatedNums[i] <= 52);
        }
        for(int i = 5; i < 7; i++) {
            Assertions.assertTrue(generatedNums[i] >= 1 && generatedNums[i] <= 12);
        }




    }
}