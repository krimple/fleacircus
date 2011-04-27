package org.ete.fleacircus.client.managed.ui;

import com.google.gwt.requestfactory.ui.client.ProxyRenderer;
import java.util.Set;
import org.ete.fleacircus.client.managed.request.FleaProxy;
import org.ete.fleacircus.client.managed.request.SpecialtyProxy;

public class FleaProxyRenderer extends ProxyRenderer<FleaProxy> {

    private static org.ete.fleacircus.client.managed.ui.FleaProxyRenderer INSTANCE;

    protected FleaProxyRenderer() {
        super(new String[] { "name" });
    }

    public static org.ete.fleacircus.client.managed.ui.FleaProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new FleaProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(FleaProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getId() + ")";
    }
}
