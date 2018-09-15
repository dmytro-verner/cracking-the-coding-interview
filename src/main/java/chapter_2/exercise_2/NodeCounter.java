package chapter_2.exercise_2;

import common.Node;

public class NodeCounter {

    //O(n) time complexity
    //O(1) auxiliary space complexity
    public Node getKthToLast(Node head, int k) {
        if (head == null)
            throw new IllegalArgumentException("Input linked list can't be null");
        int size = head.size();
        int count = 0;
        if (k >= size || k < 0)
            throw new IllegalArgumentException("Parameter of k can't be bigger than linked list size or less than 0");
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
}
