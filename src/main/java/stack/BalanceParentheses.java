package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalanceParentheses {
    public boolean isBalance(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean balance = true;
            for(char input: s.toCharArray()) {

                if(input == '(' || input == '{' || input == '[') {
                    stack.push(input);
                    continue;
                }

                if(stack.isEmpty()) {
                    balance = false;
                    System.out.println(balance);
                    return balance;
                }

                char lastString = stack.pop();
                switch(input) {
                    case ')':
                        if(lastString != '(') {
                            balance=false;
                        }
                        break;
                    case ']':
                        if(lastString != '[') {
                            balance=false;
                        }
                        break;
                    case '}':
                        if(lastString != '{') {
                            balance=false;
                        }
                        break;
                }

                if(!balance) {
                    return false;
                }
            }
            if(stack.isEmpty()) {
                return true;
            }
            return false;
    }
}
