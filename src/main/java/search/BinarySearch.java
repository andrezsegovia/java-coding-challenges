package search;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BinarySearch {

    public static boolean find(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid = left + ((right-left)/2);
            if(arr[mid] == toFind) {
                return true;
            } else if(toFind < arr[mid]) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static Optional findOptional(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid = left + ((right-left)/2);
            if(arr[mid] == toFind) {
                return Optional.of(mid);
            } else if(toFind < arr[mid]) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return Optional.empty();
    }

    public static Optional<Integer> linearSearch(int[] arr, int toFind) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == toFind) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public static Integer search(Map<Integer, Integer[]> elements, Integer element) {
        int left = 0;
        int right = elements.size()-1;
        while(left <= right) {
            int mid = left + ((right+left)/2);
            Integer[] elementFound = elements.get(mid);
            if(elementFound != null &&  elementFound[0] == element) {
                return elementFound[1];
            } else if(elementFound != null && element < elementFound[0]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return null;
    }
}
