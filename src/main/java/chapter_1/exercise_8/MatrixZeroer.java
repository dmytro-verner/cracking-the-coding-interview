package chapter_1.exercise_8;

public class MatrixZeroer {

    public void zeroMatrix(int[][] matrix) {
        zeroMatrixV2(matrix);
    }

    //O(n^2) time complexity
    //O(n) auxiliary space complexity
    private void zeroMatrixV1(int[][] matrix) {
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

    //O(n^2) time complexity
    //O(1) auxiliary space complexity
    public void zeroMatrixV2(int[][] matrix) {
        if(matrix == null)
            throw new IllegalArgumentException("Input array can't be null");
        if(matrix.length == 0 || matrix[0].length == 0)
            return;

        boolean rowHasZero = false;
        boolean columnHasZero = false;

        //check the first row for zeroes
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        //check the first column for zeroes
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }

        //check for zeroes in the rest of the matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //nullify values based on zeroes in the first row
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0)
                nullifyRow(matrix, i);
        }

        //nullify columns based on the value in the first column
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        //nullify values in the first row
        if (rowHasZero)
            nullifyRow(matrix, 0);

        if (columnHasZero)
            nullifyColumn(matrix, 0);
    }

    private void nullifyRow(int[][] matrix, int rowIndex) {
        for (int i = 0; i < matrix[rowIndex].length; i++) {
            matrix[rowIndex][i] = 0;
        }
    }

    private void nullifyColumn(int[][] matrix, int columnIndex) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == columnIndex)
                    matrix[i][j] = 0;
            }
        }
    }
}
