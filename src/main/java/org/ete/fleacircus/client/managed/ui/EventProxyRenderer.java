package org.ete.fleacircus.client.managed.ui;

import com.google.gwt.requestfactory.ui.client.ProxyRenderer;
import org.ete.fleacircus.client.managed.request.EventProxy;

public class EventProxyRenderer extends ProxyRenderer<EventProxy> {

    private static org.ete.fleacircus.client.managed.ui.EventProxyRenderer INSTANCE;

    protected EventProxyRenderer() {
        super(new String[] { "name" });
    }

    public static org.ete.fleacircus.client.managed.ui.EventProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new EventProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(EventProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getId() + ")";
    }
}
