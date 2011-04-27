package org.ete.fleacircus.model;

import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.serializable.RooSerializable;

@RooJavaBean
@RooJson
@RooSerializable 
public class MessageCommand {

    @Size(min=1, max=500)
    private String message;

}
