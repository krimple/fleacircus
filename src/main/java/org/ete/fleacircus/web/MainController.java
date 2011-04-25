package org.ete.fleacircus.web;

import org.apache.commons.logging.LogFactory;
import org.ete.fleacircus.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by IntelliJ IDEA.
 * User: kenrimple
 * Date: 4/22/11
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainController {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String run(Model model, Principal user) {
        if (user != null) {
            logger.debug("User already logged in - " + user.getName());
            return "index";
        } else {
            logger.debug("User not logged in, show public page");
            model.asMap().put("events", Event.findAllEvents());
            return "public_index";
        }                
    }
}
