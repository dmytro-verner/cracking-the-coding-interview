package chapter_3.exercise_1;

import chapter_3.exception.FullStackException;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ThreeInOne {

    private int stackCapacity;
    private int numberOfStacks = 3;
    private int[] values;
    private int[] sizes;

    ThreeInOne(int stackCapacity) {
        if (stackCapacity < 1) {
            throw new IllegalArgumentException("Stack capacity can't be less than 1, but was " + stackCapacity);
        }
        this.stackCapacity = stackCapacity;
        values = new int[numberOfStacks * stackCapacity];
        sizes = new int[numberOfStacks];
    }

    void push(int stackNum, int val) {
        if (stackNum < 0 || stackNum >= 3)
            throw new IllegalArgumentException("Wrong stack number, should have been 0-2 but was " + stackNum);
        if (isFull(stackNum)) {
            throw new FullStackException("No available space in a stack with number "
                    + stackNum);
        }
        int stackOffset = sizes[stackNum] + stackCapacity * stackNum;
        values[stackOffset] = val;
        sizes[stackNum]++;
    }

    int pop(int stackNum) {
        if (stackNum < 0 || stackNum >= 3)
            throw new IllegalArgumentException("Wrong stack number, should have been 0-2 but was " + stackNum);
        if (isEmpty(stackNum))
            throw new EmptyStackException();
        int stackOffset = (sizes[stackNum] - 1) + stackCapacity * stackNum;
        int result = values[stackOffset];
        values[stackOffset] = 0;
        sizes[stackNum]--;
        return result;
    }

    int peek(int stackNum) {
        if (stackNum < 0 || stackNum >= 3)
            throw new IllegalArgumentException("Wrong stack number, should have been 0-2 but was " + stackNum);
        if (isEmpty(stackNum))
            throw new EmptyStackException();
        int stackOffset = (sizes[stackNum] - 1) + stackCapacity * stackNum;
        return values[stackOffset];
    }

    int[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    boolean isFull(int stackNum) {
        return sizes[stackNum] + 1 > values.length / 3;
    }
}
