package swt6.dc.osgi.panel.weather;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import swt6.dc.osgi.panel.PanelFactory;

public class WeatherActivator implements BundleActivator {

	@Override
	public void start(BundleContext ctx) throws Exception {
		ctx.registerService(PanelFactory.class, new WeatherFactory(), null);

	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
	}

}
