package chapter4;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {
    // Value generator methods
    public Object[] validLengthStrings() {
        return new Object[] {
                "abcdefgh",
                "testingtesting"
        };
    }

    public Object[] invalidLengthString() {
        return new Object[] {
                "hello",
                "test"
        };
    }

    // Test methods
    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIllegalArgumentExceptionWhenPasswordIsNull() {
        new PasswordValidator(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIllegalArgumentExceptionWhenPasswordEmpty() {
        new PasswordValidator("");
    }

    @Test
    @Parameters(method = "validLengthStrings")
    public void passwordMustBeAtLeastEightCharactersLong(String password) {
        PasswordValidator validator = new PasswordValidator(password);

        assertTrue("Password must be at least 8 characters long, " +
                        "password received is " + validator.getPassword().length() + " character(s) long",
                validator.getPassword().length() >= 8);
    }

    @Test
    @Parameters(method = "invalidLengthString")
    public void passwordCannotBeLessThanEightCharactersLong(String password) {
        PasswordValidator validator = new PasswordValidator(password);

        assertTrue("Password must be at least 8 characters long, " +
                        "password received is " + validator.getPassword().length() + " character(s) long",
                validator.getPassword().length() < 8);
    }
}
