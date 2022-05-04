package chapter5;

import chapter3.Client;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MessengerTest {
    private final String MSG_CONTENT = "This is the content of the message";

    @Test
    public void testUsingDummyObject() {
        Template template = Mockito.mock(Template.class);
        TemplateEngine templateEngine = new TemplateEngine();

        templateEngine.prepareMessage(template, new Client());
    }

    @Test
    public void testUsingStub() {
        TemplateEngine templateEngine = Mockito.mock(TemplateEngine.class);
        Template template = Mockito.mock(Template.class);
        Client client = new Client();
        Messenger sut = new Messenger(new MailServer(), templateEngine);

        when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);

        sut.sendMessage(client, template);
    }

    @Test
    public void testIndirectOutputsWithSpy() {
        TemplateEngine templateEngine = Mockito.mock(TemplateEngine.class);
        Template template = new Template("This is the content of the message");
        Client client = new Client("some@email.com");

        MailServer mailServer = Mockito.mock(MailServer.class);
        Messenger sut = new Messenger(mailServer, templateEngine);

        when(templateEngine.prepareMessage(template, client)).thenReturn(template.getTemplate());

        sut.sendMessage(client, template);
        verify(mailServer).send("some@email.com", MSG_CONTENT);
    }
}