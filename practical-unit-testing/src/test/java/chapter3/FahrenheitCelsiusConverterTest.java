package chapter3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelsiusConverterTest {

    public static Object[] getValidTemperatures() {
        return new Integer[][] {
                {32, 0},
                {98, 37},
                {212, 100}
        };
    }

    @Test
    @Parameters (method = "getValidTemperatures")
    public void shouldConvertCelsiusToFahrenheit(int expectedValue, int valueToConvert) {
        assertEquals(expectedValue, FahrenheitCelsiusConverter.toFahrenheit(valueToConvert));
    }

    @Test
    @Parameters (method = "getValidTemperatures")
    public void shouldConvertFahrenheitToCelsius(int valueToConvert, int expectedValue) {
        assertEquals(expectedValue, FahrenheitCelsiusConverter.toCelsius(valueToConvert));
    }
}
