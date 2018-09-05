package chapter_1_arrays_and_strings.exercise_2_check_permutation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PermutationCheckerTest {

    private PermutationChecker permutationChecker;

    @Before
    public void setUp() {
        permutationChecker = new PermutationChecker();
    }

    @Test
    public void permutatedStringsArePermutated() {
        assertTrue(permutationChecker.isPermutation("abcd", "cbda"));
    }

    @Test
    public void notPermutatedStringsAreNotPermutated() {
        assertFalse(permutationChecker.isPermutation("abcd", "abdd"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnSecondStringBeingNull() {
        permutationChecker.isPermutation("abc", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnFirstStringBeingNull() {
        permutationChecker.isPermutation(null, "abc");
    }

    @Test
    public void emptyStringsArePermutatedStrings() {
        assertTrue(permutationChecker.isPermutation("", ""));
    }
}
