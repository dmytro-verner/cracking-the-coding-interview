package chapter_1.exercise_9;

public class StringRotation {

    //O(n) time complexity
    //O(n) auxiliary space complexity
    public boolean isRotation(String s1, String s2) {
        if(s1 == null || s2 == null)
            throw new IllegalArgumentException("Any of input strings can't be null");

        if (s1.length() == s2.length() && s1.length() > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    //checked whether s2 is a substring of s1
    private boolean isSubstring(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(count))
                count++;
            else
                count = 0;
            if (count == s2.length())
                return true;
        }
        return false;
    }
}
