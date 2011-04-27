package org.ete.fleacircus.client.managed.ui;

import com.google.gwt.requestfactory.ui.client.ProxyRenderer;
import java.util.Set;
import org.ete.fleacircus.client.managed.request.FleaProxy;
import org.ete.fleacircus.client.managed.request.SpecialtyProxy;

public class SpecialtyProxyRenderer extends ProxyRenderer<SpecialtyProxy> {

    private static org.ete.fleacircus.client.managed.ui.SpecialtyProxyRenderer INSTANCE;

    protected SpecialtyProxyRenderer() {
        super(new String[] { "name" });
    }

    public static org.ete.fleacircus.client.managed.ui.SpecialtyProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new SpecialtyProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(SpecialtyProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getId() + ")";
    }
}
