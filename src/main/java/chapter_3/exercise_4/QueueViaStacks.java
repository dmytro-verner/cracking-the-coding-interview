package chapter_3.exercise_4;

import java.util.Stack;

class QueueViaStacks {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    QueueViaStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    int dequeue() {
        return stack1.pop();
    }

    void enqueue(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    int peek() {
        return stack1.peek();
    }

    int size() {
        return stack1.size() + stack2.size();
    }
}

//The major drowback is that we needlessly move elements back and forth on every enqueue
//Another way to implement it is to use lazy approach: store first element in the first stack and all the other in
//the second one. Move elements from stack2 upon dequeue operation - thus costing O(n) to reverse all the elements
//but this operation won't be needed to be performed as long as there are elements in the first stack.

