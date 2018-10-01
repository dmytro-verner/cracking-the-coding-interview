package chapter_3.exercise_5;

import java.util.Stack;

public class SortStack {

    private Stack<Integer> primary;

    SortStack() {
        primary = new Stack<>();
    }

    public void push(int data) {
        primary.push(data);
    }

    public int pop() {
        return primary.pop();
    }

    public int peek() {
        return primary.peek();
    }

    public void sort() {
        Stack<Integer> sortedDesc = new Stack<>();

        while (!primary.isEmpty()) {
            int sorting = primary.pop();
            while (!sortedDesc.isEmpty() && sortedDesc.peek() > sorting) {
                primary.push(sortedDesc.pop());
            }
            sortedDesc.push(sorting);
        }
        while (!sortedDesc.isEmpty()) {
            primary.push(sortedDesc.pop());
        }
    }

    public int size() {
        return primary.size();
    }

    public boolean isEmpty() {
        return primary.size() == 0;
    }
}
