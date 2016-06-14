package org.rainzha.practicalunittesting.raceresults;


import org.junit.Test;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {
    private RaceResultsService raceResults = new RaceResultsService();
    private Message message = mock(Message.class);
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");

    // zero subscribers
    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(message);

        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    // one subscriber
    @Test
    public void subscribedClientShouldReceiveMessage() {
        raceResults.addSubscriber(clientA);
        raceResults.send(message);

        verify(clientA).receive(message);
    }

    // two subscribers
    @Test
    public void messageShouldBeSentToAllSubscribedClients() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientA);
        raceResults.send(message);

        verify(clientA, times(1)).receive(message);
    }

    @Test
    public void unSubscribedClientShouldNotReceiveMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.removeSubscriber(clientA);
        raceResults.send(message);

        verify(clientA, never()).receive(message);
    }
}
