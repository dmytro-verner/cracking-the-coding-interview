package chapter_2.exercise_5;

import common.Node;

public class ListsSum {

    public int sumBackwardOrder(Node node1, Node node2) {
        return sumBackwardOrderListsRecursively(node1, node2, 0, 1);
    }

    //O(n+m) time complexity
    //O(1) auxiliary space complexity
    private int sumBackwardOrderIterativeV1(Node head1, Node head2) {
        int remainder = 0;
        int multiplier = 1;
        int accSum = 0;
        while (head1 != null && head2 != null) {
            int val1 = head1.data;
            int val2 = head2.data;
            int sum = (val1 + val2 + remainder);
            if (sum < 10) {
                remainder = 0;
            } else if (sum > 10) {
                remainder = sum / 10;
                sum = sum % 10;
            } else { //backwardOrderSum == 10 case
                sum = 0;
                remainder = 1;
            }
            accSum += sum * multiplier;

            head1 = head1.next;
            head2 = head2.next;
            multiplier *= 10;
        }
        if (head1 != null) {
            while (head1 != null) {
                accSum += ((remainder > 0 ? remainder * multiplier : 0) + head1.data * multiplier);
                remainder = 0;
                head1 = head1.next;
                multiplier *= 10;
            }
        } else if (head2 != null) {
            while (head2 != null) {
                accSum += ((remainder > 0 ? remainder * multiplier : 0) + head2.data * multiplier);
                remainder = 0;
                head2 = head2.next;
                multiplier *= 10;
            }
        } else {
            accSum += remainder * multiplier;
        }

        return accSum;
    }

    //O(n+m) time complexity
    //O(1) auxiliary space complexity
    private int sumBackwardOrderIterativeV2(Node head1, Node head2) {
        return head1.backwardOrderSum() + head2.backwardOrderSum();
    }

    private int sumBackwardOrderListsRecursively(Node head1, Node head2, int carry, int multiplier) {
        if (head1 == null && head2 == null && carry == 0)
            return 0;
        int value = carry;
        if (head1 != null)
            value += head1.data;
        if (head2 != null)
            value += head2.data;
        int result = (value % 10) * multiplier;

        if (head1 != null || head2 != null) {
            result += sumBackwardOrderListsRecursively(head1 == null ? null : head1.next,
                                                    head2 == null ? null : head2.next,
                                                    value >= 10 ? 1 : 0,
                                                    multiplier * 10);
        }
        return result;
    }

    //O(n+m) time complexity
    public int sumForwardOrderLists(Node head1, Node head2) {
        int length1 = head1.size();
        int length2 = head2.size();
        if (length1 > length2) {
            head2 = padList(head2, length1 - length2);
        } else if (length1 < length2) {
            head1 = padList(head1, length2 - length1);
        }

        PartialSum partialSum = sumListsHelper(head1, head2);

        if (partialSum.carry == 0) {
            return partialSum.sum.forwardOrderSum();
        } else {
            return insertBefore(partialSum.sum, partialSum.carry).forwardOrderSum();
        }
    }

    /**
     * Accepts equal length singly linked lists
     */
    private PartialSum sumListsHelper(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return new PartialSum();
        }
        PartialSum partialSum = sumListsHelper(head1.next, head2.next);

        int value = partialSum.carry + head1.data + head2.data;

        partialSum.sum = insertBefore(partialSum.sum, value % 10);
        partialSum.carry = value / 10;
        return partialSum;
    }

    private class PartialSum {
        Node sum;
        int carry;
    }

    private Node padList(Node head, int count) {
        for (int i = 0; i < count; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    private Node insertBefore(Node head, int data) {
        Node node = new Node(data);
        if (head == null)
            return node;
        node.next = head;
        return node;
    }
}
