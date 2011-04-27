package org.ete.fleacircus.client.managed.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.view.client.Range;
import java.util.List;
import org.ete.fleacircus.client.managed.request.ApplicationRequestFactory;
import org.ete.fleacircus.client.managed.request.EventProxy;
import org.ete.fleacircus.client.scaffold.ScaffoldMobileApp;
import org.ete.fleacircus.client.scaffold.activity.IsScaffoldMobileActivity;
import org.ete.fleacircus.client.scaffold.place.AbstractProxyListActivity;
import org.ete.fleacircus.client.scaffold.place.ProxyListView;

public class EventListActivity extends AbstractProxyListActivity<EventProxy> implements IsScaffoldMobileActivity {

    private final ApplicationRequestFactory requests;

    public EventListActivity(ApplicationRequestFactory requests, ProxyListView<org.ete.fleacircus.client.managed.request.EventProxy> view, PlaceController placeController) {
        super(placeController, view, EventProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "Events";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<org.ete.fleacircus.client.managed.request.EventProxy>> createRangeRequest(Range range) {
        return requests.eventRequest().findEventEntries(range.getStart(), range.getLength());
    }

    protected void fireCountRequest(Receiver<Long> callback) {
        requests.eventRequest().countEvents().fire(callback);
    }
}
