package chapter5;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class MockitoVerificationTest {
    private Car myFerrari = Mockito.mock(Car.class);

    @Test
    public void testVerification() {
        myFerrari.driveTo("Sweet home Alabama");
        myFerrari.needsFuel();

        verify(myFerrari).driveTo("Sweet home Alabama");
        verify(myFerrari).needsFuel();
    }

    @Test
    public void testVerificationFailure() {
        myFerrari.needsFuel();

        verify(myFerrari).getEngineTemperature();
    }

    @Test
    public void testPVerificationFailureArguments() {
        myFerrari.driveTo("Sweet home Alabama");

        verify(myFerrari).driveTo("Sweet home Honolulu");
    }
}
