package chapter_2.exercise_4;

import common.Node;

public class Partitioner {

    public Node partition(Node head, int pivot) {
        return partitionV1(head, pivot);
    }

    //O(n) time complexity
    //O(n) auxiliary space complexity
    //stable version
    private Node partitionV1(Node head, int pivot) {
        if (head == null)
            throw new IllegalArgumentException("Input linked list can't be null");
        Node beforeBeg = null;
        Node afterBeg = null;
        Node beforeEnd = null;
        Node afterEnd = null;
        while (head != null) {
            if (head.data < pivot) {
                if (beforeEnd == null) {
                    beforeEnd = new Node(head.data);
                    beforeBeg = beforeEnd;
                } else {
                    beforeEnd.next = new Node(head.data);
                    beforeEnd = beforeEnd.next;
                }
            } else {
                if (afterEnd == null) {
                    afterEnd = new Node(head.data);
                    afterBeg = afterEnd;
                } else {
                    afterEnd.next = new Node(head.data);
                    afterEnd = afterEnd.next;
                }
            }
            head = head.next;
        }
        if (beforeBeg == null)
            return afterBeg;
        beforeEnd.next = afterBeg;
        return beforeBeg;
    }
}
