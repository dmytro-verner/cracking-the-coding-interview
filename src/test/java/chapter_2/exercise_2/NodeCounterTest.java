package chapter_2.exercise_2;

import common.Node;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class NodeCounterTest {

    private NodeCounter nodeCounter;

    @Before
    public void setUp() {
        nodeCounter = new NodeCounter();
    }

    private static Object[] validKthElementToLast(){
        return new Object[] {
                new Object[] { new int[] {1, 2, 3, 4, 5, 6}, 3, 3},
                new Object[] { new int[] {1, 2, 3, 4, 5, 6}, 0, 6},
                new Object[] { new int[] {1, 2, 3, 4, 5, 6}, 5, 1},
                new Object[] { new int[] {1}, 0, 1}
        };
    }

    @Test
    @Parameters(method = "validKthElementToLast")
    public void validKthElementReturned(int[] testArr, int k, int expectedData) {
        Node linkedList = new Node(testArr);
        Node r = nodeCounter.getKthToLast(linkedList, k);
        assertEquals(expectedData, r.data);
    }

    private static Object[] invalidKthElementToLast(){
        return new Object[] {
                new Object[] { new int[] {1, 2, 3, 4, 5, 6}, 6},
                new Object[] { new int[] {1, 2, 3, 4, 5, 6}, -1},
                new Object[] { new int[] {1}, 1}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "invalidKthElementToLast")
    public void IAEThrownOnInvalidKthElement(int[] testArr, int k) {
        Node linkedList = new Node(testArr);
        nodeCounter.getKthToLast(linkedList, k);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnNullLinkedList() {
        nodeCounter.getKthToLast(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void IAEOnEmptyArrayPassedToLinkedListCreation() {
        new Node(new int[] {});
    }
}
