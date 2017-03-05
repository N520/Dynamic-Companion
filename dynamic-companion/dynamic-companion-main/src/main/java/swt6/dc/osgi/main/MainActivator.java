package swt6.dc.osgi.main;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.LogManager;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

import swt6.dc.osgi.panel.PanelFactory;
import swt6.util.JavaFxUtils;

public class MainActivator implements BundleActivator {
	private ContainerWindow containerWindow;
	// v2
	private ServiceTracker<PanelFactory, PanelFactory> shapeTracker;
	private ServiceTracker<LogService, LogService> logTracker;

	@Override
	public void start(BundleContext ctx) throws Exception {
		LogManager.getLogManager().reset(); // turn off JDK logging
		JavaFxUtils.initJavaFx();
		startUI(ctx);

		logTracker = new ServiceTracker<>(ctx, LogService.class.getName(), null);

		// v2
		shapeTracker = new ServiceTracker<PanelFactory, PanelFactory>(ctx, PanelFactory.class,
				new PanelTrackerCustomizer(ctx, containerWindow));

		shapeTracker.open();
		logTracker.open();
		LogService logService = logTracker.getService();

		if (logService != null)
			logService.log(LogService.LOG_INFO, "Yee ha, I'm logging!");

		String[] topics = new String[] { EventConstants.EVENT_TOPIC, "dc/*" };

		Dictionary<String, Object> ht = new Hashtable<String, Object>();
		ht.put(EventConstants.EVENT_TOPIC, topics);

		ctx.registerService(EventHandler.class.getName(), new EventHandler() {
			@Override
			public void handleEvent(Event event) {
				if (logService != null) {
					logService.log(LogService.LOG_INFO, "handle Event " + event);
				}

			}
		}, ht);

	}

	private void startUI(BundleContext arg0) {
		containerWindow = new ContainerWindow();
		containerWindow.show();

	}

	@Override
	public void stop(BundleContext ctx) throws Exception {
		stopUi(ctx);

		ServiceReference<LogService> logRef = ctx.getServiceReference(LogService.class);
		LogService logservice = ctx.getService(logRef);

		if (logservice != null)
			logservice.log(LogService.LOG_INFO, "Shuting down");

		shapeTracker.close();
		logTracker.close();
	}

	private void stopUi(BundleContext arg0) {
		if (containerWindow != null)
			containerWindow.close();
	}

}
