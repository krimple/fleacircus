package org.ete.fleacircus.model;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Set;
import org.ete.fleacircus.model.Flea;
import java.util.HashSet;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;

@RooJavaBean
@RooToString
@RooEntity
@RooPlural("specialities")
public class Specialty {

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Flea> fleas = new HashSet<Flea>();
}
