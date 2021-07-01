package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxElement {

    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for(String operationStr: operations) {
            String[] operationSplit = operationStr.split(" ");
            int operation = Integer.valueOf(operationSplit[0]);
            switch (operation) {
                case 1: // add
                    int value = Integer.valueOf(operationSplit[1]);
                    stack.push(value);
                    break;
                case 2: // delete
                    stack.pop();
                    break;
                case 3:
                    result.add(stack.peek());
            }
        }
        return result;
    }
}
