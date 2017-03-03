package swt6.dc.osgi.panel.weather;

import java.util.Date;
import java.util.Dictionary;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.util.tracker.ServiceTracker;

import swt6.dc.osgi.panel.PanelFactory;

public class WeatherActivator implements BundleActivator {
	ServiceTracker<EventAdmin, EventAdmin> eventAdminTracker;

	@Override
	public void start(BundleContext ctx) throws Exception {
		ctx.registerService(PanelFactory.class, new WeatherFactory(), null);
		eventAdminTracker = new ServiceTracker<>(ctx, EventAdmin.class, null);
		eventAdminTracker.open();

		EventAdmin eventAdmin = eventAdminTracker.getService();

		if (eventAdmin != null) {

			eventAdmin.postEvent(
					new Event("dc/weather/weatherIsOnline" + System.currentTimeMillis(),(Dictionary<String, ?>) null));

		}
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		EventAdmin eventAdmin = eventAdminTracker.getService();

		if (eventAdmin != null) {

			eventAdmin.postEvent(new Event("dc/traffic/trafficIsOffline" +System.currentTimeMillis(),
					(Dictionary<String, ?>) null));

		}
		eventAdminTracker.close();
	}

}
