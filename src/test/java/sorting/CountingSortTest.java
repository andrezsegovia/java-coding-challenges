package sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class CountingSortTest {

    @Test
    public void sortEmptyList() {
        List<Integer> emptyList = new ArrayList<>();

        CountingSort.sort(emptyList);
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void sortListWith200MaximumNumber() {
        List<Integer> list = Arrays.asList(1, 4, 1, 2, 7, 5, 2);

        CountingSort.sort(list);

        assertEquals(Arrays.asList(1, 1, 2, 2, 4, 5, 7), list);
    }


}