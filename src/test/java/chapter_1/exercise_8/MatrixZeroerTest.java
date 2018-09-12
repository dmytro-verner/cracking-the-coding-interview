package chapter_1.exercise_8;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnitParamsRunner.class)
public class MatrixZeroerTest {

    private MatrixZeroer matrixZeroer;

    @Before
    public void setUp() {
        matrixZeroer = new MatrixZeroer();
    }

    private Object[][] validNxNMatrixWithZeroAndNonZeros() {
        return new Object[][]{
                new Object[]{
                        new int[][]{
                                {1, 0, 2, 3},
                                {3, 2, 3, 3},
                                {5, 1, 0, 0},
                                {1, 5, 9, 0}
                        },
                        new int[][]{
                                {0, 0, 0, 0},
                                {3, 0, 0, 0},
                                {0, 0, 0, 0},
                                {0, 0, 0, 0}
                        }
                },
                new Object[]{
                        new int[][]{
                                {0, 1},
                                {3, 4},
                        },
                        new int[][]{
                                {0, 0},
                                {0, 4},
                        }
                }
        };
    }

    @Test
    @Parameters(method = "validNxNMatrixWithZeroAndNonZeros")
    public void validNxNMatrixForZeroingGetsZeroed(int[][] input, int[][] expected) {
        matrixZeroer.zeroMatrix(input);
        assertArrayEquals(expected, input);
    }

    private Object[][] differentDimensionsMatrixWithZerosAndNonZeroes() {
        return new Object[][]{
                new Object[]{
                        new int[][]{
                                {1},
                                {0},
                                {5},
                                {1}
                        },
                        new int[][]{
                                {0},
                                {0},
                                {0},
                                {0}
                        }
                },
                new Object[]{
                        new int[][]{
                                {0, 2, 3, 6}
                        },
                        new int[][]{
                                {0, 0, 0, 0}
                        }
                },
                new Object[]{
                        new int[][]{
                                {0, 1, 4, 9},
                                {3, 4, 3, 2}
                        },
                        new int[][]{
                                {0, 0, 0, 0},
                                {0, 4, 3, 2}
                        }
                }
        };
    }

    @Test
    @Parameters(method = "differentDimensionsMatrixWithZerosAndNonZeroes")
    public void differentDimensionsMatrixForZeroingGetZeroed(int[][] input, int[][] expected) {
        matrixZeroer.zeroMatrix(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void matrixWithoutZeroesGetsZeroedOut() {
        int[][] expected = new int[][] {
                {1, 2},
                {4, 1}
        };
        int[][] inputCopy = copyOf(expected);
        matrixZeroer.zeroMatrix(inputCopy);
        assertArrayEquals(expected, inputCopy);
    }

    @Test
    public void oneElementArrayRemainsUnchanged() {
        int[][] expected = new int[][]{
                {0}
        };
        int[][] inputCopy = copyOf(expected);
        matrixZeroer.zeroMatrix(inputCopy);
        assertArrayEquals(expected, inputCopy);
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
    public void emptyArrayRemainsUnchanged(int[][] expected) {
        int[][] input = copyOf(expected);
        matrixZeroer.zeroMatrix(input);
        assertArrayEquals(expected, input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnNullArray() {
        matrixZeroer.zeroMatrix(null);
    }

    private int[][] copyOf(int[][] arr) {
        return Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
    }
}
