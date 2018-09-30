package chapter_3.exercise_3;

import chapter_3.exception.EmptyStackException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {

    private int singleStackLimit;
    private List<Stack<Integer>> stacks;

    SetOfStacks(int singleStackLimit) {
        stacks = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stacks.add(stack);
        this.singleStackLimit = singleStackLimit;
    }

    public void push(Integer data) {
        Stack<Integer> lastStack = getLastStack();
        if (lastStack.size() >= singleStackLimit) {
            Stack<Integer> newStack = new Stack<>();
            stacks.add(newStack);
            lastStack = newStack;
        }
        lastStack.push(data);
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException("Set of stacks is empty of elements.");
        Stack<Integer> lastStack = getLastStack();
        int result = lastStack.pop();
        if (lastStack.empty() && stacks.size() > 1) {
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
        return getLastStack().empty();
    }

    List<Stack<Integer>> getStacks() {
        List<Stack<Integer>> copy = new ArrayList<>(stacks.size());
        for (Stack<Integer> stack : stacks) {
            Stack<Integer> dataStack = new Stack<>();
            for (Integer data : stack) {
                dataStack.push(data);
            }
            copy.add(dataStack);
        }
        return copy;
    }

    private Stack<Integer> getLastStack() {
        return stacks.get(stacks.size() - 1);
    }
}
