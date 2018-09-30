package chapter_3.exercise_3.follow_up;

import chapter_3.exception.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SetOfStacksFollowUpTest {
    private SetOfStacksFollowUp setOfStacks;
    private SetOfStacksFollowUp fullSetOfStacks;

    @Before
    public void setUp() {
        setOfStacks = new SetOfStacksFollowUp(2);

        fullSetOfStacks = new SetOfStacksFollowUp(2);
        fullSetOfStacks.push(1);
        fullSetOfStacks.push(2);
        fullSetOfStacks.push(3);
        fullSetOfStacks.push(4);
        fullSetOfStacks.push(5);
        fullSetOfStacks.push(6);
    }

    @Test
    public void pushedElementIsPeekedInFirstStack() {
        setOfStacks.push(4);

        assertEquals(4, setOfStacks.peek());
    }

    @Test
    public void pushedElementIsPoppedFromFirstStack() {
        setOfStacks.push(3);

        assertEquals(3, setOfStacks.pop());
    }

    @Test
    public void poppedElementAfterPushingAndPeekingInTheFirstStack() {
        setOfStacks.push(2);
        setOfStacks.peek();

        assertEquals(2, setOfStacks.pop());
    }

    @Test
    public void pushingElementsAboveFirstStackAddsToSecondStack() {
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);

        assertEquals(5, setOfStacks.peek());
    }

    @Test
    public void pushedElementAfterFSEThrownAndPopOperationIsInStack() {
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.pop();

        setOfStacks.push(10);
        assertEquals(10, setOfStacks.peek());
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnPeekingEmptyStack() {
        setOfStacks.peek();
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnPoppingEmptyStack() {
        setOfStacks.pop();
    }

    @Test
    public void popsMostRecentElement() {
        setOfStacks.push(3);
        setOfStacks.push(6);
        setOfStacks.push(2);

        assertEquals(2, setOfStacks.pop());
    }

    @Test
    public void emptyWithNoPushHistoryStackIsEmpty() {
        setOfStacks.isEmpty();
    }

    @Test
    public void emptyStackWithPushHistoryStackIsEmpty() {
        setOfStacks.push(3);
        setOfStacks.pop();
        setOfStacks.isEmpty();
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnPoppingByIndexFromFirstStack() {
        setOfStacks.popAt(0);
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnPoppingByIndexFromSecondStackWhenStackIsEmpty() {
        setOfStacks.popAt(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnPoppingByIndexFromSecondStackWhenFirstStackIsFull() {
        setOfStacks.push(1);
        setOfStacks.push(2);

        setOfStacks.popAt(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnPoppingByIndexFromSecondStackWhenOneFirstHasElements() {
        setOfStacks.push(1);
        setOfStacks.push(2);

        setOfStacks.popAt(1);
    }

    @Test
    public void poppingFromFirstStackRollsDownNextStacks() {
        fullSetOfStacks.popAt(0);
        List<Stack> stacks = fullSetOfStacks.getStacks();

        assertEquals(2, stacks.get(0).size);
        assertEquals(2, stacks.get(1).size);
        assertEquals(1, stacks.get(2).size);

        assertEquals(3, fullSetOfStacks.getStacks().get(0).peek());
        assertEquals(6, fullSetOfStacks.getStacks().get(2).peek());
    }

    @Test
    public void multipleRollDownsGetElementsRolledDownByOneStack() {
        fullSetOfStacks.popAt(1);
        fullSetOfStacks.popAt(1);
        List<Stack> stacks = fullSetOfStacks.getStacks();

        assertEquals(2, stacks.size());
        assertEquals(6, stacks.get(1).peek());
    }
}

