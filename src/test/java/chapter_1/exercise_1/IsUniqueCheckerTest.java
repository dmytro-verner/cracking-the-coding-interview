package chapter_1.exercise_1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class IsUniqueCheckerTest {

    private IsUniqueChecker isUniqueChecker;

    @Before
    public void setUp() {
        isUniqueChecker = new IsUniqueChecker();
    }

    private static Object[] uniqueLowerCaseStrings(){
        return new Object[] {
                new Object[] {"marty"},
                new Object[] {"zxcvbnmasdfghjklqwertyuiop"}
        };
    }

    @Test
    @Parameters(method = "uniqueLowerCaseStrings")
    public void uniqueLowerCaseStringIsUnique(String str) {
        assertTrue( "The given string has duplicate characters: " + str, isUniqueChecker.isUnique(str));
    }

    @Test
    public void emptyStringIsUnique() {
        assertTrue(isUniqueChecker.isUnique(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullStringThrowsIAE() {
        assertTrue(isUniqueChecker.isUnique(null));
    }

    @Test
    public void duplicateCharactersStringIsNotUnique() {
        assertFalse(isUniqueChecker.isUnique("station"));
    }
}
