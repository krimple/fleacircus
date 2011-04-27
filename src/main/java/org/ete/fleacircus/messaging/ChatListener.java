package org.ete.fleacircus.messaging;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.roo.addon.javabean.RooJavaBean;

@RooJavaBean
public class ChatListener implements MessageListener {

	@Autowired
	private JmsTemplate template;

	Logger logger = LoggerFactory.getLogger(ChatListener.class);

    String[] responses = {
            "I'm busy combing my hair to look for, wait, me...",
            "What are you talking about, I'm a flea?",
            "There's food around the mountain, food around the mountain...",
            "Are you looking for the bassist for the Red Hot Chili Peppers?",
            "Don't look now, but I'm about to drink your blood...",
            "IT Department.  Did you try turning it off and on again?",
            "My response will just make you itch..."
    };

    @Override
    public void onMessage(Message jmsMessage) {
    	// TODO Auto-generated method stub
    	try {
			String message = ((TextMessage)jmsMessage).getText();
			logger.debug("JMS message received: " + message);
	        // right back atcha!
	        int response = (int)(Math.random() * (responses.length - 1));
	        template.convertAndSend(response);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			template.convertAndSend("Error in JMS. " + e.toString());
		}
    }


}
