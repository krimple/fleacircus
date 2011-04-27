package org.ete.fleacircus.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.RequestContext;
import java.util.Set;
import org.ete.fleacircus.client.managed.request.ApplicationRequestFactory;
import org.ete.fleacircus.client.managed.request.FleaProxy;
import org.ete.fleacircus.client.managed.request.SpecialtyProxy;
import org.ete.fleacircus.client.managed.request.SpecialtyRequest;
import org.ete.fleacircus.client.managed.ui.FleaSetEditor;
import org.ete.fleacircus.client.managed.ui.SpecialtyDetailsView;
import org.ete.fleacircus.client.managed.ui.SpecialtyEditView;
import org.ete.fleacircus.client.managed.ui.SpecialtyListView;
import org.ete.fleacircus.client.managed.ui.SpecialtyMobileDetailsView;
import org.ete.fleacircus.client.managed.ui.SpecialtyMobileEditView;
import org.ete.fleacircus.client.scaffold.ScaffoldApp;
import org.ete.fleacircus.client.scaffold.place.CreateAndEditProxy;
import org.ete.fleacircus.client.scaffold.place.FindAndEditProxy;
import org.ete.fleacircus.client.scaffold.place.ProxyPlace;

public class SpecialtyActivitiesMapper {

    private final ApplicationRequestFactory requests;

    private final PlaceController placeController;

    public SpecialtyActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new SpecialtyDetailsActivity((EntityProxyId<SpecialtyProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? SpecialtyMobileDetailsView.instance() : SpecialtyDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }

    @SuppressWarnings("unchecked")
    private EntityProxyId<org.ete.fleacircus.client.managed.request.SpecialtyProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<SpecialtyProxy>) place.getProxyId();
    }

    private Activity makeCreateActivity() {
        SpecialtyEditView.instance().setCreating(true);
        final SpecialtyRequest request = requests.specialtyRequest();
        Activity activity = new CreateAndEditProxy<SpecialtyProxy>(SpecialtyProxy.class, request, ScaffoldApp.isMobile() ? SpecialtyMobileEditView.instance() : SpecialtyEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(SpecialtyProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new SpecialtyEditActivityWrapper(requests, ScaffoldApp.isMobile() ? SpecialtyMobileEditView.instance() : SpecialtyEditView.instance(), activity, null);
    }

    private Activity makeEditActivity(ProxyPlace place) {
        SpecialtyEditView.instance().setCreating(false);
        EntityProxyId<SpecialtyProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<SpecialtyProxy>(proxyId, requests, ScaffoldApp.isMobile() ? SpecialtyMobileEditView.instance() : SpecialtyEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(SpecialtyProxy proxy) {
                SpecialtyRequest request = requests.specialtyRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new SpecialtyEditActivityWrapper(requests, ScaffoldApp.isMobile() ? SpecialtyMobileEditView.instance() : SpecialtyEditView.instance(), activity, proxyId);
    }
}
