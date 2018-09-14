package chapter_1.exercise_2;

import java.util.HashMap;
import java.util.Map;

public class PermutationChecker {

    //ask the interviewer whether is case sensitive, whitespace sensitive permutation
    //ask about the character set

    public boolean isPermutation(String str1, String str2) {
        return isPermutationAsciiSet(str1, str2);
    }

    //O(n) time complexity
    //O(n) auxiliary space complexity
    //Unicode character set case
    private boolean isPermutationUnicodeSet(String str1, String str2) {
        if(str1 == null || str2 == null)
            throw new IllegalArgumentException();
        if(str1.length() != str2.length())
            return false;
        Map<Character, Integer> charCountStr1 = new HashMap<>();
        for(char c : str1.toCharArray()) {
            charCountStr1.merge(c, 1, (a, b) -> a + b);
        }
        for(char c : str2.toCharArray()) {
            if(charCountStr1.get(c) == null)
                return false;
            else
                charCountStr1.put(c, charCountStr1.get(c) - 1);
        }
        for (Integer count : charCountStr1.values()) {
            if(count != 0)
                return false;
        }
        return true;
    }

    //O(n) time complexity
    //O(1) auxiliary space complexity
    //ASCII character set case
    private boolean isPermutationAsciiSet(String str1, String str2) {
        if(str1 == null || str2 == null)
            throw new IllegalArgumentException();
        if(str1.length() != str2.length())
            return false;
        int[] set = new int[256];
        for(Character c : str1.toCharArray()) {
            set[c]++;
        }
        for(Character c : str2.toCharArray()) {
            if(--set[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
