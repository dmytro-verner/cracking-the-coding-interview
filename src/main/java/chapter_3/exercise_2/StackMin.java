package chapter_3.exercise_2;

import java.util.EmptyStackException;

class StackMin<T extends Comparable> {

    private StackNode<T> top;

    private static class StackNode<T extends Comparable> {
        T data;
        StackNode<T> next;
        T currMin;

        StackNode(T data) {
            this.data = data;
        }
    }

    T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        T result = top.data;
        top = top.next;
        return result;
    }

    void push(T data) {
        if (isEmpty()) {
            top = new StackNode<>(data);
            top.currMin = data;
        } else {
            StackNode<T> nextTop = new StackNode<>(data);
            nextTop.next = top;
            nextTop.currMin = top.currMin.compareTo(data) <= 0 ? top.currMin : data;
            top = nextTop;
        }
    }

    T min() {
        if (isEmpty())
            throw new EmptyStackException();
        return top.currMin;
    }

    boolean isEmpty() {
        return top == null;
    }
}

//The drawback is having to store integer in every node
