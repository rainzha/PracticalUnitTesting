package org.rainzha.practicalunittesting.raceresults;


import org.rainzha.practicalunittesting.exercises.chapter05.MessageCategory;

public class Message {
    private MessageCategory messageCategory;

    public MessageCategory getMessageCategory() {
        return messageCategory;
    }

    public void setMessageCategory(MessageCategory messageCategory) {
        this.messageCategory = messageCategory;
    }
}
