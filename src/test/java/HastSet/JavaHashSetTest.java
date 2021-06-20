package HastSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class JavaHashSetTest {

    private final int numberPairs;
    private final String[] pairs;
    private final int uniquePairs;

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        List<Object[]> params = new ArrayList<>();
        params.add(new Object[]{
                5,
                new String[]{
                        "john tom",
                        "john mary",
                        "john tom",
                        "mary anna",
                        "mary anna"},
                3
        });
        return params;
    }

    public JavaHashSetTest(int numberPairs, String[] pairs, int uniquePairs) {
        this.numberPairs = numberPairs;
        this.pairs = pairs;
        this.uniquePairs = uniquePairs;
    }

    @Test
    public void tests() {
        assertEquals(this.uniquePairs, JavaHashSet.compute(this.numberPairs, pairs));
    }

}