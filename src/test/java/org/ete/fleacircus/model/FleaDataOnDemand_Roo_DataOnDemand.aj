// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.ete.fleacircus.model;

import java.util.List;
import java.util.Random;
import org.ete.fleacircus.model.Flea;
import org.springframework.stereotype.Component;

privileged aspect FleaDataOnDemand_Roo_DataOnDemand {
    
    declare @type: FleaDataOnDemand: @Component;
    
    private Random FleaDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<Flea> FleaDataOnDemand.data;
    
    public Flea FleaDataOnDemand.getNewTransientFlea(int index) {
        org.ete.fleacircus.model.Flea obj = new org.ete.fleacircus.model.Flea();
        setName(obj, index);
        return obj;
    }
    
    private void FleaDataOnDemand.setName(Flea obj, int index) {
        java.lang.String name = "name_" + index;
        obj.setName(name);
    }
    
    public Flea FleaDataOnDemand.getSpecificFlea(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        Flea obj = data.get(index);
        return Flea.findFlea(obj.getId());
    }
    
    public Flea FleaDataOnDemand.getRandomFlea() {
        init();
        Flea obj = data.get(rnd.nextInt(data.size()));
        return Flea.findFlea(obj.getId());
    }
    
    public boolean FleaDataOnDemand.modifyFlea(Flea obj) {
        return false;
    }
    
    public void FleaDataOnDemand.init() {
        data = org.ete.fleacircus.model.Flea.findFleaEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Flea' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new java.util.ArrayList<org.ete.fleacircus.model.Flea>();
        for (int i = 0; i < 10; i++) {
            org.ete.fleacircus.model.Flea obj = getNewTransientFlea(i);
            obj.persist();
            obj.flush();
            data.add(obj);
        }
    }
    
}
