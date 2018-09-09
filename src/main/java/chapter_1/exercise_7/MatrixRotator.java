package chapter_1.exercise_7;

import java.util.Arrays;

public class MatrixRotator {

    public boolean rotate(int[][] matrix) {
        if (matrix == null)
            throw new IllegalArgumentException();
        if (matrix.length == 0)
            return false;
        for (int[] el : matrix) {
            if (matrix.length != el.length)
                return false;
        }
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int first = layer;
            int last = matrix.length - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;

                int temp = matrix[first][i];
                //left -> top
                matrix[first][i] = matrix[last - offset][first];
                //bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                //right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                //top -> right
                matrix[i][last] = temp;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        new MatrixRotator().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
