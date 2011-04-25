// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.ete.fleacircus.model;

import java.util.List;
import java.util.Random;
import org.ete.fleacircus.model.Event;
import org.springframework.stereotype.Component;

privileged aspect EventsDataOnDemand_Roo_DataOnDemand {
    
    declare @type: EventsDataOnDemand: @Component;
    
    private Random EventsDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<Event> EventsDataOnDemand.data;
    
    public Event EventsDataOnDemand.getNewTransientEvent(int index) {
        org.ete.fleacircus.model.Event obj = new org.ete.fleacircus.model.Event();
        setStartDate(obj, index);
        setEndDate(obj, index);
        setName(obj, index);
        return obj;
    }
    
    private void EventsDataOnDemand.setStartDate(Event obj, int index) {
        java.util.Date startDate = new java.util.GregorianCalendar(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), java.util.Calendar.getInstance().get(java.util.Calendar.MONTH), java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH), java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY), java.util.Calendar.getInstance().get(java.util.Calendar.MINUTE), java.util.Calendar.getInstance().get(java.util.Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setStartDate(startDate);
    }
    
    private void EventsDataOnDemand.setEndDate(Event obj, int index) {
        java.util.Date endDate = new java.util.GregorianCalendar(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR), java.util.Calendar.getInstance().get(java.util.Calendar.MONTH), java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH), java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY), java.util.Calendar.getInstance().get(java.util.Calendar.MINUTE), java.util.Calendar.getInstance().get(java.util.Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setEndDate(endDate);
    }
    
    private void EventsDataOnDemand.setName(Event obj, int index) {
        java.lang.String name = "name_" + index;
        obj.setName(name);
    }
    
    public Event EventsDataOnDemand.getSpecificEvent(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        Event obj = data.get(index);
        return Event.findEvent(obj.getId());
    }
    
    public Event EventsDataOnDemand.getRandomEvent() {
        init();
        Event obj = data.get(rnd.nextInt(data.size()));
        return Event.findEvent(obj.getId());
    }
    
    public boolean EventsDataOnDemand.modifyEvent(Event obj) {
        return false;
    }
    
    public void EventsDataOnDemand.init() {
        data = org.ete.fleacircus.model.Event.findEventEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Event' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new java.util.ArrayList<org.ete.fleacircus.model.Event>();
        for (int i = 0; i < 10; i++) {
            org.ete.fleacircus.model.Event obj = getNewTransientEvent(i);
            obj.persist();
            obj.flush();
            data.add(obj);
        }
    }
    
}
