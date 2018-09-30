package chapter_3.exercise_4;

import java.util.Stack;

public class LazyQueueViaStacks {

    private Stack<Integer> oldest;
    private Stack<Integer> newest;

    LazyQueueViaStacks() {
        oldest = new Stack<>();
        newest = new Stack<>();
    }

    int dequeue() {
        if (!oldest.isEmpty()) {
            return oldest.pop();
        }
        moveToOldestStack();
        return oldest.pop();
    }

    void enqueue(int value) {
        newest.push(value);
    }

    private void moveToOldestStack() {
        while (!newest.isEmpty()) {
            oldest.push(newest.pop());
        }
    }

    int peek() {
        if (!oldest.isEmpty()) {
            return oldest.peek();
        }
        moveToOldestStack();
        return oldest.peek();
    }

    int size() {
        return oldest.size() + newest.size();
    }
}
