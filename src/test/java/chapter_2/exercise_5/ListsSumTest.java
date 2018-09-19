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

    private static Object[] validBackOrderLists() {
        return new Object[] {
                new Object[] { new int[]{1}, new int[]{3}, 4},
                new Object[] { new int[]{7}, new int[]{3}, 10},
                new Object[] { new int[]{7}, new int[]{4}, 11},

                new Object[] { new int[]{1, 2}, new int[]{3, 1}, 34},
                new Object[] { new int[]{8, 2}, new int[]{3, 1}, 41},
                new Object[] { new int[]{8, 8}, new int[]{3, 1}, 101},
                new Object[] { new int[]{8, 8}, new int[]{3, 2}, 111},
                new Object[] { new int[]{9, 9}, new int[]{9, 9}, 198},
                new Object[] { new int[]{0, 2}, new int[]{0, 8}, 100},
                new Object[] { new int[]{0, 2}, new int[]{0, 9}, 110},

                new Object[] { new int[]{1, 2}, new int[]{2, 9, 3}, 413},
                new Object[] { new int[]{1}, new int[]{2, 9, 3}, 393},
                new Object[] { new int[]{9, 9, 9}, new int[]{9}, 1008},

                new Object[] { new int[]{9, 8, 9}, new int[]{9, 7, 8}, 1868}
        };
    }

    @Test
    @Parameters(method = "validBackOrderLists")
    public void validLinkedListsBackwardOrderSummingCorrect(int[] arr1, int[] arr2, int expectedSum) {
        Node node1 = new Node(arr1);
        Node node2 = new Node(arr2);
        assertEquals(expectedSum, listsSum.sumBackwardOrder(node1, node2));
    }
}
