package org.ihfms.ihfms.messagingmodule.messagecontroller;



import org.ihfms.ihfms.messagingmodule.messageobservable.ChatObservable;
import org.ihfms.ihfms.messagingmodule.messagingservice.ChatService;
import org.springframework.web.bind.annotation.*;

// adding chat service as an observer
@RestController
@RequestMapping("health-hub")
public class SubscribeController{

    private final ChatObservable chatObservable;
    private final ChatService chatService;

    public SubscribeController(ChatObservable chatObservable, ChatService chatService) {
        this.chatObservable = chatObservable;
        this.chatService = chatService;
    }

    @PostMapping("/subscribe")
    public String subscribeUser() {
        chatObservable.subscribe(chatService);
        return "User subscribed successfully";
    }

    @PostMapping("/unsubscribe")
    public String unsubscribeUser() {
//        chatObservable.unsubscribe();
        return "User unsubscribed successfully";
    }

}
