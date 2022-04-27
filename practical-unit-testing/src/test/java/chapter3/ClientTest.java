package chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientTest {
    private Address addressA;
    private Address addressB;
    private Client client;

    // Make JUnit execute the following method before each test method is executed
    @Before
    public void setUp() {
        addressA = new Address("street A");
        addressB = new Address("street B");
        client = new Client();
    }

    /*
    Methods annotated with @After are executed after each test method
    @BeforeClass and @AfterClass annotations work in the same way as @Before and @After but on a class level.
        ^ usually used to create costly resources and clean them afterwards.
     */

    @Test
    public void afterCreationShouldHaveNoAddress() {
        assertEquals(0, client.getAddresses().size());
    }
    @Test
    public void shouldAllowToAddAddress() {
        client.addAddress(addressA);
        assertEquals(1, client.getAddresses().size());
        assertTrue(client.getAddresses().contains(addressA));
    }
    @Test
    public void shouldAllowToAddManyAddresses() {
        client.addAddress(addressA);
        client.addAddress(addressB);
        assertEquals(2, client.getAddresses().size());
        assertTrue(client.getAddresses().contains(addressA));
        assertTrue(client.getAddresses().contains(addressB));
    }
}
