package org.ete.fleacircus.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.RequestContext;
import java.util.Set;
import org.ete.fleacircus.client.managed.request.ApplicationRequestFactory;
import org.ete.fleacircus.client.managed.request.FleaProxy;
import org.ete.fleacircus.client.managed.request.FleaRequest;
import org.ete.fleacircus.client.managed.request.SpecialtyProxy;
import org.ete.fleacircus.client.managed.ui.FleaDetailsView;
import org.ete.fleacircus.client.managed.ui.FleaEditView;
import org.ete.fleacircus.client.managed.ui.FleaListView;
import org.ete.fleacircus.client.managed.ui.FleaMobileDetailsView;
import org.ete.fleacircus.client.managed.ui.FleaMobileEditView;
import org.ete.fleacircus.client.managed.ui.SpecialtySetEditor;
import org.ete.fleacircus.client.scaffold.ScaffoldApp;
import org.ete.fleacircus.client.scaffold.place.CreateAndEditProxy;
import org.ete.fleacircus.client.scaffold.place.FindAndEditProxy;
import org.ete.fleacircus.client.scaffold.place.ProxyPlace;

public class FleaActivitiesMapper {

    private final ApplicationRequestFactory requests;

    private final PlaceController placeController;

    public FleaActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new FleaDetailsActivity((EntityProxyId<FleaProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? FleaMobileDetailsView.instance() : FleaDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }

    @SuppressWarnings("unchecked")
    private EntityProxyId<org.ete.fleacircus.client.managed.request.FleaProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<FleaProxy>) place.getProxyId();
    }

    private Activity makeCreateActivity() {
        FleaEditView.instance().setCreating(true);
        final FleaRequest request = requests.fleaRequest();
        Activity activity = new CreateAndEditProxy<FleaProxy>(FleaProxy.class, request, ScaffoldApp.isMobile() ? FleaMobileEditView.instance() : FleaEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(FleaProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new FleaEditActivityWrapper(requests, ScaffoldApp.isMobile() ? FleaMobileEditView.instance() : FleaEditView.instance(), activity, null);
    }

    private Activity makeEditActivity(ProxyPlace place) {
        FleaEditView.instance().setCreating(false);
        EntityProxyId<FleaProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<FleaProxy>(proxyId, requests, ScaffoldApp.isMobile() ? FleaMobileEditView.instance() : FleaEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(FleaProxy proxy) {
                FleaRequest request = requests.fleaRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new FleaEditActivityWrapper(requests, ScaffoldApp.isMobile() ? FleaMobileEditView.instance() : FleaEditView.instance(), activity, proxyId);
    }
}
