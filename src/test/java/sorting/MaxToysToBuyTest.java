package sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MaxToysToBuyTest {

    @Test
    public void testInsertionSort() {
        List<Integer> prices = Arrays.asList(1, 12, 5, 111, 1000, 200, 10);
        assertEquals(Arrays.asList(1,5,10,12,111,200,1000), new MaxToysToBuy().insertionSort(prices));
    }
    @Test
    public void testInsertionSort2() {
        List<Integer> prices = Arrays.asList(7,6,5,4,3,2,1);
        assertEquals(Arrays.asList(1,2,3,4,5,6,7), new MaxToysToBuy().insertionSort(prices));
    }

    @Test
    public void test1() {
        List<Integer> prices = Arrays.asList(1, 12, 5, 111, 200, 1000, 10);
        int budget = 50;
        assertEquals(4, new MaxToysToBuy().compute(prices, budget));
    }

}