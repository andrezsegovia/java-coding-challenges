import java.util.HashMap;
import java.util.Map;

public class Challenge003 {

    public static int[] compute(int[] cost, int money) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < cost.length; i++) {
            int complement = money - cost[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), (i+1)};
            }
            map.put(cost[i],(i+1));
        }
        return new int[]{};
    }
}
