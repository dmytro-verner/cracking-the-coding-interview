package chapter_1_arrays_and_strings.exercise_4_palindrome_permutation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromePermutationTest {

    private PalindromePermutation palindromePermutation;

    @Before
    public void setUp() {
        palindromePermutation = new PalindromePermutation();
    }

    @Test
    public void stringThatHasPalindromePermutationCorrectlyChecked() {
        assertTrue(palindromePermutation.isPermutationPalindrome("taco cat"));
    }

    @Test
    public void stringThatNotPalindromePermutationCorrectlyChecked() {
        assertFalse(palindromePermutation.isPermutationPalindrome("aco cat"));
    }

    @Test
    public void emptyStringIsPalindromePermutation() {
        assertTrue(palindromePermutation.isPermutationPalindrome(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnNullString() {
        palindromePermutation.isPermutationPalindrome(null);
    }
}
