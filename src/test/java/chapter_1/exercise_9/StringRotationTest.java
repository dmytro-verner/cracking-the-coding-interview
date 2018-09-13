package chapter_1.exercise_9;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class StringRotationTest {

    private StringRotation stringRotation;

    @Before
    public void setUp() {
        stringRotation = new StringRotation();
    }

    @Test
    public void rotatedStringIsIdentifiedAsRotated() {
        assertTrue(stringRotation.isRotation("waterbottle", "terbottlewa"));
    }

    @Test
    public void nonRotatedStringIsIdentifiedAsNotRotated() {
        assertFalse(stringRotation.isRotation("waterbottle", "terbottlew"));
    }

    @Test
    public void EqualStringsIdentifiedAsRotated() {
        assertTrue(stringRotation.isRotation("abc", "abc"));
    }

    private static Object[] nullStringsCombinations(){
        return new Object[] {
                new Object[] { null, null},
                new Object[] { null, "a"},
                new Object[] { "a", null},
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "nullStringsCombinations")
    public void IAEOnAnyNullString(String s1, String s2) {
        stringRotation.isRotation(s1, s2);
    }

    private static Object[] emptyStringsCombinations(){
        return new Object[] {
                new Object[] { "", ""},
                new Object[] { "", "a"},
                new Object[] { "a", ""},
        };
    }

    @Test
    @Parameters(method = "emptyStringsCombinations")
    public void emptyStringsAreIdentifiedAsRotated(String s1, String s2) {
        assertFalse(stringRotation.isRotation(s1, s2));
    }
}
