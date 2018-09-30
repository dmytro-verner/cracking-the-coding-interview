package chapter_3.exercise_3.follow_up;

import chapter_3.exception.EmptyStackException;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacksFollowUp {

    private int singleStackLimit;
    private List<Stack> stacks;

    SetOfStacksFollowUp(int singleStackLimit) {
        this.singleStackLimit = singleStackLimit;
        stacks = new ArrayList<>();
        Stack stack = new Stack(singleStackLimit);
        stacks.add(stack);
    }

    public void push(Integer data) {
        Stack lastStack = getLastStack();
        if (lastStack.getSize() >= singleStackLimit) {
            Stack newStack = new Stack(singleStackLimit);
            stacks.add(newStack);
            lastStack = newStack;
        }
        lastStack.push(data);
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException("Set of stacks is empty of elements.");
        Stack lastStack = getLastStack();
        int result = lastStack.pop();
        if (lastStack.isEmpty() && stacks.size() > 1) {
            stacks.remove(stacks.size() - 1);
        }
        return result;
    }

    int peek() {
        if (isEmpty())
            throw new EmptyStackException("Set of stacks is empty of elements.");

        return getLastStack().peek();
    }

    public boolean isEmpty() {
        return getLastStack().isEmpty(); //!!! test for null after whole deletion
    }

    private Stack getLastStack() {
        return stacks.get(stacks.size() - 1);
    }

    int popAt(int stackIndex) {
        if (stacks.isEmpty() || stacks.get(0).isEmpty())
            throw new EmptyStackException("Stack is empty to pop elements.");
        if (stackIndex < 0 || stackIndex > stacks.size() - 1) {
            throw new IllegalArgumentException("Stack index should be between 0-"
                    + (stacks.size() - 1) + ", but was " + stackIndex);
        }
        return leftShift(stackIndex, true);
    }

    private int leftShift(int stackIndex, boolean popTop) {
        Stack currShiftingStack = stacks.get(stackIndex);
        int poppedData;
        if (popTop) {
            poppedData = currShiftingStack.pop();
        } else {
            poppedData = currShiftingStack.removeBottom();
        }
        if (currShiftingStack.isEmpty()) {
            stacks.remove(stackIndex);
        } else if (stacks.size() > stackIndex + 1) {
            int otherStackPoppedValue = leftShift(stackIndex + 1, false);
            currShiftingStack.push(otherStackPoppedValue);
        }
        return poppedData;
    }

    List<Stack> getStacks() {
        return stacks;
    }
}