package chapter_1_arrays_and_strings.exercise_3_urlify;

import org.junit.Before;
import org.junit.Test;

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
        System.out.println(urlify.toUrl("", 0));
    }
}
