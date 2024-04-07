package org.ihfms.ihfms.messagingmodule.messagemodel;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ChatMessage {
    private String sender;
    private String content;
    private MessageType type;
    private LocalTime timestamp;
}
