package chapter_2.exercise_4;

import common.Node;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class PartitionerTest {

    private Partitioner partitioner;

    @Before
    public void setUp() {
        partitioner = new Partitioner();
    }

    private static Object[] validPartitions(){
        return new Object[] {
                new Object[] { new int[] {3, 5, 8, 5, 10, 2, 1}, -1, 0, 7},
                new Object[] { new int[] {3, 5, 8, 5, 10, 2, 1}, 2, 1, 7},
                new Object[] { new int[] {3, 5, 8, 5, 10, 2, 1}, 10, 6, 7},
                new Object[] { new int[] {3, 5, 8, 5, 10, 2, 1}, 11, 7, 7},
                new Object[] { new int[] {1}, 1, 0, 1},
                new Object[] { new int[] {1}, 2, 1, 1},
        };
    }

    @Test
    @Parameters(method = "validPartitions")
    public void validPartitionsGetPartitioned(int[] testArr, int pivot, int countOfNodesLessThanPivot, int size) {
        Node linkedList = new Node(testArr);

        Node partitioned = partitioner.partition(linkedList, pivot);

        assertTrue(firstNodesLessThan(partitioned, pivot, countOfNodesLessThanPivot));
        assertEquals(size, partitioned.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnNullLinkedList() {
        partitioner.partition(null, 0);
    }

    private boolean firstNodesLessThan(Node head, int pivot, int countOfNodesLessThanPivot) {
        int count = 0;
        while (head != null) {
            if (head.data >= pivot)
                break;
            count++;
            head = head.next;
        }
        return count == countOfNodesLessThanPivot;
    }
}
