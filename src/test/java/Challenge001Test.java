import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stack.BalanceParenthesesTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Challenge001Test {
    private final String cases;
    private final String events;
    private final String results;

    @Parameterized.Parameters
    public static Collection<Object[]> input() {
        List<Object[]> args = new ArrayList<>();
        args.add(new Object[]{"2", "1 3 2 - 2 p 3", "SUCCESS => RECEIVED: 3 - FAILURE => WRONG INPUT (LINE 2)"});
        args.add(new Object[]{"f", "1 3 2 - 2 1 3", "FAILURE => WRONG INPUT (LINE 1)"});
        args.add(new Object[]{"3", "1 3 2 - 1 2 4 5 - 1 5 4 3 2", "SUCCESS => RECEIVED: 3 - FAILURE => RECEIVED: 4, EXPECTED: 5 - SUCCESS => RECEIVED: 5"});
        args.add(new Object[]{"1", "  1  2  ", "SUCCESS => RECEIVED: 2"});
        return args;
    }

    public Challenge001Test(String cases, String events, String results) {
        this.cases = cases;
        this.events = events;
        this.results = results;
    }

    @Test
    public void test() {
        String[] eventArr = this.events.split(" - ");
        List<String> resultExpected = Arrays.asList(this.results.split(" - "));
        List<String> result = Challenge001.compute(this.cases, eventArr);
        System.out.println(result);
        assertEquals(resultExpected.size(), result.size());
        assertEquals(resultExpected, result);

    }
}