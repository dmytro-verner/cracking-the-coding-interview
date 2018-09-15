package chapter_2.exercise_3;

import common.Node;

public class ExactMiddleNodeRemover {

    //O(n) time complexity
    //O(1) auxiliary space complexity
    //deletes node at exactly middle position
    public void deleteMiddleNode(Node head) {
        if (head == null)
            throw new IllegalArgumentException("Input linked list's head can't be null");
        int size = head.size();
        if (size < 3)
            throw new IllegalArgumentException("Input linked list can't have size less than 3");
        int count = 1;
        Node curr = head;
        Node prev = null;
        while (curr.next != null) {
            if (count == size / 2) {
                if (prev == null) { //the first node in linked list
                    curr.next = curr.next.next;
                } else {
                    prev.next = curr.next;
                }
            }
            prev = curr;
            curr = curr.next;
            count++;
        }
    }
}
