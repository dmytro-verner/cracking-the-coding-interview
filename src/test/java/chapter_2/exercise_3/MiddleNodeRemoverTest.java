package chapter_2.exercise_3;

import common.Node;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class MiddleNodeRemoverTest {

    private MiddleNodeRemover middleNodeRemover;

    @Before
    public void setUp() {
        middleNodeRemover = new MiddleNodeRemover();
    }

    @Test
    public void middleElementGetsRemovedFromLinkedList() {
        Node linkedList = new Node(new int[] {1, 2, 3, 4});
        Node expectedLinkedList = new Node(new int[] {1, 3, 4});
        middleNodeRemover.deleteMiddleNode(linkedList);
        assertTrue(linkedList.linkedListEqualTo(expectedLinkedList));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnNullLinkedList() {
        middleNodeRemover.deleteMiddleNode(null);
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
        middleNodeRemover.deleteMiddleNode(linkedList);
    }
}
