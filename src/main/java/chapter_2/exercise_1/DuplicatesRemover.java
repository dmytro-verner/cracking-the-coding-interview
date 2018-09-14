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

        Node curr = head;
        set.add(curr.data);
        while (curr.next != null) {
            if (set.contains(curr.next.data)) {
                curr.next = curr.next.next;
            } else {
                set.add(curr.next.data);
                curr = curr.next;
            }
        }
    }

    //O(n^2) time complexity
    //O(1) auxiliary space complexity
    private void removeDuplicatesV2(Node head) {
        if (head == null)
            throw new IllegalArgumentException("Input node can't be null");

        Node curr = head;
        while (curr != null) {
            Node runner = curr;
            while (runner.next != null) {
                if (runner.next.data == curr.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
    }
}
