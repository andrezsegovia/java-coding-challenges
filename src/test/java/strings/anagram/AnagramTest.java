package strings.anagram;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {

    @Test
    public void unitTest_1() {
        String a = "cde";
        String b = "dcf";
        Anagram anagram = new Anagram();
        int result = anagram.compute(a, b);
        assertEquals(2, result);
    }

    @Test
    public void unitTest_2() {
        String a = "cde";
        String b = "dcfv";
        Anagram anagram = new Anagram();
        int result = anagram.compute(a, b);
        assertEquals(3, result);
    }

    @Test
    public void unitTest_3() {
        String a = "cde";
        String b = "dcfvvv";
        Anagram anagram = new Anagram();
        int result = anagram.compute(a, b);
        assertEquals(5, result);
    }

    @Test
    public void unitTest_4() {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        Anagram anagram = new Anagram();
        int result = anagram.compute(a, b);
        assertEquals("Strings a = \"fcrxzwscanmligyxyvym\" and b = \"jxwtrhvujlmrpdoqbisbwhmgpmeoke\" should have 30 deletions to be create an anagram", 30, result);
    }

}