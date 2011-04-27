package org.ete.fleacircus.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import java.util.HashSet;
import java.util.Set;
import org.ete.fleacircus.client.managed.request.FleaProxy;
import org.ete.fleacircus.client.managed.request.SpecialtyProxy;
import org.ete.fleacircus.client.managed.ui.SpecialtyListView.Binder;
import org.ete.fleacircus.client.scaffold.place.AbstractProxyListView;

public class SpecialtyListView extends SpecialtyListView_Roo_Gwt {

    private static final Binder BINDER = GWT.create(Binder.class);

    private static org.ete.fleacircus.client.managed.ui.SpecialtyListView instance;

    @UiField
    Button newButton;

    public SpecialtyListView() {
        init(BINDER.createAndBindUi(this), table, newButton);
        table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);
        init();
    }

    public static org.ete.fleacircus.client.managed.ui.SpecialtyListView instance() {
        if (instance == null) {
            instance = new SpecialtyListView();
        }
        return instance;
    }

    public String[] getPaths() {
        return paths.toArray(new String[paths.size()]);
    }

    interface Binder extends UiBinder<HTMLPanel, SpecialtyListView> {
    }
}
