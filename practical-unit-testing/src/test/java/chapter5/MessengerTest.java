package chapter5;

import chapter3.Client;
import org.junit.Test;
import org.mockito.Mockito;

public class MessengerTest {

    @Test
    public void testUsingDummyObject() {
        Template template = Mockito.mock(Template.class);
        Client client = Mockito.mock(Client.class);

        TemplateEngine.prepareMessage(template, client);
    }
}