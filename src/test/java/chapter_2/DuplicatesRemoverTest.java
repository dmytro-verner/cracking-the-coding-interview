package chapter_2;

import chapter_2.exercise_1.DuplicatesRemover;
import common.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DuplicatesRemoverTest {

    private DuplicatesRemover duplicatesRemover;

    @Before
    public void setUp() {
        duplicatesRemover = new DuplicatesRemover();
    }

    @Test
    public void duplicatedElementsGetRemoved() {
        Node linkedList = new Node(new int[] {3, 3, 3, 5, 9, 4, 1, 4});
        Node expectedLinkedList = new Node(new int[] {3, 5, 9, 4, 1});
        duplicatesRemover.removeDuplicates(linkedList);
        assertTrue(linkedList.linkedListEqualTo(expectedLinkedList));
    }

    @Test
    public void listWithAllElementsTheSameGetsClearedExceptOneNode() {
        Node linkedList = new Node(new int[] {1, 1, 1, 1});
        Node expectedLinkedList = new Node(new int[] {1});
        duplicatesRemover.removeDuplicates(linkedList);
        assertTrue(linkedList.linkedListEqualTo(expectedLinkedList));
    }

    @Test
    public void oneElementLinkedListRemainsUnchanged() {
        Node linkedList = new Node(new int[] {1});
        Node expectedLinkedList = new Node(new int[] {1});
        duplicatesRemover.removeDuplicates(linkedList);
        assertTrue(linkedList.linkedListEqualTo(expectedLinkedList));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnNullLinkedList() {
        Node linkedList = null;
        Node expectedLinkedList = null;
        duplicatesRemover.removeDuplicates(linkedList);
        assertTrue(linkedList.linkedListEqualTo(expectedLinkedList));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnEmptyLinkedList() {
        Node linkedList = new Node(new int[] {});
        Node expectedLinkedList = new Node(new int[] {});
        duplicatesRemover.removeDuplicates(linkedList);
        assertTrue(linkedList.linkedListEqualTo(expectedLinkedList));
    }
}
