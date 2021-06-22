package sorting;

import java.util.List;

public class QuickSort {

    public static void sort(List<Integer> numbers) {
        sort(numbers, 0, numbers.size()-1);
    }

    public static void sort(List<Integer> numbers, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = numbers.get((right + left)/2);
        int index = partition(numbers, left, right, pivot);
        sort(numbers, left, index-1);
        sort(numbers, index, right);
    }

    private static int partition(List<Integer> numbers, int left, int right, int pivot) {
        while (left <= right) {
            while (numbers.get(left) < pivot) {
                left++;
            }
            while (numbers.get(right) > pivot) {
                right--;
            }
            if(left <= right) {
                swap(numbers, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(List<Integer> numbers, int left, int right) {
        int temp = numbers.get(left);
        numbers.set(left, numbers.get(right));
        numbers.set(right, temp);
    }


}
