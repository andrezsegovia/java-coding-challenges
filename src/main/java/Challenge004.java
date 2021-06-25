import java.util.Arrays;

public class Challenge004 {
    /**
     * Get the median of a non-empty and ordered array on integers.
     * @param arr array of integers
     * @return {@code int} value that represents the median
     * @throws IllegalArgumentException when the array is null
     */
    public double median(int[] arr) {
        if(arr.length == 0) {
            throw new IllegalArgumentException("array should not be empty");
        }
        if(arr.length % 2 == 0) {
            int middleLeft = arr[(arr.length/2)-1];
            int middleRight = arr[arr.length/2];
            return (middleLeft+middleRight)/2.0;
        }
        return arr[(arr.length/2)];
    }

    private int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if(left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private void sort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = arr[((left+right)/2)];
        int partition = partition(arr, left, right, pivot);
        sort(arr, left, partition-1);
        sort(arr, partition, right);
    }

    public void sort(int[] arr) {
        if(arr.length == 0) {
            throw new IllegalArgumentException("array should not be empty");
        }
        sort(arr, 0, arr.length-1);
    }

    public boolean hasPreviousExpenditures(int[] expenditures, int trailingDays) {
        if(expenditures.length == 0) {
            throw new IllegalArgumentException("array should not be empty");
        }
        if(expenditures.length > trailingDays) {
            return true;
        }
        return false;
    }

    public int notifications(int[] expenditures, int trailingDays) {
        int notifications = 0;
        int[] expendituresUnsorted = Arrays.copyOf(expenditures,expenditures.length);
        sort(expenditures);
        System.out.println(Arrays.toString(expendituresUnsorted));
        System.out.println(Arrays.toString(expenditures));
        if(!hasPreviousExpenditures(expenditures, trailingDays)) {
            return 0;
        }
        for (int i = trailingDays; i < expenditures.length ; i++) {
            int[] previousExpenditures = new int[trailingDays];
            System.arraycopy(expenditures, i-trailingDays, previousExpenditures, 0, trailingDays);
            System.out.println(Arrays.toString(previousExpenditures));
            System.out.println(expendituresUnsorted[i]);
            double median = median(previousExpenditures);
            System.out.println(median*2);
            if(expendituresUnsorted[i] >= (median*2)) {
                notifications++;
            }
        }
        return notifications;
    }
}
