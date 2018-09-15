package chapter_2.exercise_3;

import common.Node;

public class MiddleNodeRemover {

    //O(1) time complexity
    //O(1) auxiliary space complexity
    //deleted node between head and tail
    public void deleteMiddleNode(Node head) {
        if (head == null)
            throw new IllegalArgumentException("Input linked list's head can't be null");
        if (head.next == null || head.next.next == null)
            throw new IllegalArgumentException("Input linked list's size can't be less than 3");
        head.next = head.next.next;
    }
}
