package org.ete.fleacircus.client.scaffold.ioc;

import org.ete.fleacircus.client.scaffold.ScaffoldApp;
import com.google.gwt.inject.client.Ginjector;

public interface ScaffoldInjector extends Ginjector {

	ScaffoldApp getScaffoldApp();
}
