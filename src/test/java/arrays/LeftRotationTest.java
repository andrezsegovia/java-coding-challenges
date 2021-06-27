package arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LeftRotationTest {

    @Test
    public void rotateEmptyArray() {
        List<Integer> array = Arrays.asList();
        int rotations = 2;

        array = LeftRotation.rotate(rotations, array);

        List<Integer> expectedArray = Arrays.asList();
        assertEquals(expectedArray, array);
    }

    @Test
    public void rotateArray() {
        List<Integer> array = Arrays.asList(1,2,3,4,5);
        int rotations = 2;

        array = LeftRotation.rotate(rotations, array);

        List<Integer> expectedArray = Arrays.asList(3,4,5,1,2);
        assertEquals(expectedArray, array);
    }
}