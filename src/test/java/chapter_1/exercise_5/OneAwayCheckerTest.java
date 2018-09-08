package chapter_1.exercise_5;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class OneAwayCheckerTest {

    private OneAwayChecker oneAwayChecker;

    @Before
    public void setUp() {
        oneAwayChecker = new OneAwayChecker();
    }

    @Test
    public void validOneAwayStringsPairWithInsertToEquality() {
        assertTrue(oneAwayChecker.isOneEditAwayFromEquality("pale", "ple"));
    }

    @Test
    public void validOneAwayStringsPairWithDeleteToEquality() {
        assertTrue(oneAwayChecker.isOneEditAwayFromEquality("pales", "pale"));
    }

    @Test
    public void validOneAwayStringsPairWithReplaceToEquality() {
        assertTrue(oneAwayChecker.isOneEditAwayFromEquality("pale", "bale"));
    }

    @Test
    public void invalidOneAwayStringsPairIdentifiedCorrectly() {
        assertFalse(oneAwayChecker.isOneEditAwayFromEquality("pale", "bake"));
    }

    @Test
    public void validOneAwayStringsPairWhenTwoEqualStrings() {
        assertTrue(oneAwayChecker.isOneEditAwayFromEquality("pale", "pale"));
    }

    private static Object[] validOneAwayWithOneEmptyStringParameter(){
        return new Object[] {
                new Object[] {"a", ""},
                new Object[] {"", "a"},
        };
    }

    @Test
    @Parameters(method = "validOneAwayWithOneEmptyStringParameter")
    public void validOneAwayStringsWhenStringOneIsEmpty(String str1, String str2) {
        assertTrue(oneAwayChecker.isOneEditAwayFromEquality(str1, str2));
    }

    private static Object[] invalidOneAwayWithOneEmptyStringParameter(){
        return new Object[] {
                new Object[] {"ab", ""},
                new Object[] {"", "ab"},
        };
    }

    @Test
    @Parameters(method = "invalidOneAwayWithOneEmptyStringParameter")
    public void invalidOneAwayStringsWhenStringOneIsEmpty(String str1, String str2) {
        assertFalse(oneAwayChecker.isOneEditAwayFromEquality(str1, str2));
    }

    private static Object[] invalidOneAwayWithNullParameters(){
        return new Object[] {
                new Object[] {"a", null},
                new Object[] {null, "ab"},
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "invalidOneAwayWithNullParameters")
    public void throwsIAEOneAnyParameterBeingNull(String str1, String str2) {
        oneAwayChecker.isOneEditAwayFromEquality(str1, str2);
    }
}
