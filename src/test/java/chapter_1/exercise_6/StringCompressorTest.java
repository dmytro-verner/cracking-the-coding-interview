package chapter_1.exercise_6;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class StringCompressorTest {

    private StringCompressor stringCompressor;

    @Before
    public void setUp() {
        stringCompressor = new StringCompressor();
    }

    private static Object[] compressableStrings(){
        return new Object[] {
                new Object[] {"a2b1c5a3", "aabcccccaaa"},
                new Object[] {"a2b1c5a1", "aabccccca"},
        };
    }

    @Test
    @Parameters(method = "compressableStrings")
    public void compressableStringGetsCompressed(String expected, String input) {
        assertEquals(expected, stringCompressor.compress(input));
    }

    @Test
    public void uncompressableStringDoesNotGetCompressed() {
        assertEquals("aabcde", stringCompressor.compress("aabcde"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIAEOnNullString() {
        stringCompressor.compress(null);
    }

    @Test
    public void compressingOnEmptyStringReturnsEmptyString() {
        assertEquals("", stringCompressor.compress(""));
    }

    @Test
    public void oneSymbolStringNotCompressed() {
        assertEquals("a", stringCompressor.compress("a"));
    }
}
