package org.ete.fleacircus.messaging;


import org.springframework.jms.core.JmsTemplate;

public class ChatListener {

    public void onMessage(Object message) {
        System.out.println("JMS message received: " + message);
    }
}
