package chapter_1.exercise_7;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

@RunWith(JUnitParamsRunner.class)
public class MatrixRotatorTest {

    private MatrixRotator matrixRotator = new MatrixRotator();

    @Test
    public void rotates2by2Matrix() {
        int[][] input = new int[][]{
            {1, 2},
            {3, 4}
        };
        int[][] expected = new int[][] {
            {3, 1},
            {4, 2}
        };
        matrixRotator.rotate(input);
        assertArrayEquals("Incorrectly rotates the array: " + Arrays.deepToString(input) + ", but expected: "
                + Arrays.deepToString(expected), expected, input);
    }

    @Test
    public void rotates3by3Matrix() {
        int[][] input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = new int[][] {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        matrixRotator.rotate(input);
        assertArrayEquals("Incorrectly rotates the array: " + Arrays.deepToString(input) + ", but expected: "
                + Arrays.deepToString(expected), expected, input);
    }

    @Test
    public void rotates4by4Matrix() {
        int[][] input = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] expected = new int[][] {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };
        matrixRotator.rotate(input);
        assertArrayEquals("Incorrectly rotates the array: " + Arrays.deepToString(input) + ", but expected: "
                + Arrays.deepToString(expected), expected, input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnNullArray() {
        matrixRotator.rotate(null);
    }

    private static Object[] emptyArray(){
        return new Object[] {
                new Object[] {new int[][]{ {}, {} }},
                new Object[] {new int[][]{ {} }},
                new Object[] {new int[][]{ {}, {}, {} }},
        };
    }

    @Test
    @Parameters(method = "emptyArray")
    public void rotatingEmptyArrayReturnsFalse(int[][] input) {
        assertFalse(matrixRotator.rotate(input));
    }

    private static Object[] arraysWithDifferentDimensions(){
        return new Object[] {
                new Object[] {new int[][] {{1, 2}, {1}}},
                new Object[] {new int[][] {{1, 2}, {}}},
                new Object[] {new int[][] {{}, {1}}},
        };
    }

    @Test
    @Parameters(method = "arraysWithDifferentDimensions")
    public void rotatingMatrixWithDifferentDimensionsReturnsFalse(int[][] input) {
        assertFalse(matrixRotator.rotate(input));
    }
}
