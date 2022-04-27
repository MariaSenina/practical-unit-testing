package chapter3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class StringReverseTest {

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowIAEWhenStringEmpty() {
        ExercisesCh3.reverse("");
    }

    @Test (expected = NullPointerException.class)
    public void shouldThrowNPEWhenStringNull() {
        ExercisesCh3.reverse(null);
    }

    @Test
    @Parameters(method = "getValidString")
    public void shouldReturnStringOfSameSizeAsStringProvided(String testString) {
        String reversedString = ExercisesCh3.reverse(testString);

        assertEquals(testString.length(), reversedString.length());
    }

    @Test
    public void shouldReturnCorrectReversedString() {
        String reversedString = ExercisesCh3.reverse("testing");

        assertEquals("gnitset", reversedString);
    }

    public static final Object[] getValidString() {
        return new String[][] {{"Hello"}, {"Test"}};
    }
}
