package org.ihfms.ihfms.messagingmodule.messagerepo;

import org.ihfms.ihfms.messagingmodule.messagemodel.ChatMessage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// storing messages sent
@Repository
public class MessageRepo {

    private final List<ChatMessage> messages = new ArrayList<>();

    public void addMessage(ChatMessage message) {
        messages.add(message);
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

}
