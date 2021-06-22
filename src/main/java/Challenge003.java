import search.BinarySearch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Challenge003 {

    private static Map<Integer, Integer> getMapFromList(List<Integer> list) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            hashMap.put(i, list.get(i));
        }
        return hashMap;
    }

    private static Map<Integer, Integer[]> getMapFromArr(int[] arr) {
        Map<Integer, Integer[]> hashMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            hashMap.put(i, new Integer[]{arr[i],i});
        }
        return hashMap;
    }



    public static int[] compute(int[] cost, int money) {
        boolean found = false;
        int index = 0;
        Map<Integer, Integer[]> costMap = getMapFromArr(cost);
        int value = 0;
        int toFind = 0;
        Integer foundIndex = 0;
        while(!found && index < cost.length) {
            value = cost[index];
            toFind = money - value;
            //foundIndex = BinarySearch.search(costMap, toFind);
            if(foundIndex == null) {
                index++;
                continue;
            }
            found = true;
        }
        if(found) {
            return new int[]{index+1,foundIndex+1};
        } else {
            return new int[]{};
        }
    }
}
