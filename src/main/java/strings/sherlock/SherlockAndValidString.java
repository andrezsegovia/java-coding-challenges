package strings.sherlock;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
public class SherlockAndValidString {

    public String compute(String s) {
        Map<Long, Long> frequencies = s.chars()
                .mapToObj(letter -> (char)letter)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequencies);
        if(frequencies.size() == 1) {
            return "YES";
        }
        if(frequencies.size() == 2) {
            Long lessFrequency = frequencies.values().stream().min((v1, v2) -> v1>v2?1:-1).get();
            System.out.println(lessFrequency);
            if(lessFrequency>1) {
                return "NO";
            }
            return "YES";
        }
        return "NO";
    }
}
