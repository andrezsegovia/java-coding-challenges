package hashTables;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {

    public String checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Long> magazineWordFrequency = magazine.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int noteSize = note.size();
        boolean isValid = true;
        for(int i = 0; i < noteSize; i++) {
            if(magazineWordFrequency.containsKey(note.get(i)) && magazineWordFrequency.get(note.get(i)).longValue() > 0) {
                magazineWordFrequency.compute(note.get(i), (key, value) -> --value);
            } else {
                isValid = false;
                break;
            }
        }
        return isValid? "Yes": "No";
    }
}
