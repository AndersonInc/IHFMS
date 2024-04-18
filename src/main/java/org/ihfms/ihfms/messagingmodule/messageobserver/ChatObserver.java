package org.ihfms.ihfms.messagingmodule.messageobserver;

import org.ihfms.ihfms.messagingmodule.messagemodel.ChatMessage;

public interface ChatObserver {

    ChatMessage onMessageReceived(ChatMessage message);

}
