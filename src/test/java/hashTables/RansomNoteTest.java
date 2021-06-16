package hashTables;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RansomNoteTest {

    @Test
    public void test1() {
        List<String> magazine = Arrays.asList("give","me","one","grand","today","night");
        List<String> note = Arrays.asList("give","one","grand","today");
        RansomNote ransomNote = new RansomNote();
        assertEquals("Yes", ransomNote.checkMagazine(magazine, note));
    }
    @Test
    public void test2() {
        //two times three is not four
        //two times two is four
        List<String> magazine = Arrays.asList("two","times","three","is","not","four");
        List<String> note = Arrays.asList("two","times","two","is", "four");
        RansomNote ransomNote = new RansomNote();
        assertEquals("No", ransomNote.checkMagazine(magazine, note));
    }
    @Test
    public void test3() {
        List<String> magazine = Arrays.asList("Give","me","one","grand","today","night");
        List<String> note = Arrays.asList("give","one","grand","today");
        RansomNote ransomNote = new RansomNote();
        assertEquals("No", ransomNote.checkMagazine(magazine, note));
    }

}