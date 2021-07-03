package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class EqualStacks {

    public static int calculateStackHeight(List<Integer> stack) {
        return stack.stream().collect(Collectors.summingInt(Integer::intValue));
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        int h1Height = calculateStackHeight(h1);
        int h2Height = calculateStackHeight(h2);
        int h3Height = calculateStackHeight(h3);

        if (h1Height == 0 || h2Height == 0 || h3Height == 0) {
            return 0;
        }

        while (h1Height != h2Height || h1Height != h3Height) {

            int h1AndH2Difference = h1Height - h2Height;
            int h1AndH3Difference = h1Height - h3Height;

            if(h1AndH2Difference > 0) {
                h1Height = changeHeight((Stack<Integer>) h1, h1Height, h2Height);
            } else if (h1AndH2Difference < 0){
                h2Height = changeHeight((Stack<Integer>) h2, h2Height, h1Height);
            } else if(h1AndH3Difference > 0) {
                h1Height = changeHeight((Stack<Integer>) h1, h1Height, h3Height);
            } else if (h1AndH3Difference < 0){
                h3Height = changeHeight((Stack<Integer>) h3, h3Height, h1Height);
            }
        }

        return h1Height;
    }

    public static int changeHeight(Stack<Integer> stack,
                                    int currentHeight, int newHeight) {
        int currentHeightTemp = currentHeight;
        Stack<Integer> stackTemp = (Stack<Integer>) stack.clone();
        while (currentHeight > newHeight) {
            currentHeight -= stackTemp.pop();
        }
        if(currentHeight == newHeight){
            stack.clear();
            stack.addAll(stackTemp);
            return currentHeight;
        }
        return currentHeightTemp;
    }
}
