package strings.anagram;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {

    @Test
    public void shouldReturnTwo() {
        String a = "cde";
        String b = "dcf";
        Anagram anagram = new Anagram();
        int result = anagram.compute(a, b);
        assertEquals("Strings a = \"cde\" and b = \"dcf\" should have 2 deletions to be create an anagram", 2, result);
    }

    @Test
    public void shouldSuccessIfStringsLengthDeffer() {
        String a = "cde";
        String b = "dcfv";
        Anagram anagram = new Anagram();
        int result = anagram.compute(a, b);
        assertEquals("Strings a = \"cde\" and b = \"dcfv\" should have 3 deletions to be create an anagram", 3, result);
    }

    @Test
    public void testThree() {
        String a = "cde";
        String b = "dcfvvv";
        Anagram anagram = new Anagram();
        int result = anagram.compute(a, b);
        assertEquals(5, result);
    }

    @Test
    public void shouldSuccessIfStringsComplex() {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        Anagram anagram = new Anagram();
        int result = anagram.compute(a, b);
        assertEquals("Strings a = \"fcrxzwscanmligyxyvym\" and b = \"jxwtrhvujlmrpdoqbisbwhmgpmeoke\" should have 30 deletions to be create an anagram", 30, result);
    }

}