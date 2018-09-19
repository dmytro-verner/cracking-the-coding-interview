package chapter_2.exercise_5;

import common.Node;

public class ListsSum {

    public int sumBackwardOrder(Node node1, Node node2) {
        return sumBackwardOrderIterativeV1(node1, node2);
    }

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
            } else { //sum == 10 case
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
}
