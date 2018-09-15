package chapter_2.exercise_3;

import common.Node;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class ExactMiddleNodeRemoverTest {

    private ExactMiddleNodeRemover exactMiddleNodeRemover;

    @Before
    public void setUp() {
        exactMiddleNodeRemover = new ExactMiddleNodeRemover();
    }

    private static Object[] validSizeLinkedList(){
        return new Object[] {
                new Object[] { new int[] {1, 2, 3}, new int[] {1, 3}},
                new Object[] { new int[] {1, 2, 3, 4, 5, 6}, new int[] {1, 2, 4, 5, 6}},
        };
    }

    @Test
    @Parameters(method = "validSizeLinkedList")
    public void removesMiddleNodeInValidLinkedList(int[] testArr, int[] expectedArr) {
        Node inputLinkedList = new Node(testArr);
        Node expectedLinkedList = new Node(expectedArr);

        exactMiddleNodeRemover.deleteMiddleNode(inputLinkedList);

        assertTrue(inputLinkedList.linkedListEqualTo(expectedLinkedList));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnNullLinkedList() {
        exactMiddleNodeRemover.deleteMiddleNode(null);
    }

    private static Object[] invalidSizeLinkedList(){
        return new Object[] {
                new Object[] { new int[] {}},
                new Object[] { new int[] {1}},
                new Object[] { new int[] {1, 2}}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "invalidSizeLinkedList")
    public void throwsIAEOnInvalidSizeLinkedList(int[] testArr) {
        Node linkedList = new Node(testArr);
        exactMiddleNodeRemover.deleteMiddleNode(linkedList);
    }
}
