// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.ete.fleacircus.model;

import org.ete.fleacircus.model.EventDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect EventIntegrationTest_Roo_IntegrationTest {
    
    declare @type: EventIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: EventIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    declare @type: EventIntegrationTest: @Transactional;
    
    @Autowired
    private EventDataOnDemand EventIntegrationTest.dod;
    
    @Test
    public void EventIntegrationTest.testFindEvent() {
        org.ete.fleacircus.model.Event obj = dod.getRandomEvent();
        org.junit.Assert.assertNotNull("Data on demand for 'Event' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Event' failed to provide an identifier", id);
        obj = org.ete.fleacircus.model.Event.findEvent(id);
        org.junit.Assert.assertNotNull("Find method for 'Event' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'Event' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void EventIntegrationTest.testFlush() {
        org.ete.fleacircus.model.Event obj = dod.getRandomEvent();
        org.junit.Assert.assertNotNull("Data on demand for 'Event' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Event' failed to provide an identifier", id);
        obj = org.ete.fleacircus.model.Event.findEvent(id);
        org.junit.Assert.assertNotNull("Find method for 'Event' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyEvent(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'Event' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void EventIntegrationTest.testMerge() {
        org.ete.fleacircus.model.Event obj = dod.getRandomEvent();
        org.junit.Assert.assertNotNull("Data on demand for 'Event' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Event' failed to provide an identifier", id);
        obj = org.ete.fleacircus.model.Event.findEvent(id);
        boolean modified =  dod.modifyEvent(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        org.ete.fleacircus.model.Event merged = (org.ete.fleacircus.model.Event) obj.merge();
        obj.flush();
        org.junit.Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        org.junit.Assert.assertTrue("Version for 'Event' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void EventIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'Event' failed to initialize correctly", dod.getRandomEvent());
        org.ete.fleacircus.model.Event obj = dod.getNewTransientEvent(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'Event' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'Event' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'Event' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void EventIntegrationTest.testRemove() {
        org.ete.fleacircus.model.Event obj = dod.getRandomEvent();
        org.junit.Assert.assertNotNull("Data on demand for 'Event' failed to initialize correctly", obj);
        java.lang.Long id = obj.getId();
        org.junit.Assert.assertNotNull("Data on demand for 'Event' failed to provide an identifier", id);
        obj = org.ete.fleacircus.model.Event.findEvent(id);
        obj.remove();
        obj.flush();
        org.junit.Assert.assertNull("Failed to remove 'Event' with identifier '" + id + "'", org.ete.fleacircus.model.Event.findEvent(id));
    }
    
}