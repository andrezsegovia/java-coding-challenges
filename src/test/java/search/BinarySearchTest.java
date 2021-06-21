package search;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private int[] arrayGenerator(int from, int elements) {
        int arr[] = new int[elements];
        for(int i = 0; i < elements; i++) {
            arr[i] = from+i;
        }
        return arr;
    }

    @Test
    public void test1() {
        int arr[] = arrayGenerator(0, 10000000);
        int toFind = 9999999;
        long start = System.nanoTime();
        boolean exist = BinarySearch.find(arr, toFind);
        System.out.println(String.format("Run time: %d ns", (System.nanoTime()-start)));
        assertTrue(String.format("%d should be found in the array", toFind), exist);
    }

    @Test
    public void testNormal() {
        int arr[] = arrayGenerator(0, 10000000);
        int toFind = 9999999;
        long start = System.nanoTime();
        boolean exist = BinarySearch.findNormal(arr, toFind);
        System.out.println(String.format("Run time: %d ns", (System.nanoTime()-start)));
        assertTrue(String.format("%d should be found in the array", toFind), exist);
    }
}