package org.ete.fleacircus.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/chat/**")
@Controller
public class ChatController {

    @Autowired
    private JmsTemplate template;

    public void get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String sendMessage(ModelMap model, @RequestParam String message, BindingResult errors) {
        template.convertAndSend(message);
        template.setReceiveTimeout(100L);
        String response = (String) template.receiveAndConvert();
        if (response != null) {
            return response;
        } else {
            return "waiting for response...";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "chat/index";
    }

    /**
     * Our AJAX server method
     */
    @RequestMapping(method = RequestMethod.GET, value = "/updates")
    public @ResponseBody String getUpdates() {
        template.setReceiveTimeout(1000L);
        String result = (String) template.receiveAndConvert();
        return result == null ? "" : result;
    }

}
