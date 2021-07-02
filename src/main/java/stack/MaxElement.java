package stack;

import java.util.*;

public class MaxElement {

    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackResult = new Stack<>();
        for(String operationStr: operations) {
            String[] operationSplit = operationStr.split(" ");
            int operation = Integer.valueOf(operationSplit[0]);
            switch (operation) {
                case 1: // add
                    int value = Integer.valueOf(operationSplit[1]);
                    stack.push(value);
                    break;
                case 2: // delete
                    if(!stack.isEmpty())
                        stack.pop();
                    break;
                case 3: // print
                    stackResult.push(max(stack));
                    break;
            }
        }
        return stackResult;
    }

    public static int max(List<Integer> list) {
        int max = 0;
        int i = 0;
        if(list.size() % 2 == 0) {
            if(list.get(i) > list.get(i+1)) {
                max = list.get(i);
            } else {
                max = list.get(i+1);
            }
            i = 2;
        } else {
            max = list.get(i);
            i = 1;
        }

        while (i < list.size() - 1) {
            if(list.get(i) > list.get(i+1)) {
                if(list.get(i) > max) {
                    max = list.get(i);
                }
            } else {
                if(list.get(i+1) > max) {
                    max = list.get(i+1);
                }
            }
            i+=2;
        }
        return max;
    }
}
