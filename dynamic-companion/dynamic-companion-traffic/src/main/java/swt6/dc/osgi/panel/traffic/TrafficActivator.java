package swt6.dc.osgi.panel.traffic;

import java.util.Dictionary;
import java.util.concurrent.Executors;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.util.tracker.ServiceTracker;

import swt6.dc.osgi.panel.PanelFactory;

public class TrafficActivator implements BundleActivator {

	ServiceTracker<EventAdmin, EventAdmin> eventAdminTracker;

	@Override
	public void start(BundleContext ctx) throws Exception {
		// Thread.sleep(5000);
		ctx.registerService(PanelFactory.class, new TrafficFactory(), null);
		eventAdminTracker = new ServiceTracker<>(ctx, EventAdmin.class, null);
		eventAdminTracker.open();

		EventAdmin eventAdmin = eventAdminTracker.getService();

		if (eventAdmin != null) {

			eventAdmin.postEvent(
					new Event("dc/traffic/trafficIsOnline" + System.currentTimeMillis(), (Dictionary<String, ?>) null));

		}

	}

	@Override
	public void stop(BundleContext ctx) throws Exception {
		EventAdmin eventAdmin = eventAdminTracker.getService();

		if (eventAdmin != null) {

			eventAdmin.postEvent(new Event("dc/traffic/trafficIsOffline" + System.currentTimeMillis(),
					(Dictionary<String, ?>) null));

		}
		eventAdminTracker.close();

	}

}
