package arrays;

import java.util.List;
import java.util.stream.Collectors;

public class LeftRotation {

    public static List<Integer> rotate(int d, List<Integer> array) {
        if (array.isEmpty()) {
            return array;
        }

        List<Integer> rotatedList = array.stream()
                .map((i)->0).collect(Collectors.toList());

        int newIndex = 0;
        for (int i = 0; i < array.size(); i++) {//n
            newIndex = i - d;
            if(newIndex < 0) {
                newIndex = array.size() - d + i;
                rotatedList.set(newIndex, array.get(i));
                continue;
            }
            rotatedList.set(newIndex, array.get(i));
        }
        return rotatedList;
    }
}
