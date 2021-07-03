package stack;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class EqualStacksTest {

    Stack<Integer> h1;
    Stack<Integer> h2;
    Stack<Integer> h3;

    @Before
    public void setUp() throws Exception {
        h1 = new Stack<>();
        h2 = new Stack<>();
        h3 = new Stack<>();
    }

    @Test
    public void equalStackEmptyStacks() {
        int height = EqualStacks.equalStacks(h1,h2,h3);

        assertEquals(0, height);
    }

    @Test
    public void equalStackH1Empty() {
        h2.push(1);
        h3.push(1);

        int height = EqualStacks.equalStacks(h1,h2,h3);

        assertEquals(0, height);
    }

    @Test
    public void equalStackH2Empty() {
        h1.push(1);
        h3.push(1);

        int height = EqualStacks.equalStacks(h1,h2,h3);

        assertEquals(0, height);
    }

    @Test
    public void equalStackH3Empty() {
        h1.push(1);
        h2.push(1);

        int height = EqualStacks.equalStacks(h1,h2,h3);

        assertEquals(0, height);
    }

    @Test
    public void equalStackH2AndH3Empty() {
        h1.push(1);

        int height = EqualStacks.equalStacks(h1,h2,h3);

        assertEquals(0, height);
    }

    @Test
    public void equalStackH1andH3Empty() {
        h2.push(1);

        int height = EqualStacks.equalStacks(h1,h2,h3);

        assertEquals(0, height);
    }

    @Test
    public void equalStackH1andH2Empty() {
        h3.push(1);

        int height = EqualStacks.equalStacks(h1,h2,h3);

        assertEquals(0, height);
    }

    @Test
    public void equalStackAllStacksHaveSameHeight() {
        h1.push(1);
        h2.push(1);
        h3.push(1);

        int height = EqualStacks.equalStacks(h1,h2,h3);

        assertEquals(1, height);
    }

    @Test
    public void equalStackWhenH1IsOnceHigherThanH2AndH3() {
        h1.push(1);
        h1.push(1);
        h2.push(1);
        h3.push(1);

        int height = EqualStacks.equalStacks(h1,h2,h3);

        assertEquals(1, height);
    }

    @Test
    public void equalStackWhenH1IsTwiceHigherThanH2AndH3() {
        h1.push(1);
        h1.push(1);
        h1.push(1);
        h2.push(1);
        h3.push(1);

        int height = EqualStacks.equalStacks(h1,h2,h3);

        assertEquals(1, height);
    }

    @Test
    public void equalStack() {
        h1.push(1);
        h1.push(1);
        h1.push(2);
        h1.push(1);

        h2.push(2);
        h2.push(1);
        h2.push(1);

        h3.push(1);
        h3.push(1);

        int height = EqualStacks.equalStacks(h1,h2,h3);

        Collectors.toCollection(Stack::new);
        assertEquals(2, height);
    }

    @Test
    public void equalStackTwo() {
        h1.push(1);
        h1.push(1);
        h1.push(1);
        h1.push(2);
        h1.push(3);

        h2.push(2);
        h2.push(3);
        h2.push(4);

        h3.push(1);
        h3.push(4);
        h3.push(1);
        h3.push(1);

        int height = EqualStacks.equalStacks(h1,h2,h3);

        Collectors.toCollection(Stack::new);
        assertEquals(5, height);
    }

    @Test
    public void changeStackHeight() {
        int newHeight = 5;
        int currentHeight = 8;

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(2);


        currentHeight = EqualStacks.changeHeight(stack, currentHeight, newHeight);

        Stack<Integer> expectedStack = new Stack<>();
        expectedStack.push(3);
        expectedStack.push(2);
        assertEquals(currentHeight, newHeight);
        assertEquals(expectedStack, stack);
    }

}
