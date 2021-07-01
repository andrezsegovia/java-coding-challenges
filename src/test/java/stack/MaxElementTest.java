package stack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MaxElementTest {

    List<String> operations;
    @Before
    public void setUp() throws Exception {
        operations = new ArrayList<>();
    }

    @Test
    public void getMaxEmptyOperations() {
        List<Integer> result = MaxElement.getMax(operations);

        assertTrue(result.isEmpty());
    }

    @Test
    public void getMaxAddElementOperation() {
        operations.add("1 97");

        List<Integer> result = MaxElement.getMax(operations);

        assertTrue(result.isEmpty());
    }

    @Test
    public void getMaxDeleteElementOperation() {
        operations.add("1 97");
        operations.add("2");

        List<Integer> result = MaxElement.getMax(operations);

        assertTrue(result.isEmpty());
    }

    @Test
    public void getMaxPrintElementOperation() {
        operations.add("1 97");
        operations.add("3");

        List<Integer> result = MaxElement.getMax(operations);

        assertEquals(97, result.get(0).intValue());
    }

    @Test
    public void getMaxMultipleOperations() {
        operations.add("1 97");
        operations.add("2");
        operations.add("1 20");
        operations.add("2");
        operations.add("1 26");
        operations.add("1 20");
        operations.add("2");
        operations.add("3");
        operations.add("1 91");
        operations.add("3");

        List<Integer> result = MaxElement.getMax(operations);

        assertTrue(result.size()==2);
        assertEquals(26, result.get(0).intValue());
        assertEquals(91, result.get(1).intValue());
    }
}