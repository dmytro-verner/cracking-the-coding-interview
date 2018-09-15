package chapter_2.exercise_6;

import common.Node;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class PalindromeTest {

    private Palindrome palindrome;

    @Before
    public void setUp() {
        palindrome = new Palindrome();
    }

    private static Object[] palindrom(){
        return new Object[] {
                new Object[] { new int[] {1, 2, 3, 2, 1}},
                new Object[] { new int[] {1, 2, 2, 1}},
                new Object[] { new int[] {1, 1}},
                new Object[] { new int[] {1}},
        };
    }

    @Test
    @Parameters(method = "palindrom")
    public void palindromeIsIdentified(int[] testArr) {
        Node linkedList = new Node(testArr);
        assertTrue(palindrome.isPalindrome(linkedList));
    }

    private static Object[] nonPalindrome(){
        return new Object[] {
                new Object[] { new int[] {1, 2, 3, 2, 6}},
                new Object[] { new int[] {1, 1, 2, 2}},
                new Object[] { new int[] {1, 2}},
        };
    }

    @Test
    @Parameters(method = "nonPalindrome")
    public void nonPalindromeIdentified(int[] testArr) {
        Node linkedList = new Node(testArr);
        assertFalse(palindrome.isPalindrome(linkedList));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnNullLinkedList() {
        palindrome.isPalindrome(null);
    }
}
