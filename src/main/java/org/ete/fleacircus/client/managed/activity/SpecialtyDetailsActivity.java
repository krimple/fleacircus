package org.ete.fleacircus.client.managed.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import java.util.Set;
import org.ete.fleacircus.client.managed.request.ApplicationRequestFactory;
import org.ete.fleacircus.client.managed.request.FleaProxy;
import org.ete.fleacircus.client.managed.request.SpecialtyProxy;
import org.ete.fleacircus.client.managed.ui.FleaSetEditor;
import org.ete.fleacircus.client.scaffold.activity.IsScaffoldMobileActivity;
import org.ete.fleacircus.client.scaffold.place.ProxyDetailsView;
import org.ete.fleacircus.client.scaffold.place.ProxyListPlace;
import org.ete.fleacircus.client.scaffold.place.ProxyPlace;
import org.ete.fleacircus.client.scaffold.place.ProxyPlace.Operation;

public class SpecialtyDetailsActivity extends SpecialtyDetailsActivity_Roo_Gwt {

    private final PlaceController placeController;

    private final ProxyDetailsView<SpecialtyProxy> view;

    private AcceptsOneWidget display;

    public SpecialtyDetailsActivity(EntityProxyId<org.ete.fleacircus.client.managed.request.SpecialtyProxy> proxyId, ApplicationRequestFactory requests, PlaceController placeController, ProxyDetailsView<org.ete.fleacircus.client.managed.request.SpecialtyProxy> view) {
        this.placeController = placeController;
        this.proxyId = proxyId;
        this.requests = requests;
        view.setDelegate(this);
        this.view = view;
    }

    public void deleteClicked() {
        if (!view.confirm("Really delete this entry? You cannot undo this change.")) {
            return;
        }
        requests.specialtyRequest().remove().using(view.getValue()).fire(new Receiver<Void>() {

            public void onSuccess(Void ignore) {
                if (display == null) {
                    return;
                }
                placeController.goTo(getBackButtonPlace());
            }
        });
    }

    public void editClicked() {
        placeController.goTo(getEditButtonPlace());
    }

    public Place getBackButtonPlace() {
        return new ProxyListPlace(SpecialtyProxy.class);
    }

    public String getBackButtonText() {
        return "Back";
    }

    public Place getEditButtonPlace() {
        return new ProxyPlace(view.getValue().stableId(), Operation.EDIT);
    }

    public String getTitleText() {
        return "View Specialty";
    }

    public boolean hasEditButton() {
        return true;
    }

    public void onCancel() {
        onStop();
    }

    public void onStop() {
        display = null;
    }

    public void start(AcceptsOneWidget displayIn, EventBus eventBus) {
        this.display = displayIn;
        Receiver<EntityProxy> callback = new Receiver<EntityProxy>() {

            public void onSuccess(EntityProxy proxy) {
                if (proxy == null) {
                    placeController.goTo(getBackButtonPlace());
                    return;
                }
                if (display == null) {
                    return;
                }
                view.setValue((SpecialtyProxy) proxy);
                display.setWidget(view);
            }
        };
        find(callback);
    }
}
