// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.ete.fleacircus.messaging;

import java.lang.String;
import org.slf4j.Logger;
import org.springframework.jms.core.JmsTemplate;

privileged aspect ChatListener_Roo_JavaBean {
    
    public JmsTemplate ChatListener.getTemplate() {
        return this.template;
    }
    
    public void ChatListener.setTemplate(JmsTemplate template) {
        this.template = template;
    }
    
    public Logger ChatListener.getLogger() {
        return this.logger;
    }
    
    public void ChatListener.setLogger(Logger logger) {
        this.logger = logger;
    }
    
    public String[] ChatListener.getResponses() {
        return this.responses;
    }
    
    public void ChatListener.setResponses(String[] responses) {
        this.responses = responses;
    }
    
}