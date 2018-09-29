package chapter_2.exercise_8;

import chapter_2.exercise_8.LoopDetector;
import common.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LoopDetectorTest {

    private LoopDetector loopDetector;

    @Before
    public void setUp() {
        loopDetector = new LoopDetector();
    }

    @Test
    public void detectsLoopBeginningNode() {
        Node node1 = new Node(new int[] {1, 2, 3});
        Node node2 = new Node(new int[] {4, 5, 6});
        node1.next.next.next = node2;
        node2.next.next.next = node1.next.next;

        assertEquals(3, loopDetector.getLoopBeginning(node1).data);
    }

    @Test
    public void detectsLoopBeginningNodeIn2NodesLoop() {
        Node node1 = new Node(new int[] {1});
        Node node2 = new Node(new int[] {2});
        node1.next = node2;
        node2.next = node1;

        assertEquals(1, loopDetector.getLoopBeginning(node1).data);
    }

    @Test
    public void detectsNoLoopInNonLoopingList() {
        Node node1 = new Node(new int[] {1, 2, 3});
        node1.next = new Node(new int[] {4, 5, 6, 7});

        assertNull(loopDetector.getLoopBeginning(node1));
    }
}
