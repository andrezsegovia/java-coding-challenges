import org.junit.Test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Random;

import static org.junit.Assert.*;

public class Challenge003Test {

    private int[] getRandomArray(int min, int max, int elements) {
        int[] arr = new int[elements];
        for(int i = 0; i < elements; i++ ) {
            arr[i] = min + (int)(new Random().nextDouble() * max);
        }
        return arr;
    }

    @Test
    public void test() {
        int[] cost = {1,4,5,3,2};
        int money = 4;
        int[] expected = {1,4};
        int[] result = Challenge003.compute(cost, money);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {
        int[] cost = getRandomArray(1, 100000, 100000);
        int money = 100;
        long start = System.nanoTime();
        int[] result = Challenge003.compute(cost, money);
        System.out.println(String.format("Time consumed: %d ns", System.nanoTime() - start));
        assertEquals(2, result.length);
        assertTrue(cost[result[0]-1] + cost[result[1]-1] == money);
    }
}