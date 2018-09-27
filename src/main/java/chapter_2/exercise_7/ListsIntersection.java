package chapter_2.exercise_7;

import common.Node;

class ListsIntersection {

    //O(n+m) time complexity
    Node intersectionNode(Node head1, Node head2) {
        Result result1 = getSizeAndTail(head1);
        Result result2 = getSizeAndTail(head2);

        if (result1.tail != result2.tail)
            return null;

        Node shorter = result1.size < result2.size ? head1 : head2;
        Node longer = result1.size > result2.size ? head1 : head2;

        longer = offsetNode(longer, Math.abs(result1.size - result2.size));
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter;
    }

    private Result getSizeAndTail(Node node) {
        int count = 0;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        return new Result(node, ++count);
    }

    private Node offsetNode(Node node, int offset) {
        while (--offset >= 0) {
            node = node.next;
        }
        return node;
    }

    private class Result {
        Node tail;
        int size;

        Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }
}
