package chapter_2.exercise_8;

import common.Node;

class LoopDetector {

    //O(n) time complexity
    Node getLoopBeginning(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break; //meeting point at abs(LOOP_SIZE - k) in the loop
        }

        if (fast == null || fast.next == null)
            return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
