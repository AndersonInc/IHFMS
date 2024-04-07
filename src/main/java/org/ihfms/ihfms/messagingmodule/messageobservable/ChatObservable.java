package org.ihfms.ihfms.messagingmodule.messageobservable;


import org.ihfms.ihfms.messagingmodule.messagemodel.ChatMessage;
import org.ihfms.ihfms.messagingmodule.messageobserver.ChatObserver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatObservable {

    private final List<ChatObserver> chatObservers = new ArrayList<>();

    public void subscribe(ChatObserver chatObserver) {
        chatObservers.add(chatObserver);
    }

    public void unsubscribe(ChatObserver chatObserver) {
        chatObservers.remove(chatObserver);
    }

    public void notifyChatObservers(ChatMessage message) {
        for (ChatObserver observer : chatObservers) {
            observer.onMessageReceived(message);
        }
    }
    
}
