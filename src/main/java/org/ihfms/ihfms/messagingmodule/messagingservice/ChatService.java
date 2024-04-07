package org.ihfms.ihfms.messagingmodule.messagingservice;


import org.ihfms.ihfms.messagingmodule.messagemodel.ChatMessage;
import org.ihfms.ihfms.messagingmodule.messageobserver.ChatObserver;
import org.ihfms.ihfms.messagingmodule.messagerepo.MessageRepo;
import org.springframework.stereotype.Service;

@Service
public class ChatService implements ChatObserver {

    private final MessageRepo messageRepo;

    public ChatService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @Override
    public ChatMessage onMessageReceived(ChatMessage message) {
        messageRepo.addMessage(message);
        return message;
    }
}
