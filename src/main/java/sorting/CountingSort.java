package sorting;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {


    public static void sort(List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        int n = list.size();
        List<Integer> output = new ArrayList<>(list.size());

        List<Integer> count = new ArrayList<>(200);
        for(int i = 0; i < 200; i++) {
            count.add(i, 0);
        }

        for(int i = 0; i < n; i++) {
            int val = count.get(list.get(i))+1;
            count.set(list.get(i), val);
        }

        for(int i = 1; i < 200; i++) {
            count.set(i, count.get(i) + count.get(i-1));
        }
        for (int i = 0; i < n; i++) {
            output.add(i,0);
        }
        for(int i = n-1; i >= 0; i--) {
            output.set(count.get(list.get(i)) - 1, list.get(i));
            count.set(list.get(i), count.get(list.get(i))-1);
        }

        for(int i = 0; i < n; i++) {
            list.set(i, output.get(i));
        }
    }
}
