package org.rainzha.practicalunittesting.types;


import org.junit.Test;

import static org.mockito.Mockito.*;

public class MessengerTest {
    private static final String CLIENT_EMAIL = "test@test.com";
    private static final String MSG_CONTENT = "hello mockito";

    @Test
    public void shouldSendEmail() {
        MailServer mailServer = mock(MailServer.class);
        TemplateEngine templateEngine = mock(TemplateEngine.class);
        Client client = mock(Client.class);
        Template template = mock(Template.class);

        Messenger sut = new Messenger(mailServer, templateEngine);

        when(client.getEmail()).thenReturn(CLIENT_EMAIL);
        when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);

        sut.sendMessage(client, template);

        verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
    }
}