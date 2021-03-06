// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.ete.fleacircus.web;

import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.ete.fleacircus.model.Event;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect EventController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String EventController.create(@Valid Event event, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("event", event);
            addDateTimeFormatPatterns(uiModel);
            return "secure/events/create";
        }
        uiModel.asMap().clear();
        event.persist();
        return "redirect:/secure/events/" + encodeUrlPathSegment(event.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String EventController.createForm(Model uiModel) {
        uiModel.addAttribute("event", new Event());
        addDateTimeFormatPatterns(uiModel);
        return "secure/events/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String EventController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("event", Event.findEvent(id));
        uiModel.addAttribute("itemId", id);
        return "secure/events/show";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String EventController.update(@Valid Event event, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("event", event);
            addDateTimeFormatPatterns(uiModel);
            return "secure/events/update";
        }
        uiModel.asMap().clear();
        event.merge();
        return "redirect:/secure/events/" + encodeUrlPathSegment(event.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String EventController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("event", Event.findEvent(id));
        addDateTimeFormatPatterns(uiModel);
        return "secure/events/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String EventController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Event.findEvent(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/secure/events";
    }
    
    void EventController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("event_startdate_date_format", DateTimeFormat.patternForStyle("S-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("event_enddate_date_format", DateTimeFormat.patternForStyle("S-", LocaleContextHolder.getLocale()));
    }
    
    String EventController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
