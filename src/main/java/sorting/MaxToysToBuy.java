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

    public int compute(List<Integer> prices, int budget) {
        QuickSort.sort(prices);
        int toysToBuy = 0;
        for(Integer price: prices) {
            if(price <= budget) {
                toysToBuy+=1;
                budget-=price;
            }
        }
        return toysToBuy;
    }
}
