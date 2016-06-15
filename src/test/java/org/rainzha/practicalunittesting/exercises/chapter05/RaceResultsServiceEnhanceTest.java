package org.rainzha.practicalunittesting.exercises.chapter05;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.rainzha.practicalunittesting.raceresults.Client;
import org.rainzha.practicalunittesting.raceresults.Message;
import org.rainzha.practicalunittesting.raceresults.RaceResultsService;

import static org.mockito.Mockito.*;

public class RaceResultsServiceEnhanceTest {
    private Log log;
    private RaceResultsService raceResults;
    private Message messageA;
    private Message messageB;
    private Client clientA;
    private Client clientB;

    @Before
    public void setUp() {
        log = mock(Log.class);
        raceResults = new RaceResultsService(log);
        messageA = mock(Message.class);
        messageB = mock(Message.class);
        clientA = mock(Client.class, "clientA");
        clientB = mock(Client.class, "clientB");

        when(messageA.getMessageCategory()).thenReturn(MessageCategory.F1);
        when(messageB.getMessageCategory()).thenReturn(MessageCategory.NBA);
    }

    @Test
    public void subscribedClientShouldReceiveCategoryMessage() {
        raceResults.addSubscriber(clientA, MessageCategory.F1);
        raceResults.send(messageA);

        verify(clientA).receive(messageA);
    }

    @Test
    public void multiSubscribedShouldReceiveTheirCategoryMessage() {
        raceResults.addSubscriber(clientA, MessageCategory.F1);
        raceResults.addSubscriber(clientA, MessageCategory.NBA);
        raceResults.addSubscriber(clientB, MessageCategory.NBA);
        raceResults.send(messageA);
        raceResults.send(messageB);

        verify(clientA).receive(messageA);
        verify(clientA).receive(messageB);
        verify(clientB).receive(messageB);
    }

    @Test
    public void shouldSendOnlyOneCategoryMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA, MessageCategory.F1);
        raceResults.addSubscriber(clientA, MessageCategory.F1);
        raceResults.send(messageA);

        verify(clientA, times(1)).receive(messageA);
    }

    @Test
    public void shouldLoggedWhenSendMessage() {
        raceResults.addSubscriber(clientA,MessageCategory.F1);
        raceResults.send(messageA);

        verify(log).log("message is logged.");
    }

    @Test
    public void unSubscribedClientRemoveSubscriberShouldNoOperation(){
        raceResults.removeSubscriber(clientA);

        Mockito.verifyZeroInteractions(clientA);
    }
}