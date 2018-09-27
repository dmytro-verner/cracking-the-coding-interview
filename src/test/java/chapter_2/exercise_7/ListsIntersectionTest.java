package chapter_2.exercise_7;

import common.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListsIntersectionTest {

    private ListsIntersection listsIntersection;

    @Before
    public void setUp() {
        listsIntersection = new ListsIntersection();
    }

    @Test
    public void intersectedWithSeveralSameNodesAreIntersected() {
        Node head1 = new Node(new int[] {1, 2, 3});
        Node head2 = head1.next;
        Node expectedNode = head1.next;
        assertEquals(expectedNode, listsIntersection.intersectionNode(head1, head2));
    }

    @Test
    public void intersectedWithSameLastNodeAreIntersected() {
        Node head1 = new Node(new int[] {1, 2, 3});
        Node head2 = head1.next.next;
        Node expectedNode = head2;
        assertEquals(expectedNode, listsIntersection.intersectionNode(head1, head2));
    }

    @Test
    public void notIntersectedWithEqualLastNodeValueAreNotIntersected() {
        Node head1 = new Node(new int[] {1, 2, 3});
        Node head2 = new Node(new int[] {3});
        assertNull(listsIntersection.intersectionNode(head1, head2));
    }
}
