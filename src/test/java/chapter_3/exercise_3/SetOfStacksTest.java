package chapter_3.exercise_3;

import chapter_3.exception.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SetOfStacksTest {

    private SetOfStacks setOfStacks;
    private SetOfStacks fullSetOfStacks;

    @Before
    public void setUp() {
        setOfStacks = new SetOfStacks(2);

        fullSetOfStacks = new SetOfStacks(2);
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
    public void newStackOnSetOfStacksCreation() {
        setOfStacks.push(1);
        setOfStacks.push(2);

        assertEquals(1, setOfStacks.getStacks().size());
    }

    @Test
    public void newStackIsNotCreatedOnAddingEqualToCurrentStackCapacity() {
        setOfStacks.push(1);
        setOfStacks.push(2);

        assertEquals(1, setOfStacks.getStacks().size());
    }

    @Test
    public void newStackCreatedOnAddingAboveCurrentStackCapacity() {
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        assertEquals(2, setOfStacks.getStacks().size());
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

    @Test
    public void getStacksReturnsDeepCopy() {
        List<Stack<Integer>> stacks = fullSetOfStacks.getStacks();
        stacks.get(1).pop();

        assertTrue(fullSetOfStacks.getStacks().get(1).peek() == 4);
    }
}
