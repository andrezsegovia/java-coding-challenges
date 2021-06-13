package strings.anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
    public int compute(String a, String b) {
        Map<Character, Long> aLetters = a.chars()
                .mapToObj(letter -> (char) letter)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> bLetters = b.chars()
                .mapToObj(letter -> (char) letter)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        BiFunction<Long, Long, Long> mergeDuplicatedKeys = (value1, value2) -> {
            long diff = value1 - value2;
            return diff < 0 ? diff * -1 : diff;
        };

        Map<Character, Long> mergedMap = new HashMap<>();
        aLetters.forEach((key, value) -> mergedMap.merge(key, value, mergeDuplicatedKeys));
        bLetters.forEach((key, value) -> mergedMap.merge(key, value, mergeDuplicatedKeys));
        return mergedMap.values().stream().reduce(0L, Long::sum).intValue();
    }
}
