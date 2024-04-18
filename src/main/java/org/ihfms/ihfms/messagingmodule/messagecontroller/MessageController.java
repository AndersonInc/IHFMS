package org.ihfms.ihfms.messagingmodule.messagecontroller;


import org.ihfms.ihfms.messagingmodule.messagemodel.ChatMessage;
import org.ihfms.ihfms.messagingmodule.messageobservable.ChatObservable;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("health-hub")
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {

    private final ChatObservable chatObservable;
    public MessageController(ChatObservable chatObservable) {
        this.chatObservable = chatObservable;
    }

    // broadcasting the message
//    @PostMapping("/sendMessage")
//    public void sendMessage(
//            @RequestBody String messageContent,
//            @RequestBody String sender
//    ) {
//        ChatMessage message = new ChatMessage();
//        message.setSender(sender);
//        message.setContent(messageContent);
//        message.setTimestamp(LocalTime.now());
//
//        chatObservable.notifyChatObservers(message);
//    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody ChatMessage message) {
        //message.setTimestamp(LocalDateTime.now());
        chatObservable.notifyChatObservers(message);
    }


}
