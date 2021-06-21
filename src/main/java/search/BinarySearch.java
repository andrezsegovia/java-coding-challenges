package search;

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

    public static boolean findNormal(int[] arr, int toFind) {
        for(int item: arr) {
            if(item == toFind) {
                return true;
            }
        }
        return false;
    }
}
