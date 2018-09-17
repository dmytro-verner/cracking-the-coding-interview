package chapter_2.exercise_4;

import common.Node;

public class Partitioner {

    public Node partition(Node head, int pivot) {
        return partitionV3(head, pivot);
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

    //O(n) time complexity
    //O(1) auxiliary space complexity
    private Node partitionV2(Node node, int pivot) {
        if (node == null)
            throw new IllegalArgumentException("Input linked list can't be null");
        Node head = node;
        Node tail = node;
        while (node != null) {
            Node next = node.next;
            if (node.data < pivot) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    //O(n) time complexity
    //O(1) auxiliary space complexity
    private Node partitionV3(Node node, int pivot) {
        if (node == null)
            throw new IllegalArgumentException("Input linked list can't be null");
        Node curr = node;
        Node p = node;
        while (curr != null) {
            if (curr.data < pivot) {
                int temp = p.data;
                p.data = curr.data;
                curr.data = temp;

                p = p.next;
            }
            curr = curr.next;
        }
        return node;
    }
}
