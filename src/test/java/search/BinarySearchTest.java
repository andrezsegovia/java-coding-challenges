package search;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
        Optional found = BinarySearch.linearSearch(arr, toFind);
        System.out.println(String.format("Run time: %d ns", (System.nanoTime()-start)));
        assertTrue(String.format("%d should be found in the array", toFind), found.isPresent());
    }

    @Test
    public void test2() {
        Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
        /*map.put(0,1);
        map.put(1,4);
        map.put(2,5);
        map.put(3,3);
        map.put(4,2);*/
        map.put(0,new Integer[]{1,0});
        map.put(1,new Integer[]{2,5});
        map.put(2,new Integer[]{3,3});
        map.put(3,new Integer[]{4,1});
        map.put(4,new Integer[]{5,2});
        Integer result = BinarySearch.search(map, 3);
        assertNotNull(result);
        assertEquals(3, result.intValue());

    }
}