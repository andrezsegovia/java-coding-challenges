package stack;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
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

    @Test
    public void getMaxPrintSequentialOperations() {
        operations.add("1 44");
        operations.add("1 45");
        operations.add("3");
        operations.add("3");

        List<Integer> result = MaxElement.getMax(operations);

        assertTrue(result.size()==2);
        assertEquals(45, result.get(0).intValue());
        assertEquals(45, result.get(1).intValue());
    }

    @Test
    public void getMaxDeleteSequentialOperations() {
        operations.add("1 45");
        operations.add("2");
        operations.add("2");

        List<Integer> result = MaxElement.getMax(operations);

        assertTrue(result.isEmpty());
    }

    @Test
    public void getMaxPrintAndDeleteSequentialOperations() {
        operations.add("1 44");
        operations.add("1 45");
        operations.add("3");
        operations.add("3");
        operations.add("2");
        operations.add("3");
        operations.add("3");

        List<Integer> result = MaxElement.getMax(operations);

        assertTrue(result.size()==4);
        assertEquals(45, result.get(0).intValue());
        assertEquals(45, result.get(1).intValue());
        assertEquals(44, result.get(2).intValue());
        assertEquals(44, result.get(3).intValue());
    }

    @Test
    @FileParameters("classpath:data_test_maxElement.csv")
    public void getMaxElement(String... operationsArg) {

        for(String operation: operationsArg) {
            operations.add(operation);
        }

        List<Integer> result = MaxElement.getMax(operations);

        List<Integer> expected = Arrays.asList(44,44,1,1,3,29,73,73,73,73,73,73,73,73,73,85,85,85,86,86,100,100,100);

        System.out.println(result.size());
        assertEquals(expected, result);

    }

    @Test
    public void max() {
        List<Integer> numbers = Arrays.asList(44,44,1,1,3,29,73,73,73,73,73,73,73,73,73,85,85,85,86,86,100,100,100);

        int max = MaxElement.max(numbers);

        assertEquals(100, max);
    }
}