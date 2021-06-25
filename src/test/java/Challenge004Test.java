import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
        double expected = 30.0;
        int[] expenditures = {10,20,30,40,50};
        assertEquals(expected, challenge004.median(expenditures),0);
    }

    @Test
    public void medianOfEvenOrderedExpenditures() {
        double expected = 35.0;
        int[] expenditures = {10,20,30,40,50,60}; // 10 20 30 40 50 60 => (30+40)/2 = 35
        assertEquals(expected, challenge004.median(expenditures),0);
    }

    @Test
    public void medianOfOddUnorderedExpenditures() {
        double expected = 40.0;
        int[] expenditures = {20,30,40,10,50};
        assertEquals(expected, challenge004.median(expenditures),0);
    }

    @Test
    public void medianOfEvenUnorderedExpenditures() {
        double expected = 15.0;
        int[] expenditures = {50,30,20,10,40,60}; // 10 20 30 40 50 60 => (20+10)/2 = 15
        assertEquals(expected, challenge004.median(expenditures), 0);
    }

    @Test
    public void sortEmptyExpenditures() {
        int[] emptyExpenditures = {};
        try {
            challenge004.sort(emptyExpenditures);
        } catch (IllegalArgumentException e) {
            assertEquals("array should not be empty", e.getMessage());
        }
    }

    @Test
    public void sortNonEmptyAExpenditures() {
        int[] expenditures = {50,30,20,10,40,60};

        challenge004.sort(expenditures);

        int[] expectedOrderedExpenditures = {10,20,30,40,50,60};
        assertArrayEquals(expectedOrderedExpenditures, expenditures);
    }

    @Test
    public void hasPreviousExpendituresEmptyExpenditures() {
        int[] expenditures = {};
        int trailingDays = 4;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            challenge004.hasPreviousExpenditures(expenditures, trailingDays);
        });
        assertEquals("array should not be empty", exception.getMessage());
    }

    @Test
    public void hasPreviousExpendituresSmallExpenditures() {
        int[] expenditures = {10,20,30,40};
        int trailingDays = 5;
        assertEquals(false, challenge004.hasPreviousExpenditures(expenditures, trailingDays));
    }

    @Test
    public void hasPreviousExpendituresEqualExpenditures() {
        int[] expenditures = {10,20,30,40};
        int trailingDays = 4;
        assertEquals(false, challenge004.hasPreviousExpenditures(expenditures, trailingDays));
    }

    @Test
    public void hasPreviousExpendituresEnoughExpenditures() {
        int[] expenditures = {10,20,30,40,50};
        int trailingDays = 4;
        assertEquals(true, challenge004.hasPreviousExpenditures(expenditures, trailingDays));
    }

    @Test
    public void calculateNotifications() {
        int[] expenditures = {10,20,30,40,50};
        int trailingDays = 3;

        int notifications = challenge004.notifications(expenditures, trailingDays);

        assertEquals(1, notifications);
    }

    @Test
    public void calculateNotificationsWithoutEnoughExpenditures() {
        int[] expenditures = {10,20,30,40};
        int trailingDays = 4;

        int notifications = challenge004.notifications(expenditures, trailingDays);

        assertEquals(0, notifications);
    }

    @Test
    public void calculateNotificationsLongerExpenditures() {
        int[] expenditures = {10,20,30,40,50,70,80,90,100}; // 50
        int trailingDays = 4;

        int notifications = challenge004.notifications(expenditures, trailingDays);

        assertEquals(2, notifications);
    }

    @Test
    public void calculateNotifications_2() {
        int[] expenditures = {2,3,4,2,3,6,8,4,5}; // 50
        int trailingDays = 5;

        int notifications = challenge004.notifications(expenditures, trailingDays);

        assertEquals(2, notifications);
    }

    @Test
    public void calculateNotifications_3() {
        int[] expenditures = {1,2,3,4,4}; // 50
        int trailingDays = 4;

        int notifications = challenge004.notifications(expenditures, trailingDays);

        assertEquals(0, notifications);
    }

    @Test
    public void name() {
        List<Integer> expences = new ArrayList<>();
        expences.add(10);
        expences.add(20);
        expences.add(30);
        expences.add(40);
        expences.add(50);

        int[] newArray = expences.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(newArray));

    }
}