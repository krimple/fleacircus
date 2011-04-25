package org.ete.fleacircus.web;

import org.ete.fleacircus.model.Specialty;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "secure/specialties", formBackingObject = Specialty.class)
@RequestMapping("/secure/specialties")
@Controller
public class SpecialtyController {
}
