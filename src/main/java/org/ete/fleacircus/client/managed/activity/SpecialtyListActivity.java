package org.ete.fleacircus.client.managed.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.view.client.Range;
import java.util.List;
import java.util.Set;
import org.ete.fleacircus.client.managed.request.ApplicationRequestFactory;
import org.ete.fleacircus.client.managed.request.FleaProxy;
import org.ete.fleacircus.client.managed.request.SpecialtyProxy;
import org.ete.fleacircus.client.managed.ui.FleaSetEditor;
import org.ete.fleacircus.client.scaffold.ScaffoldMobileApp;
import org.ete.fleacircus.client.scaffold.activity.IsScaffoldMobileActivity;
import org.ete.fleacircus.client.scaffold.place.AbstractProxyListActivity;
import org.ete.fleacircus.client.scaffold.place.ProxyListView;

public class SpecialtyListActivity extends AbstractProxyListActivity<SpecialtyProxy> implements IsScaffoldMobileActivity {

    private final ApplicationRequestFactory requests;

    public SpecialtyListActivity(ApplicationRequestFactory requests, ProxyListView<org.ete.fleacircus.client.managed.request.SpecialtyProxy> view, PlaceController placeController) {
        super(placeController, view, SpecialtyProxy.class);
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
        return "Specialities";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<org.ete.fleacircus.client.managed.request.SpecialtyProxy>> createRangeRequest(Range range) {
        return requests.specialtyRequest().findSpecialtyEntries(range.getStart(), range.getLength());
    }

    protected void fireCountRequest(Receiver<Long> callback) {
        requests.specialtyRequest().countSpecialities().fire(callback);
    }
}
