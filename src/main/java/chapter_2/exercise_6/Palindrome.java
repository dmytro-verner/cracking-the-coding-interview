package chapter_2.exercise_6;

import common.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class Palindrome {

    public boolean isPalindrome(Node head) {
        return isPalindromeV1(head);
    }

    //O(n) time complexity
    //O(n) auxiliary space complexity
    private boolean isPalindromeV1(Node head) {
        if (head == null)
            throw new IllegalArgumentException("Input linked list can't be null");

        Node slow = head;
        Node fast = head;
        Deque<Integer> deque = new ArrayDeque<>();
        while (fast != null && fast.next != null) {
            deque.addFirst(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        //odd size - need to skip one node
        if (fast != null)
            slow = slow.next;

        Node curr = slow;
        while (curr != null) {
            if (curr.data != deque.pop())
                return false;
            curr = curr.next;
        }
        return true;
    }

    //O(n) time complexity
    //O(n) auxiliary space complexity
    private boolean isPalindromeV2(Node head) {
        if (head == null)
            throw new IllegalArgumentException("Input linked list can't be null");

        Node reversed = reverseAndClone(head);
        return head.isEqual(reversed);
    }

    private Node reverseAndClone(Node node) {
        Node head = null;
        while (node != null) {
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }
}

//Another alternative solution with O(1) auxiliary space complexity is to use "runner technique":
//have to pointer to the linked list p1 and p2
//p1 points to the first element and p2 runs to the end thus providing the current linked list's size
//move p1 to the next node and run p2 to the node before the last and so on