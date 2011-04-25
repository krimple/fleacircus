package org.ete.fleacircus.web;

import org.ete.fleacircus.model.Event;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "secure/events", formBackingObject = Event.class)
@RequestMapping("/secure/events")
@Controller
public class EventsController {
}
