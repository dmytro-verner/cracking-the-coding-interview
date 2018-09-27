package common;

//Singly linked list implementation
public class Node {
    public Node next;
    public int data;

    public Node() {
        next = null;
    }

    public Node(int d) {
        data = d;
    }

    public Node(int[] array) {
        if (array == null || array.length < 1)
            throw new IllegalArgumentException("Input array can't be null or empty");
        data = array[0];
        Node curr = this;
        for (int i = 1; i < array.length; i++) {
            curr.next = new Node(array[i]);
            curr = curr.next;
        }
    }

    public Node appendToTail(Node node) {
        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        return this;
    }

    public boolean linkedListEqualTo(Node head) {
        if (head == null)
            return false;
        Node thatNode = head;
        Node currNode = this;
        while (currNode.next != null && thatNode.next != null) {
            if (currNode.data != thatNode.data)
                return false;
            currNode = currNode.next;
            thatNode = thatNode.next;
        }
        if (currNode.next == null && thatNode.next == null)
            return true;
        else
            return false;
    }

    public int size() {
        int count = 1;
        Node curr = this;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public int backwardOrderSum() {
        int multiplier = 1;
        int acc = 0;
        int remainder = 0;
        Node head = this;
        while (head != null) {
            int val = head.data + remainder;
            acc += val * multiplier;
            if (val >= 10) {
                remainder = val / 10;
            } else {
                remainder = 0;
            }

            multiplier *= 10;
            head = head.next;
        }
        return acc;
    }

    public int forwardOrderSum() {
        int count = this.size();
        int multiplier = 1;
        while (--count > 0) {
            multiplier *= 10;
        }
        int acc = 0;
        Node head = this;
        while (head != null) {
            acc += head.data * multiplier;

            multiplier /= 10;
            head = head.next;
        }
        return acc;
    }


    @Override
    public boolean equals(Object node) {
        if (!(node instanceof Node))
            return false;
        Node head = (Node) node;
        Node curr1 = this;
        Node curr2 = head;
        while (curr1 != null && curr2 != null) {
            if (curr1.data != curr2.data)
                return false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1 == null && curr2 == null;
    }

    @Override
    public String toString() {
        Node curr = this;
        StringBuilder strBuilder = new StringBuilder();
        while (curr != null) {
            strBuilder.append(curr.data);
            if (curr.next != null)
                strBuilder.append(" -> ");
            curr = curr.next;
        }
        return strBuilder.toString();
    }
}
