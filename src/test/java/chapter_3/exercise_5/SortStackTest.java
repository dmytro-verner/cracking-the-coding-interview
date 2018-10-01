package chapter_3.exercise_5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortStackTest {

    private SortStack sortStack;

    @Before
    public void setUp() {
        sortStack = new SortStack();
    }

    @Test
    public void sortsMultipleElementsStack() {
        sortStack.push(1);
        sortStack.push(7);
        sortStack.push(9);
        sortStack.push(4);

        sortStack.sort();

        assertEquals(1, sortStack.pop());
        assertEquals(4, sortStack.pop());
        assertEquals(7, sortStack.pop());
        assertEquals(9, sortStack.pop());
        assertTrue(sortStack.isEmpty());
    }

    @Test
    public void sortsSingleElementStack() {
        sortStack.push(3);

        sortStack.sort();

        assertEquals(3, sortStack.pop());
        assertTrue(sortStack.isEmpty());
    }

    @Test
    public void sortsStackWithDuplicateElements() {
        sortStack.push(1);
        sortStack.push(4);
        sortStack.push(4);
        sortStack.push(3);
        sortStack.push(1);
        sortStack.sort();

        assertEquals(1, sortStack.pop());
        assertEquals(1, sortStack.pop());
        assertEquals(3, sortStack.pop());
        assertEquals(4, sortStack.pop());
        assertEquals(4, sortStack.pop());
        assertTrue(sortStack.isEmpty());
    }
}
