package sorting;

import java.util.List;
// https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
public class MaxToysToBuy {

    public List<Integer> insertionSort(List<Integer> numbers) {
        long initTime = System.nanoTime();
        int numberSize = numbers.size();
        for(int i = 1; i < numberSize; i++) {
            int currentValue = numbers.get(i);
            int prevPosition = i-1;
            while( prevPosition >= 0 && numbers.get(prevPosition) > currentValue) {
                numbers.set(prevPosition+1, numbers.get(prevPosition));
                prevPosition--;
            }
            numbers.set(prevPosition+1, currentValue);
        }
        long endTime = System.nanoTime();
        System.out.println(String.format("Total time: %d", (endTime - initTime)));
        return numbers;
    }

    public List<Integer> bubbleSort(List<Integer> numbers) {
        long initTime = System.nanoTime();
        int numbersSize = numbers.size();
        for(int i = 0; i < numbersSize-1; i+=1 ){
            for(int j = 0; j < numbersSize-i-1; j+=1) {
                if(numbers.get(j) > numbers.get(j+1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j+1));
                    numbers.set(j+1, temp);
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println(String.format("Total time: %d", (endTime - initTime)));
        return numbers;
    }

    private void swap(List<Integer> numbers, int i, int j) {
        System.out.println("Swapping "+ numbers.get(i) +" at "+ i +" by "+ numbers.get(j) +" at "+ j );
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);

    }
    // 1, 12, 5, 111, 1000, 200, 10*
    private int partition(List<Integer> numbers, int low, int high) {
        int pivot = numbers.get(high);
        System.out.println("pi = " + pivot ) ;
        int i = (low-1);
        System.out.println("i = " + i ) ;
        for(int j = low; j <= high; j+=1) {
            System.out.println("j = " + j ) ;
            if(numbers.get(j) < pivot) {
                i+=1;
                swap(numbers, i, j);
            }
        }
        swap(numbers, i+1, high);
        System.out.println(numbers);
        return (i+1);
    }
    public List<Integer> quicksort(List<Integer> numbers, int low, int high) {
        if(low < high) {
            int partition = partition(numbers, low, high);
            System.out.println("partition="+partition);
            quicksort(numbers, low, partition-1);
            quicksort(numbers, partition+1, high);
        }
        return numbers;
    }
    public int compute(List<Integer> prices, int budget) {
        List<Integer> sortedPrices = quicksort(prices, 0, prices.size()-1);
        int toysToBuy = 0;
        for(Integer price: sortedPrices) {
            if(price <= budget) {
                toysToBuy+=1;
                budget-=price;
            }
        }
        return toysToBuy;
    }
}
