package org.ete.fleacircus.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.RequestContext;
import org.ete.fleacircus.client.managed.request.ApplicationRequestFactory;
import org.ete.fleacircus.client.managed.request.EventProxy;
import org.ete.fleacircus.client.managed.request.EventRequest;
import org.ete.fleacircus.client.managed.ui.EventDetailsView;
import org.ete.fleacircus.client.managed.ui.EventEditView;
import org.ete.fleacircus.client.managed.ui.EventListView;
import org.ete.fleacircus.client.managed.ui.EventMobileDetailsView;
import org.ete.fleacircus.client.managed.ui.EventMobileEditView;
import org.ete.fleacircus.client.scaffold.ScaffoldApp;
import org.ete.fleacircus.client.scaffold.place.CreateAndEditProxy;
import org.ete.fleacircus.client.scaffold.place.FindAndEditProxy;
import org.ete.fleacircus.client.scaffold.place.ProxyPlace;

public class EventActivitiesMapper {

    private final ApplicationRequestFactory requests;

    private final PlaceController placeController;

    public EventActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new EventDetailsActivity((EntityProxyId<EventProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? EventMobileDetailsView.instance() : EventDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }

    @SuppressWarnings("unchecked")
    private EntityProxyId<org.ete.fleacircus.client.managed.request.EventProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<EventProxy>) place.getProxyId();
    }

    private Activity makeCreateActivity() {
        EventEditView.instance().setCreating(true);
        final EventRequest request = requests.eventRequest();
        Activity activity = new CreateAndEditProxy<EventProxy>(EventProxy.class, request, ScaffoldApp.isMobile() ? EventMobileEditView.instance() : EventEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(EventProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new EventEditActivityWrapper(requests, ScaffoldApp.isMobile() ? EventMobileEditView.instance() : EventEditView.instance(), activity, null);
    }

    private Activity makeEditActivity(ProxyPlace place) {
        EventEditView.instance().setCreating(false);
        EntityProxyId<EventProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<EventProxy>(proxyId, requests, ScaffoldApp.isMobile() ? EventMobileEditView.instance() : EventEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(EventProxy proxy) {
                EventRequest request = requests.eventRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new EventEditActivityWrapper(requests, ScaffoldApp.isMobile() ? EventMobileEditView.instance() : EventEditView.instance(), activity, proxyId);
    }
}
