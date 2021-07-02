package arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SparseArrays {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        Iterator<String> queriesIterator = queries.iterator();
        List<String> temp = new ArrayList<>(strings);
        List<Integer> results = new ArrayList<>(queries.size());
        while (queriesIterator.hasNext()) {
            String query = queriesIterator.next();
            results.add(strings.stream().filter(string -> string.equals(query))
                    .collect(Collectors.counting()).intValue());
        }
        return results;
    }
}
