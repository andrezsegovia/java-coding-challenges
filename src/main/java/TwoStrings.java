import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class TwoStrings {


    public String compute(String s1, String s2) {
        Map<Character, Long> s1Characters = s1.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        boolean hasCommonCharacter = false;
        for(Character character: s2.toCharArray()) {
            if(s1Characters.containsKey(character)) {
                hasCommonCharacter = true;
                break;
            }
        }
        return hasCommonCharacter?"YES":"NO";
    }
}
