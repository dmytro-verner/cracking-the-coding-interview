package chapter_1.exercise_3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class URLifyTest {

    private URLify urlify;

    @Before
    public void setUp() {
        urlify = new URLify();
    }

    @Test
    public void validStringUrlified() {
        String result = urlify.toUrl("Mr John Smith       ", 13);
        String expected = "Mr%20John%20Smith";
        assertTrue(result.contains(expected));
    }

    @Test
    public void emptyStringOnUrlifyingEmptyString() {
        assertEquals("", urlify.toUrl("", 0));
    }
}
