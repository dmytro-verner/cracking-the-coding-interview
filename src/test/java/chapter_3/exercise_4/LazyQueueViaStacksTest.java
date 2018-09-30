package chapter_3.exercise_4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LazyQueueViaStacksTest {

    private LazyQueueViaStacks lazyQueueViaStacks;

    @Before
    public void setUp() { lazyQueueViaStacks = new LazyQueueViaStacks(); }

    @Test
    public void firstInFirstOutPrincipleAppliedForNonEqualElements() {
        lazyQueueViaStacks.enqueue(1);
        lazyQueueViaStacks.enqueue(2);

        assertEquals(1, lazyQueueViaStacks.dequeue());
    }

    @Test
    public void firstInFirstOutPrincipleAppliedForEqualElements() {
        lazyQueueViaStacks.enqueue(1);
        lazyQueueViaStacks.enqueue(2);
        lazyQueueViaStacks.enqueue(1);
        lazyQueueViaStacks.dequeue();

        assertEquals(2, lazyQueueViaStacks.dequeue());
    }

    @Test
    public void sizeOfEmptyQueueIsZero() {
        assertEquals(0, lazyQueueViaStacks.size());
    }

    @Test
    public void sizeOfEmptyQueueIsZeroAfterAddAndRemoveOperations() {
        lazyQueueViaStacks.enqueue(1);
        lazyQueueViaStacks.dequeue();

        assertEquals(0, lazyQueueViaStacks.size());
    }

    @Test
    public void peekReturnsFirstAddedElement() {
        lazyQueueViaStacks.enqueue(1);
        lazyQueueViaStacks.enqueue(2);

        assertEquals(1, lazyQueueViaStacks.peek());
    }

    @Test
    public void peekDoesNotRemoveElementFromQueue() {
        lazyQueueViaStacks.enqueue(1);
        lazyQueueViaStacks.peek();

        assertEquals(1, lazyQueueViaStacks.size());
    }
}
