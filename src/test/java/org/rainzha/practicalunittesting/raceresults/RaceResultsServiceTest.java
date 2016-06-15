package org.rainzha.practicalunittesting.raceresults;


import org.junit.Before;
import org.junit.Test;
import org.rainzha.practicalunittesting.exercises.chapter05.Log;
import org.rainzha.practicalunittesting.exercises.chapter05.MessageCategory;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {
    private RaceResultsService raceResults;
    private Message message;
    private Client clientA;
    private Client clientB;

    @Before
    public void setUp() {
        raceResults = new RaceResultsService(new Log());
        message = new Message();
        message.setMessageCategory(MessageCategory.NONE);
        clientA = mock(Client.class, "clientA");
        clientB = mock(Client.class, "clientB");
    }

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
