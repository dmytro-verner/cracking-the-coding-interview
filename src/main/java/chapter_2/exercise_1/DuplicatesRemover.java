package chapter_2.exercise_1;

import java.util.HashSet;
import java.util.Set;
import common.Node;

public class DuplicatesRemover {

    public void removeDuplicates(Node head) {
        removeDuplicatesV2(head);
    }

    //O(n) time complexity
    //O(n) auxiliary space complexity
    private void removeDuplicatesV1(Node head) {
        if (head == null)
            throw new IllegalArgumentException("Input node can't be null");

        Set<Integer> set = new HashSet<>();

        set.add(head.data);
        while (head.next != null) {
            if (set.contains(head.next.data)) {
                head.next = head.next.next;
            } else {
                set.add(head.next.data);
                head = head.next;
            }
        }
    }

    //O(n^2) time complexity
    //O(1) auxiliary space complexity
    private void removeDuplicatesV2(Node head) {
        if (head == null)
            throw new IllegalArgumentException("Input node can't be null");

        while (head != null) {
            Node runner = head;
            while (runner.next != null) {
                if (runner.next.data == head.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            head = head.next;
        }
    }
}
