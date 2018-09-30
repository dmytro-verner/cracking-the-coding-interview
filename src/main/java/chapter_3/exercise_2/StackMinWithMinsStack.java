package chapter_3.exercise_2;

import java.util.Stack;

public class StackMinWithMinsStack<T extends Comparable> extends Stack<T> {
    private Stack<T> min;

    StackMinWithMinsStack() {
        min = new Stack<>();
    }

    public T push(T data) {
        if (min.empty())
            min.push(data);
        else if (data.compareTo(min()) <= 0)
            min.push(data);
        return super.push(data);
    }

    public T pop() {
        T data = super.peek();
        if (data.compareTo(min()) == 0) {
            min.pop();
        }
        return super.pop();
    }

    T min() {
        if (this.isEmpty())
            return null;
        else
            return min.peek();
    }
}
