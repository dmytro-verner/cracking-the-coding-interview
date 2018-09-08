package chapter_1.exercise_1;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class IsUniqueChecker {

    public boolean isUnique(String str) {
        return isUniqueBitSetFlag(str);
    }

    //O(n) time complexity
    //O(n) space complexity
    //handles Unicode character set encoding of the input parameter
    private boolean isUniqueUnicode(String str) {
        if (str == null)
            throw new IllegalArgumentException();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i)))
                return false;
            set.add(str.charAt(i));
        }
        return true;
    }

    //O(1) time complexity
    //O(1) space complexity
    //uses limited ASCII character set of size 128, but using extended ASCII character set of size 256 is possible
    private boolean isUniqueAsciiLimited(String str) {
        if (str == null)
            throw new IllegalArgumentException();
        int limitedAsciiSize = 128;
        if (str.length() > limitedAsciiSize)
            return false;
        boolean[] asciiSet = new boolean[limitedAsciiSize];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (asciiSet[val])
                return false;
            asciiSet[val] = true;
        }
        return true;
    }

    //O(1) time complexity
    //O(1) space complexity
    //we assume str contains only a-z characters
    private boolean isUniqueIntFlag(String str) {
        if (str == null)
            throw new IllegalArgumentException();
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0)
                return false;
            checker |= (1 << val);
        }
        return true;
    }

    //O(1) time complexity
    //O(1) space complexity
    //assume str contains only a-z characters
    private boolean isUniqueBitSetFlag(String str) {
        if (str == null)
            throw new IllegalArgumentException();
        BitSet checker = new BitSet(32);
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if (checker.get(val))
                return false;
            checker.set(val);
        }
        return true;
    }
}
//Q:  If we couldn't use any additional data structure?
//A1: Just brute-force the algorithm with O(n^2) of time complexity and O(1) of space complexity by comparing all the pairs
//A2: Modify the string by sorting it(which takes O(nlogn) of time complexity and can take
//    from O(1) or O(n) of space complexity depending on the sorting algorithm.
//    Then linearly compare whether neighboring elements are equal