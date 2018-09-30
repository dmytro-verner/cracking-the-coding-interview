package chapter_3.exercise_2;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackMinWithMinsStackTest {

    private StackMinWithMinsStack<Integer> stackMin;

    @Before
    public void setUp() {
        stackMin = new StackMinWithMinsStack<>();
    }

    @Test
    public void singlePushedElementBecomesMin() {
        stackMin.push(4);
        assertEquals(4, stackMin.min().intValue());
    }

    @Test
    public void returnsNullOnGettingMinOnEmptyStack() {
        assertNull(stackMin.min());
    }

    @Test
    public void returnsMinWhenMinIsInTheEnd() {
        stackMin.push(3);
        stackMin.push(5);
        stackMin.push(8);

        assertEquals(3, stackMin.min().intValue());
    }

    @Test
    public void returnsMinWhenMinIsNotAtBounderies() {
        stackMin.push(9);
        stackMin.push(3);
        stackMin.push(7);

        assertEquals(3, stackMin.min().intValue());
    }

    @Test
    public void returnsMinWhenMinIsAtTheBeginning() {
        stackMin.push(5);
        stackMin.push(7);
        stackMin.push(2);

        assertEquals(2, stackMin.min().intValue());
    }

    @Test
    public void poppingReturnsLastPushedElementAfterTakingMinWhenItIsMin() {
        stackMin.push(4);
        stackMin.push(0);

        stackMin.min();
        assertEquals(0, stackMin.min().intValue());
    }

    @Test
    public void poppedMinIsReplacedWithNextMin() {
        stackMin.push(4);
        stackMin.push(3);
        stackMin.push(8);
        stackMin.push(1);
        stackMin.pop();

        assertEquals(3, stackMin.min().intValue());
    }

    @Test
    public void reutrnsNullOnGettingMinAfterAllElementsArePopped() {
        stackMin.push(3);
        stackMin.push(6);
        stackMin.pop();
        stackMin.pop();

        assertNull(stackMin.min());
    }

    @Test
    public void returnsMinWhenThereAreSeveralMinElements() {
        stackMin.push(3);
        stackMin.push(4);
        stackMin.push(3);
        stackMin.push(6);

        assertEquals(3, stackMin.min().intValue());
    }

    @Test
    public void createdStackIsEmpty() {
        assertTrue(stackMin.isEmpty());
    }

    @Test
    public void stackWithPushedElementsIsNotEmpty() {
        stackMin.push(1);
        assertFalse(stackMin.isEmpty());
    }

    @Test
    public void stackIsEmptyAfterPushAndPop() {
        stackMin.push(1);
        stackMin.pop();
        assertTrue(stackMin.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnPoppingEmptyStack() {
        stackMin.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnDoublePoppingSinglePushedElement() {
        stackMin.push(1);
        stackMin.pop();
        stackMin.pop();
    }

    @Test
    public void popsPushedElement() {
        stackMin.push(5);
        assertEquals(5, stackMin.pop().intValue());
    }

    @Test
    public void popsLastPushedElement() {
        stackMin.push(5);
        stackMin.push(6);
        assertEquals(6, stackMin.pop().intValue());
    }
}

