package common;

//Singly linked list implementation
public class Node {
    public Node next;
    public int data;

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

    public void appendToTail(Node node) {
        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
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
}
