package arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SparseArraysTest {

    @Test
    public void matchingStrings() {
        List<String> strings = Arrays.asList("ab", "ab", "abc");
        List<String> queries = Arrays.asList("ab", "abc", "bc");

        List<Integer> results = SparseArrays.matchingStrings(strings, queries);

        assertEquals(Arrays.asList(2,1,0), results);

    }
}