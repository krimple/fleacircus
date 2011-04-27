package org.ete.fleacircus.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import org.ete.fleacircus.client.managed.request.EventProxy;
import org.ete.fleacircus.client.managed.ui.EventMobileDetailsView.Binder;
import org.ete.fleacircus.client.scaffold.place.ProxyDetailsView;

public class EventMobileDetailsView extends EventMobileDetailsView_Roo_Gwt {

    private static final Binder BINDER = GWT.create(Binder.class);

    private static org.ete.fleacircus.client.managed.ui.EventMobileDetailsView instance;

    @UiField
    HasClickHandlers delete;

    private Delegate delegate;

    public EventMobileDetailsView() {
        initWidget(BINDER.createAndBindUi(this));
    }

    public static org.ete.fleacircus.client.managed.ui.EventMobileDetailsView instance() {
        if (instance == null) {
            instance = new EventMobileDetailsView();
        }
        return instance;
    }

    public Widget asWidget() {
        return this;
    }

    public boolean confirm(String msg) {
        return Window.confirm(msg);
    }

    public EventProxy getValue() {
        return proxy;
    }

    @UiHandler("delete")
    public void onDeleteClicked(ClickEvent e) {
        delegate.deleteClicked();
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    interface Binder extends UiBinder<HTMLPanel, EventMobileDetailsView> {
    }
}
