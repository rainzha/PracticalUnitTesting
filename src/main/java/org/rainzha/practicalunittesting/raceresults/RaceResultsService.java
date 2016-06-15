package org.rainzha.practicalunittesting.raceresults;


import org.rainzha.practicalunittesting.exercises.chapter05.Log;
import org.rainzha.practicalunittesting.exercises.chapter05.MessageCategory;

import java.util.HashSet;
import java.util.Set;

public class RaceResultsService {
    private Set<ClientAndMessageCategory> clients = new HashSet<>();
    private Log log;

    public RaceResultsService(Log log) {
        this.log = log;
    }

    public void addSubscriber(Client client) {
        addSubscriber(client, MessageCategory.NONE);
    }

    public void addSubscriber(Client client, MessageCategory messageCategory) {
        clients.add(new ClientAndMessageCategory(client, messageCategory));
    }

    public void send(Message message) {
        clients.stream().filter(o -> o.messageCategory == message.getMessageCategory())
                .forEach(o -> {
                    o.client.receive(message);
                    log.log("message is logged.");
                });
    }

    public void removeSubscriber(Client client) {
        clients.removeIf(o -> o.client == client);
    }

    private class ClientAndMessageCategory {
        Client client;
        MessageCategory messageCategory;

        public ClientAndMessageCategory(Client client, MessageCategory messageCategory) {
            this.client = client;
            this.messageCategory = messageCategory;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClientAndMessageCategory that = (ClientAndMessageCategory) o;

            if (client != null ? !client.equals(that.client) : that.client != null) return false;
            return messageCategory == that.messageCategory;

        }

        @Override
        public int hashCode() {
            int result = client != null ? client.hashCode() : 0;
            result = 31 * result + (messageCategory != null ? messageCategory.hashCode() : 0);
            return result;
        }
    }
}