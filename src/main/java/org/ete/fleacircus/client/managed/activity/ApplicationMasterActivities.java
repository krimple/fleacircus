package org.ete.fleacircus.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import org.ete.fleacircus.client.managed.request.ApplicationEntityTypesProcessor;
import org.ete.fleacircus.client.managed.request.ApplicationRequestFactory;
import org.ete.fleacircus.client.managed.request.FleaProxy;
import org.ete.fleacircus.client.managed.request.SpecialtyProxy;
import org.ete.fleacircus.client.managed.ui.FleaListView;
import org.ete.fleacircus.client.managed.ui.FleaMobileListView;
import org.ete.fleacircus.client.managed.ui.SpecialtyListView;
import org.ete.fleacircus.client.managed.ui.SpecialtyMobileListView;
import org.ete.fleacircus.client.scaffold.ScaffoldApp;
import org.ete.fleacircus.client.scaffold.place.ProxyListPlace;

public final class ApplicationMasterActivities extends ApplicationMasterActivities_Roo_Gwt {

    @Inject
    public ApplicationMasterActivities(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }
}
