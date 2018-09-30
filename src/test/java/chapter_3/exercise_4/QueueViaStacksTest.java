package chapter_3.exercise_4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueViaStacksTest {

    private QueueViaStacks queueViaStacks;

    @Before
    public void setUp() { queueViaStacks = new QueueViaStacks(); }

    @Test
    public void firstInFirstOutPrincipleAppliedForNonEqualElements() {
        queueViaStacks.enqueue(1);
        queueViaStacks.enqueue(2);

        assertEquals(1, queueViaStacks.dequeue());
    }

    @Test
    public void firstInFirstOutPrincipleAppliedForEqualElements() {
        queueViaStacks.enqueue(1);
        queueViaStacks.enqueue(2);
        queueViaStacks.enqueue(1);
        queueViaStacks.dequeue();

        assertEquals(2, queueViaStacks.dequeue());
    }

    @Test
    public void sizeOfEmptyQueueIsZero() {
        assertEquals(0, queueViaStacks.size());
    }

    @Test
    public void sizeOfEmptyQueueIsZeroAfterAddAndRemoveOperations() {
        queueViaStacks.enqueue(1);
        queueViaStacks.dequeue();

        assertEquals(0, queueViaStacks.size());
    }

    @Test
    public void peekReturnsFirstAddedElement() {
        queueViaStacks.enqueue(1);
        queueViaStacks.enqueue(2);

        assertEquals(1, queueViaStacks.peek());
    }

    @Test
    public void peekDoesNotRemoveElementFromQueue() {
        queueViaStacks.enqueue(1);
        queueViaStacks.peek();

        assertEquals(1, queueViaStacks.size());
    }
}
