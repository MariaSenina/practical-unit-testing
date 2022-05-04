package chapter5;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class FirstMockitoTest {
    Car myFerrari = Mockito.mock(Car.class);

    @Test
    public void testIfCarIsACar() {
        assertTrue(myFerrari instanceof Car);
    }

    @Test
    public void testDefaultBehaviourOfTestDouble() {
        assertFalse("New test double should return false as boolean", myFerrari.needsFuel());

        assertEquals("New test double should return 0.0 as double",
                0.0, myFerrari.getEngineTemperature(), 0.0);
    }

    @Test
    public void testStubbing() {
        assertFalse("New test double should return false as boolean", myFerrari.needsFuel());

        when(myFerrari.needsFuel()).thenReturn(true);

        assertTrue("New test double should return false as boolean", myFerrari.needsFuel());
    }

    @Test(expected = RuntimeException.class)
    public void throwException() {
        when(myFerrari.needsFuel()).thenThrow(new RuntimeException());

        myFerrari.needsFuel();
    }
}
