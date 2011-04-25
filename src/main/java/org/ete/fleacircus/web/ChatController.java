package org.ete.fleacircus.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ete.fleacircus.model.MessageCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/chat/**")
@Controller
public class ChatController {

    @Autowired
    @Qualifier("chatDestination")
    private JmsTemplate template;


    public void get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping(method = RequestMethod.POST)
    public void sendMessage(Model model, @Valid MessageCommand message, BindingResult errors) {
        template.convertAndSend();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "chat/index";
    }

    /**
     * Our AJAX server method - use JSON to get updates from the MessageCommand,
     * which we annotate with the @RooJson annotation to make easy to work with. 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/updates")
    public @ResponseBody String getUpdates() {
        String result = template.receive();
        MessageCommand command = new MessageCommand();
        command.setMessage(result);
        return command.toJson();
    }

}
