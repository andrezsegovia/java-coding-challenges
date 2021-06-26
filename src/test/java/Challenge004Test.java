import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class Challenge004Test {

    private Challenge004 challenge004;

    @Before
    public void setUp() throws Exception {
        challenge004 = new Challenge004();
    }

    @Test
    public void medianOfEmptyExpectation() {
        List<Integer> expenditures = new ArrayList<>();
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
        List<Integer> expenditures = Arrays.asList(10, 20, 30, 40, 50);
        assertEquals(expected, challenge004.median(expenditures), 0);
    }

    @Test
    public void medianOfEvenOrderedExpenditures() {
        double expected = 35.0;
        List<Integer> expenditures = Arrays.asList(10, 20, 30, 40, 50, 60); // 10 20 30 40 50 60 => (30+40)/2 = 35
        assertEquals(expected, challenge004.median(expenditures), 0);
    }

    @Test
    public void medianOfOddUnorderedExpenditures() {
        double expected = 40.0;
        List<Integer> expenditures = Arrays.asList(20, 30, 40, 10, 50);
        assertEquals(expected, challenge004.median(expenditures), 0);
    }

    @Test
    public void medianOfEvenUnorderedExpenditures() {
        double expected = 15.0;
        List<Integer> expenditures = Arrays.asList(50, 30, 20, 10, 40, 60); // 10 20 30 40 50 60 => (20+10)/2 = 15
        assertEquals(expected, challenge004.median(expenditures), 0);
    }

    @Test
    public void sortEmptyExpenditures() {
        List<Integer> emptyExpenditures = new ArrayList<>();
        try {
            challenge004.sort(emptyExpenditures);
        } catch (IllegalArgumentException e) {
            assertEquals("array should not be empty", e.getMessage());
        }
    }

    @Test
    public void sortNonEmptyAExpenditures() {
        List<Integer> expenditures = Arrays.asList(50, 30, 20, 10, 40, 60);

        challenge004.sort(expenditures);

        List<Integer> expectedOrderedExpenditures = Arrays.asList(10, 20, 30, 40, 50, 60);
        assertEquals(expectedOrderedExpenditures, expenditures);
    }

    @Test
    public void hasPreviousExpendituresEmptyExpenditures() {
        List<Integer> expenditures = new ArrayList<>();
        int trailingDays = 4;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            challenge004.hasPreviousExpenditures(expenditures, trailingDays);
        });
        assertEquals("array should not be empty", exception.getMessage());
    }

    @Test
    public void hasPreviousExpendituresSmallExpenditures() {
        List<Integer> expenditures = Arrays.asList(10, 20, 30, 40);
        int trailingDays = 5;
        assertEquals(false, challenge004.hasPreviousExpenditures(expenditures, trailingDays));
    }

    @Test
    public void hasPreviousExpendituresEqualExpenditures() {
        List<Integer> expenditures = Arrays.asList(10, 20, 30, 40);
        int trailingDays = 4;
        assertEquals(false, challenge004.hasPreviousExpenditures(expenditures, trailingDays));
    }

    @Test
    public void hasPreviousExpendituresEnoughExpenditures() {
        List<Integer> expenditures = Arrays.asList(10, 20, 30, 40, 50);
        int trailingDays = 4;
        assertEquals(true, challenge004.hasPreviousExpenditures(expenditures, trailingDays));
    }

    @Test
    public void calculateNotifications() {
        List<Integer> expenditures = Arrays.asList(10, 20, 30, 40, 50);
        int trailingDays = 3;

        int notifications = challenge004.notifications(expenditures, trailingDays);

        assertEquals(1, notifications);
    }

    @Test
    public void calculateNotificationsWithoutEnoughExpenditures() {
        List<Integer> expenditures = Arrays.asList(10, 20, 30, 40);
        int trailingDays = 4;

        int notifications = challenge004.notifications(expenditures, trailingDays);

        assertEquals(0, notifications);
    }

    @Test
    public void calculateNotificationsLongerExpenditures() {
        List<Integer> expenditures = Arrays.asList(10, 20, 30, 40, 50, 70, 80, 90, 100); // 50
        int trailingDays = 4;

        int notifications = challenge004.notifications(expenditures, trailingDays);

        assertEquals(2, notifications);
    }

    @Test
    public void calculateNotifications_2() {
        List<Integer> expenditures = Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5); // 50
        int trailingDays = 5;

        int notifications = challenge004.notifications(expenditures, trailingDays);

        assertEquals(2, notifications);
    }

    @Test
    @FileParameters("classpath:challenge004/test.csv")
    public void calculateNotifications_3(int trailingDays, int notificationsExpected, String expendituresStr ) {
        String[] expendituresStrArr = expendituresStr.split("-");
        List<Integer> expenditures = Stream.of(expendituresStrArr)
                .map(Integer::valueOf)
                .limit(expendituresStrArr.length)
                .collect(Collectors.toList());
        int notifications = challenge004.notifications(expenditures, trailingDays);
        assertEquals(notificationsExpected, notifications);
    }

    @Test
    public void medianOddTrailingDays() {
        double expected = 30.0;
        int trailingDays = 3;
        int expenseIndex = 4;
        List<Integer> expenditures = Arrays.asList(10, 20, 30, 40, 50, 60); // 10 20 30 40 50 60 => (30+40)/2 = 35
        assertEquals(expected, challenge004.median(expenditures, expenseIndex, trailingDays), 0);
    }

    @Test
    public void medianEvenTrailingDays() {
        double expected = 35.0;
        int trailingDays = 4;
        int expenseIndex = 5;
        List<Integer> expenditures = Arrays.asList(10, 20, 30, 40, 50, 60, 70); // 10 20 30 40 50 60 => (30+40)/2 = 35
        assertEquals(expected, challenge004.median(expenditures, expenseIndex, trailingDays), 0);
    }

    @Test
    public void medianEvenTrailingDays_2() {
        double expected = 2.5;
        int trailingDays = 4;
        int expenseIndex = 4;
        List<Integer> expenditures = Arrays.asList(1, 2, 3, 4, 4); // 10 20 30 40 50 60 => (30+40)/2 = 35
        assertEquals(expected, challenge004.median(expenditures, expenseIndex, trailingDays), 0);
    }
 }