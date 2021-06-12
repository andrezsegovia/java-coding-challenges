package strings.anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {
    public int compute(String a, String b) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> aLetters = new HashMap<>();
        Map<Character, Integer> bLetters = new HashMap<>();
        int deletions = 0;
        for(char c: a.toCharArray()){
            aLetters.compute(Character.valueOf(c), (key, value) -> value == null? 1 : ++value);
        }
        for(char c: b.toCharArray()){
            bLetters.compute(Character.valueOf(c), (key, value) -> value == null? 1 : ++value);
        }
        for(Character keys: aLetters.keySet()) {
            int result = 0;
            if(bLetters.containsKey(keys)) {
                result = aLetters.get(keys) - bLetters.get(keys);
                bLetters.remove(keys);
            } else {
                result = aLetters.get(keys);
            }
            deletions+=result<0?result*-1:result;
        }
        deletions+=bLetters.values().stream().reduce(0, Integer::sum);

        return deletions;
    }
}
