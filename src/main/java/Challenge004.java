import com.sun.javaws.exceptions.InvalidArgumentException;

public class Challenge004 {
    /**
     * Get the median of a non-empty and ordered array on integers.
     * @param arr array of integers
     * @return {@code int} value that represents the median
     * @throws IllegalArgumentException when the array is null
     */
    public int median(int[] arr) {
        if(arr.length == 0) {
            throw new IllegalArgumentException("array should not be empty");
        }
        if(arr.length % 2 == 0) {
            int middleLeft = arr[(arr.length/2)-1];
            int middleRight = arr[arr.length/2];
            return (middleLeft+middleRight)/2;
        }
        return arr[(arr.length/2)];
    }
}
