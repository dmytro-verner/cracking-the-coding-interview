package chapter_2.exercise_2;

import common.Node;

public class NodeCounter {

    public Node kthToLast(Node head, int k) {
        return kthToLastV1(head, k);
    }

    //O(n) time complexity
    //O(1) auxiliary space complexity
    private Node kthToLastV1(Node head, int k) {
        if (head == null)
            throw new IllegalArgumentException("Input linked list can't be null");
        int size = head.size();
        int count = 0;
        if (k >= size || k < 0)
            return null;
        Node curr = head;
        while (curr.next != null) {
            if (size - 1 - k == count) {
                return curr;
            }
            curr = curr.next;
            count++;
        }
        return curr; //then it's the last node in the linked list
    }

    //O(n) time complexity
    //O(1) auxiliary space complexity
    private Node kthToLastV2(Node head, int k) {
        if (head == null)
            throw new IllegalArgumentException("Input linked list can't be null");
        Node p1 = head;
        Node p2 = head;

        //move p1 k + 1 elements ahead
        for (int i = 0; i <= k; i++) {
            if (p1 == null)
                return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
