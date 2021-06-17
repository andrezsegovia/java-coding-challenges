import org.junit.Test;

import static org.junit.Assert.*;

public class TwoStringsTest {

    @Test
    public void test1() {
        String s1 = "hello", s2 = "world";
        assertEquals("YES", new TwoStrings().compute(s1, s2));
    }

    @Test
    public void test2() {
        String s1 = "hi", s2 = "world";
        assertEquals("NO", new TwoStrings().compute(s1, s2));
    }

    @Test
    public void test3() {
        String s1 = "wouldyoulikefries", s2 = "abcabcabcabcabcabc";
        assertEquals("NO", new TwoStrings().compute(s1, s2));
    }

    @Test
    public void test4() {
        String s1 = "hackerrankcommunity", s2 = "cdecdecdecde";
        assertEquals("YES", new TwoStrings().compute(s1, s2));
    }

}