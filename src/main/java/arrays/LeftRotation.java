package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeftRotation {

    public static List<Integer> rotate(int rotations, List<Integer> array) {
        List<Integer> rotatedList = new ArrayList<>(array.size());
        for (int i : array) {
            rotatedList.add(0);
        }
        while (rotations > 0 ) { //d
            rotations--;
            for (int i = 0; i < array.size(); i++) {//n
                if(i == 0) {
                    rotatedList.set(array.size()-1, array.get(i));
                    continue;
                }
                rotatedList.set((i-1), array.get(i));
            }
            Collections.copy(array,rotatedList);//n => O(d*n)
        }
        return array;
    }
}
