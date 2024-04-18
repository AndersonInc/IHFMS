package org.ihfms.ihfms.messagingmodule.messageconfig;

import jakarta.annotation.PostConstruct;
import org.ihfms.ihfms.messagingmodule.messageobservable.ChatObservable;
import org.ihfms.ihfms.messagingmodule.messagingservice.ChatService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    private final ChatObservable chatObservable;
    private final ChatService chatService;

    public MessageConfig(ChatObservable chatObservable, ChatService chatService) {
        this.chatObservable = chatObservable;
        this.chatService = chatService;
    }

    // to add the chat room at runtime
    @PostConstruct
    public void init(){
        chatObservable.subscribe(chatService);
    }

}
