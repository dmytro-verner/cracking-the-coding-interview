package chapter_1_arrays_and_strings.exercise_5_one_away;

public class OneAwayChecker {

    public boolean isOneEditAwayFromEquality(String str1, String str2) {
        return isOneEditAwayFromEqualityV2(str1, str2);
    }

    //O(n) time complexity
    //O(1) auxiliary complexity
    private boolean isOneEditAwayFromEqualityV1(String str1, String str2) {
        if (str1 == null || str2 == null)
            throw new IllegalArgumentException();
        if (Math.abs(str1.length() - str2.length()) > 1)
            return false;

        String shorterStr = str1.length() < str2.length() ? str1 : str2;
        String longerStr = str1.length() < str2.length() ? str2 : str1;

        int index1 = 0;
        int index2 = 0;
        boolean alreadyFoundDifference = false;
        while (index2 < longerStr.length() && index1 < shorterStr.length()) {
            if (shorterStr.charAt(index1) != longerStr.charAt(index2)) {
                if (alreadyFoundDifference) {
                    return false;
                }
                alreadyFoundDifference = true;
                if (shorterStr.length() == longerStr.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

//    //O(n) time complexity
//    //O(1) auxiliary complexity
    private boolean isOneEditAwayFromEqualityV2(String str1, String str2) {
        if (str1 == null || str2 == null)
            throw new IllegalArgumentException();
        if (Math.abs(str1.length() - str2.length()) > 1)
            return false;

        boolean foundDifference = false;
        //replace character - equal strings' length case
        if (str1.length() == str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    if(foundDifference)
                        return false;
                    else
                        foundDifference = true;
                }
            }
            return true;
        }

        String shorterStr = str1.length() < str2.length() ? str1 : str2;
        String longerStr = str1.length() > str2.length() ? str1 : str2;

        //insert & delete character cases
        for (int i = 0, j = 0; i < shorterStr.length();) {
            if (shorterStr.charAt(i) != longerStr.charAt(j)) {
                if(foundDifference) {
                    return false;
                } else {
                    foundDifference = true;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }

        return true;
    }

    //Q: What's the brute force algorithm for this problem
    //A: To have 3 for loops with respective inner loops.
    // In each section to check for all cases of removal/adding/replacing(with all the characters from the current character set)
    // a character and checking for equality
    // It'd be O(n^2)
}
