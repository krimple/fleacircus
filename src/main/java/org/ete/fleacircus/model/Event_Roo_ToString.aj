// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.ete.fleacircus.model;

import java.lang.String;

privileged aspect Event_Roo_ToString {
    
    public String Event.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EndDate: ").append(getEndDate()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("StartDate: ").append(getStartDate());
        return sb.toString();
    }
    
}
