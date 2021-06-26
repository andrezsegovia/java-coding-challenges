import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

public class Challenge004 {
    /**
     * Get the median of a non-empty and ordered array on integers.
     * @param list array of integers
     * @return {@code int} value that represents the median
     * @throws IllegalArgumentException when the array is null
     */
    public double median(List<Integer> list) {
        if(list.isEmpty()) {
            throw new IllegalArgumentException("array should not be empty");
        }
        final int size = list.size();
        if(size % 2 == 0) {
            int middleLeft = list.get((size/2)-1);
            int middleRight = list.get((size/2));
            return (middleLeft+middleRight)/2.0;
        }
        return list.get((size/2));
    }

    private int partition(List<Integer> list, int left, int right, int pivot) {
        while (left <= right) {
            while (list.get(left) < pivot) {
                left++;
            }
            while (list.get(right) > pivot) {
                right--;
            }
            if(left <= right) {
                swap(list, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(List<Integer> list, int left, int right) {
        int temp = list.get(left);
        list.set(left,list.get(right));
        list.set(right,temp);
    }

    private void sort(List<Integer> list, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = list.get(((left+right)/2));
        int partition = partition(list, left, right, pivot);
        sort(list, left, partition-1);
        sort(list, partition, right);
    }

    public void sort(List<Integer> list) {
        if(list.isEmpty()) {
            throw new IllegalArgumentException("array should not be empty");
        }
        sort(list, 0, list.size()-1);
    }

    public Boolean hasPreviousExpenditures(List<Integer> list, int trailingDays) {
        if(list.isEmpty()) {
            throw new IllegalArgumentException("array should not be empty");
        }
        if(list.size() > trailingDays) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public int notifications(List<Integer> expenditures, int trailingDays) {
        int notifications = 0;
        //int[] expendituresUnsorted = Arrays.copyOf(expenditures,expenditures.length);
        //List<Integer> expendituresUnsorted = new ArrayList<>(expenditures);
        //sort(expenditures);
        /* System.out.println(expendituresUnsorted.subList(0,20));
        System.out.println(expenditures.subList(0,20));*/

        if(!hasPreviousExpenditures(expenditures, trailingDays)) {
            return 0;
        }
        double median = 0.0;
        int expendituresSize = expenditures.size();
        List<Integer> subList = new ArrayList<>(expenditures.subList(0, trailingDays));
        countingSort(subList, 200);
        for (int i = trailingDays; i < expendituresSize; i++) {
            median = median(subList);
            median*=2.0;
            //System.out.println(median);
            double value = (double)expenditures.get(i);
            if(value >= median) {
                System.out.println(String.format("with median of %f (%f) and expenditure of %f", median*2.0,median,(double)expenditures.get(i)));
                notifications+=1;
                //System.out.println("Notifications: "+ notifications);
            }
            subList.remove(0);
            subList.add(expenditures.get(i));
            countingSort(subList, 200);
        }
        return notifications;
    }

    public static void countingSort(List<Integer> list, int k) {
        int counter[] = new int[k+1];
        Integer input[] = list.toArray(new Integer[list.size()]);
        for(int i: list){
            counter[i]++;
        }
        int ndx = 0;
        for (int i = 0; i < counter.length; i++) {
            while (0 < counter[i]) {
                input[ndx++] = i;
                counter[i]--;
            }
        }
        for (int i = 0; i < input.length; i++) {
            list.set(i, input[i]);
        }
    }

    public double median(List<Integer> expenditures, int expenseIndex, int trailingDays) {
        int left =  (expenseIndex - trailingDays);
        int right = (expenseIndex-1);
        if(trailingDays % 2 == 0) { //even
            int leftMiddle = expenditures.get((left+right)/2);
            int rightMiddle = expenditures.get(((left+right)/2)+1);
            return (leftMiddle+rightMiddle)/2.0;
        }
        return expenditures.get((left+right)/2); // odd
    }
}
