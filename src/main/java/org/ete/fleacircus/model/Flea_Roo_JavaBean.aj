// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.ete.fleacircus.model;

import java.lang.String;
import java.util.Set;
import org.ete.fleacircus.model.Specialty;

privileged aspect Flea_Roo_JavaBean {
    
    public String Flea.getName() {
        return this.name;
    }
    
    public void Flea.setName(String name) {
        this.name = name;
    }
    
    public Set<Specialty> Flea.getSpecialties() {
        return this.specialties;
    }
    
    public void Flea.setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
    
}
