package org.ihfms.ihfms.messagingmodule.messageobserver;

//import com.ihfms.healthfinancehub.messagingmodule.messagemodel.ChatMessage;

import org.ihfms.ihfms.messagingmodule.messagemodel.ChatMessage;

public interface ChatObserver {

    ChatMessage onMessageReceived(ChatMessage message);

}
