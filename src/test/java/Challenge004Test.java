import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Challenge004Test {

    private Challenge004 challenge004;

    @Before
    public void setUp() throws Exception {
        challenge004 = new Challenge004();
    }

    @Test
    public void medianOfEmptyExpectation() {
        int[] expenditures = {};
        try {
            challenge004.median(expenditures);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals("array should not be empty", e.getMessage());
        }
    }

    @Test
    public void medianOfOddOrderedExpenditures() {
        int expected = 30;
        int[] expenditures = {10,20,30,40,50};
        assertEquals(expected, challenge004.median(expenditures));
    }

    @Test
    public void medianOfEvenOrderedExpenditures() {
        int expected = 35;
        int[] expenditures = {10,20,30,40,50,60}; // 10 20 30 40 50 60 => (30+40)/2 = 35
        assertEquals(expected, challenge004.median(expenditures));
    }

    @Test
    public void medianOfOddUnorderedExpenditures() {
        int expected = 40;
        int[] expenditures = {20,30,40,10,50};
        assertEquals(expected, challenge004.median(expenditures));
    }

    @Test
    public void medianOfEvenUnorderedExpenditures() {
        int expected = 15;
        int[] expenditures = {50,30,20,10,40,60}; // 10 20 30 40 50 60 => (20+10)/2 = 15
        assertEquals(expected, challenge004.median(expenditures));
    }
}