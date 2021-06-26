import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        double result;
        if(size % 2 == 0) {
            int middleLeft = list.get((size/2)-1);
            int middleRight = list.get(size/2);
            result = (Double.sum(middleLeft,middleRight)/2.0d);
        }
        result = Double.valueOf(list.get(size/2));
        System.out.println(String.format("median is %.00f for:", result));
        System.out.println(list);
        return result;
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
        List<Integer> expendituresUnsorted = new ArrayList<>(expenditures);
        sort(expenditures);
        //System.out.println(expendituresUnsorted);
        //System.out.println(Arrays.toString(expenditures));
        if(!hasPreviousExpenditures(expenditures, trailingDays)) {
            return 0;
        }
        for (int i = trailingDays; i < expenditures.size() ; i++) {
            List<Integer> previousExpenditures = expenditures.subList((i-trailingDays), i);
            //System.out.println(previousExpenditures);
           // System.out.println(expendituresUnsorted[i]);
            double median = median(previousExpenditures);
            //System.out.println(median*2);
            if(Double.compare((double)expendituresUnsorted.get(i),(median*2.0)) >= 0) {
                //System.out.println(String.format("with median of %f (%f) and expenditure of %f", median*2.0,median,(double)expendituresUnsorted.get(i)));
                notifications++;
                //System.out.println("Notifications: "+ notifications);
            }
        }
        return notifications;
    }
}
