package chapter_1.exercise_8;

public class MatrixZeroer {

    //O(n^2) time complexity
    //O(n) auxiliary complexity
    public void zeroMatrix(int[][] matrix) {
        if (matrix == null)
            throw new IllegalArgumentException();
        int M = matrix.length;
        int N = matrix[0].length;

        boolean[] rows = new boolean[M];
        boolean[] cols = new boolean[N];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
