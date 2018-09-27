package chapter_2.exercise_5;

import common.Node;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ListsSumTest {

    private ListsSum listsSum;

    @Before
    public void setUp() {
        listsSum = new ListsSum();
    }

    private static Object[] validBackwardOrderLists() {
        return new Object[] {
                new Object[] { new Node(new int[]{1}), new Node(new int[]{3}), 4},
                new Object[] { new Node(new int[]{7}), new Node(new int[]{3}), 10},
                new Object[] { new Node(new int[]{7}), new Node(new int[]{4}), 11},

                new Object[] { new Node(new int[]{1, 2}), new Node(new int[]{3, 1}), 34},
                new Object[] { new Node(new int[]{8, 2}), new Node(new int[]{3, 1}), 41},
                new Object[] { new Node(new int[]{8, 8}), new Node(new int[]{3, 1}), 101},
                new Object[] { new Node(new int[]{8, 8}), new Node(new int[]{3, 2}), 111},
                new Object[] { new Node(new int[]{9, 9}), new Node(new int[]{9, 9}), 198},
                new Object[] { new Node(new int[]{0, 2}), new Node(new int[]{0, 8}), 100},
                new Object[] { new Node(new int[]{0, 2}), new Node(new int[]{0, 9}), 110},

                new Object[] { new Node(new int[]{1, 2}), new Node(new int[]{2, 9, 3}), 413},
                new Object[] { new Node(new int[]{1}), new Node(new int[]{2, 9, 3}), 393},
                new Object[] { new Node(new int[]{9, 9, 9}), new Node(new int[]{9}), 1008},

                new Object[] { new Node(new int[]{9, 8, 9}), new Node(new int[]{9, 7, 8}), 1868}
        };
    }

    @Test
    @Parameters(method = "validBackwardOrderLists")
    public void validLinkedListsBackwardOrderSummingCorrect(Node node1, Node node2, int result) {
        assertEquals(result, listsSum.sumBackwardOrder(node1, node2));
    }

    private static Object[] validForwardOrderLists() {
        return new Object[] {
                new Object[] { new Node(new int[]{1}), new Node(new int[]{3}), 4},
                new Object[] { new Node(new int[]{7}), new Node(new int[]{3}), 10},
                new Object[] { new Node(new int[]{7}), new Node(new int[]{4}), 11},

                new Object[] { new Node(new int[]{1, 2}), new Node(new int[]{3, 1}), 43},
                new Object[] { new Node(new int[]{8, 2}), new Node(new int[]{3, 1}), 113},
                new Object[] { new Node(new int[]{8, 8}), new Node(new int[]{3, 1}), 119},
                new Object[] { new Node(new int[]{8, 8}), new Node(new int[]{3, 2}), 120},
                new Object[] { new Node(new int[]{9, 9}), new Node(new int[]{9, 9}), 198},
                new Object[] { new Node(new int[]{2, 0}), new Node(new int[]{8, 0}), 100},
                new Object[] { new Node(new int[]{2, 0}), new Node(new int[]{9, 0}), 110},

                new Object[] { new Node(new int[]{1, 2}), new Node(new int[]{2, 9, 3}), 305},
                new Object[] { new Node(new int[]{1}), new Node(new int[]{2, 9, 3}), 294},
                new Object[] { new Node(new int[]{9, 9, 9}), new Node(new int[]{9}), 1008},

                new Object[] { new Node(new int[]{9, 8, 9}), new Node(new int[]{9, 7, 8}), 1967}
        };
    }

    @Test
    @Parameters(method = "validForwardOrderLists")
    public void validLinkedListsForwardOrderSummingCorrect(Node node1, Node node2, int result) {
        assertEquals(result, listsSum.sumForwardOrderLists(node1, node2));
    }
}
