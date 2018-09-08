package chapter_1.exercise_4;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    //assume English alphabet character set
    //O(n) time complexity
    //O(1) auxiliary space
    public boolean isPermutationPalindrome(String str) {
        if(str == null)
            throw new IllegalArgumentException();

        String withoutSpacesStr = str.replaceAll("\\s", "");

        Map<Character, Integer> characterFrequencyMap = new HashMap<>(26);
        for (char c : withoutSpacesStr.toCharArray()) {
            if (Character.isLetter(c)) {
                characterFrequencyMap.merge(c, 1, Integer::sum);
            }
        }
        int exceptionsTally = (withoutSpacesStr.length() % 2 == 0) ? 0 : 1;
        for (Integer value : characterFrequencyMap.values()) {
            if(value % 2 != 0)
                exceptionsTally--;
            if (exceptionsTally < 0)
                return false;
        }
        return true;
    }
}
