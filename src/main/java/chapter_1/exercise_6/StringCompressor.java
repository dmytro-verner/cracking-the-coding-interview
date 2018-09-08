package chapter_1.exercise_6;

public class StringCompressor {

    public String compress(String str) {
        if (str == null)
            throw new IllegalArgumentException();
        if (str.equals(""))
            return "";
        int compressedLength = compressedLength(str);
        if (compressedLength >= str.length())
            return str;
        StringBuilder compressed = new StringBuilder(compressedLength);

        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    private int compressedLength(String str) {
        int compressedLength = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 2;
            }
        }
        return compressedLength;
    }
}
