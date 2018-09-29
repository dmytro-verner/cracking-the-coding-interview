package chapter_3.exercise_1;

import chapter_3.exception.FullStackException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.EmptyStackException;

import static com.googlecode.catchexception.CatchException.catchException;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ThreeInOneTest {

    private ThreeInOne threeInOne;

    @Before
    public void setUp() {
        threeInOne = new ThreeInOne(3);
    }

    @Test
    public void pushedElementAtBeginningOfFirstStackIsThere() {
        threeInOne.push(0, 1);

        assertEquals(1, threeInOne.getValues()[0]);
    }

    @Test
    public void pushedElementToTheEndOfTheFirstStackIsThere() {
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.push(0, 3);

        assertEquals(3, threeInOne.getValues()[2]);
    }

    @Test(expected = FullStackException.class)
    public void throwsFSEOnPushingElementBeyondFirstStack() {
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.push(0, 3);
        threeInOne.push(0, 4);
    }

    @Test
    public void pushedElementAtBeginningOfSecondStackIsThere() {
        threeInOne.push(1, 1);

        assertEquals(1, threeInOne.getValues()[3]);
    }

    @Test
    public void pushingElementAtTheBeginningOfSecondStackIsThereAfterFSEInFirstStack() {
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.push(0, 3);

        catchException(() -> threeInOne.push(0, 4));
        threeInOne.push(1, 5);

        assertEquals(5, threeInOne.getValues()[3]);
    }

    @Test
    public void pushedElementAtBeginningOfThirdStackIsThere() {
        threeInOne.push(2, 1);

        assertEquals(1, threeInOne.getValues()[6]);
    }

    @Test
    public void pushedElementAtTheEndOfThirdStackIsThere() {
        threeInOne.push(2, 1);
        threeInOne.push(2, 2);
        threeInOne.push(2, 3);

        assertEquals(3, threeInOne.getValues()[8]);
    }

    @Test(expected = FullStackException.class)
    public void throwsFSEOnPushingElementBeyondThirdStack() {
        threeInOne.push(2, 1);
        threeInOne.push(2, 2);
        threeInOne.push(2, 3);
        threeInOne.push(2, 4);
    }

    private static Object[] beyongThreeInOneStackIndexes(){
        return new Object[] {
                new Object[] { -1},
                new Object[] { 3}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "beyongThreeInOneStackIndexes")
    public void throwsIAEOnPushingToBeyondRangeStackIndex(int stackIndex) {
        threeInOne.push(stackIndex, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnTryingToCreateStackWithZeroCapacity() {
        threeInOne = new ThreeInOne(0);
    }

    @Test
    public void pushedAndThenPoppedElementInTheFirstStackIsNotThere() {
        threeInOne.push(0, 1);
        threeInOne.pop(0);

        assertNotEquals(1, threeInOne.getValues()[0]);
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnPoppingOnEmptyFirstStack() {
        threeInOne.pop(0);
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnPoppingOnEmptySecondStackWhenFirstIsFull() {
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.push(0, 3);
        threeInOne.pop(1);
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnPoppingFromEmptyFirstStackWhenThirdIsFull() {
        threeInOne.push(2, 1);
        threeInOne.push(2, 2);
        threeInOne.push(2, 3);
        threeInOne.pop(0);
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnPoppingOneElementTwoTimes() {
        threeInOne.push(0, 1);
        threeInOne.pop(0);
        threeInOne.pop(0);
    }

    @Test
    public void pushedElementIsThereAfterPoppingOnSameEmptyStack() {
        catchException(() -> threeInOne.pop(0));
        threeInOne.push(0, 1);
        assertEquals(1, threeInOne.getValues()[0]);
    }

    @Test
    public void pushedElementIsThereAfterPoppedBorderElement() {
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.push(0, 3);
        threeInOne.pop(0);
        threeInOne.push(0, 4);

        assertEquals(4, threeInOne.getValues()[2]);
    }

    @Test
    public void multipleTimesPeekingElementAtFirstStackGivesSameElement() {
        threeInOne.push(0, 1);
        assertEquals(1, threeInOne.peek(0));
        assertEquals(1, threeInOne.peek(0));
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnPeekingEmptyStack() {
        threeInOne.peek(0);
    }

    @Test
    public void peekingReturnsLastAvailableElementAfterPop() {
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.pop(0);

        assertEquals(1, threeInOne.peek(0));
    }

    @Test(expected = EmptyStackException.class)
    public void throwsESEOnPeekingAtEmptySecondStackWhenFirstIsFull() {
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.push(0, 3);
        threeInOne.peek(1);
    }

    @Test(expected = FullStackException.class)
    public void throwsESEOnPushingElementBeyondLimitAfterPeek() {
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.push(0, 3);
        threeInOne.peek(0);
        threeInOne.push(0, 4);
    }

    @Test
    public void emptyStackSecondStackIsEmptyWhenFirstIsFull() {
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.push(0, 3);
        assertTrue(threeInOne.isEmpty(1));
    }

    @Test
    public void nonEmptyStackIsNotEmptyStack() {
        threeInOne.push(0, 1);
        assertFalse(threeInOne.isEmpty(0));
    }

    @Test
    public void oneOffToFullStackIsNotFullStack() {
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);

        assertFalse(threeInOne.isFull(0));
    }

    @Test
    public void fullStackIsFullStack() {
        threeInOne.push(0, 1);
        threeInOne.push(0, 2);
        threeInOne.push(0, 3);

        assertTrue(threeInOne.isFull(0));
    }
}
