package chapter_3.exercise_3.follow_up;

import chapter_3.exception.EmptyStackException;

public class Stack {

    private DoubleWayNode top, bottom;
    private int capacity;
    int size;

    Stack(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity can't be less than 1 but was " + capacity);
        this.capacity = capacity;
    }

    public boolean push(int data) {
        if (isFull())
            return false;
        DoubleWayNode node = new DoubleWayNode(data);
        if (isEmpty()) {
            bottom = node;
        } else {
            bottom.next = node;
        }
        if (top != null) {
            top.next = node;
            node.prev = top;
        }
        top = node;
        size++;
        return true;
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException("The stack is empty to pop elements.");
        int result = top.data;
        top = top.prev;
        size--;
        return result;
    }

    int removeBottom() {
        DoubleWayNode b = bottom;
        bottom = bottom.next;
        if (bottom != null) {
            bottom.prev = null;
        }
        size--;
        return b.data;
    }

    int peek() {
        if (isEmpty())
            throw new EmptyStackException("The stack is empty to pop elements.");
        return top.data;
    }

    private boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() { return size;}
}
