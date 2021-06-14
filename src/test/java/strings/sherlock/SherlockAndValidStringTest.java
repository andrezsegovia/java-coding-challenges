package strings.sherlock;

import org.junit.Test;

import static org.junit.Assert.*;

public class SherlockAndValidStringTest {

    @Test
    public void test1() {
        String s = "abc";
        SherlockAndValidString sherlockAndValidString = new SherlockAndValidString();
        assertEquals("YES", sherlockAndValidString.compute(s));
    }
    @Test
    public void test2() {
        String s = "abcc";
        SherlockAndValidString sherlockAndValidString = new SherlockAndValidString();
        assertEquals("YES", sherlockAndValidString.compute(s));
    }
    @Test
    public void test3() {
        String s = "aabbccddeefghi";
        SherlockAndValidString sherlockAndValidString = new SherlockAndValidString();
        assertEquals("NO", sherlockAndValidString.compute(s));
    }
    @Test
    public void test4() {
        String s = "abcdefghhgfedecba";
        SherlockAndValidString sherlockAndValidString = new SherlockAndValidString();
        assertEquals("YES", sherlockAndValidString.compute(s));
    }
    @Test
    public void test5() {
        String s = "aabbcd";
        SherlockAndValidString sherlockAndValidString = new SherlockAndValidString();
        assertEquals("NO", sherlockAndValidString.compute(s));
    }
    @Test
    public void test6() {
        String s = "aaaaabc";
        SherlockAndValidString sherlockAndValidString = new SherlockAndValidString();
        assertEquals("NO", sherlockAndValidString.compute(s));
    }

}