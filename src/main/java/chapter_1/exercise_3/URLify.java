package chapter_1.exercise_3;

public class URLify {

    //O(n) time complexity
    //O(1) auxiliary space complexity
    private void toURLHelper(char[] str, int trueLength) {
        //count number of spaces
        int spacesCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ')
                spacesCount++;
        }
        // replace each space with %20
        if (spacesCount > 0) {
            int index = trueLength - 1 + spacesCount * 2; // adds an additional 2 spots for each space

            if (trueLength < str.length)
                str[trueLength] = '\0';
            for (int i = trueLength - 1; i >= 0; i--) {
                // inserts %20 in place of space
                if (str[i] == ' ')
                {
                    str[index] = '0';
                    str[index - 1] = '2';
                    str[index - 2] = '%';
                    index = index - 3;
                } else {
                    str[index] = str[i];
                    index--;
                }
            }
        }
    }

    public String toUrl(String str, int trueLength) {
        char[] chars = str.toCharArray();
        toURLHelper(chars, trueLength);
        return new String(chars);
    }
}
