// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.ete.fleacircus.model;

import java.lang.String;

privileged aspect Flea_Roo_ToString {
    
    public String Flea.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Specialties: ").append(getSpecialties() == null ? "null" : getSpecialties().size());
        return sb.toString();
    }
    
}
