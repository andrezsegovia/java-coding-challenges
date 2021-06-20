package HastSet;

import java.util.HashSet;
import java.util.Set;

public class JavaHashSet {


    public static int compute(int numbersPairs, String[] pairs) {
        Set<String> uniquePairs = new HashSet<>(numbersPairs);
        for(String pair: pairs) {
            uniquePairs.add(pair);
        }
        return uniquePairs.size();
    }
}
