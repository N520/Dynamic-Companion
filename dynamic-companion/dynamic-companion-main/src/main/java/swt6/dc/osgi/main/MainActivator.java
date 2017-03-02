package swt6.dc.osgi.main;

import java.util.logging.LogManager;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import swt6.dc.osgi.panel.PanelFactory;
//import swt6.osgi.shape.rectangle.RectangleFactory; v1 requires import
import swt6.util.JavaFxUtils;

public class MainActivator implements BundleActivator {
	private ContainerWindow containerWindow;

	// v2
	private ServiceTracker<PanelFactory, PanelFactory> shapeTracker;

	@Override
	public void start(BundleContext ctx) throws Exception {
		LogManager.getLogManager().reset(); // turn off JDK logging
		JavaFxUtils.initJavaFx();
		startUI(ctx);

		// v2
		shapeTracker = new ServiceTracker<PanelFactory, PanelFactory>(ctx, PanelFactory.class,
				new PanelTrackerCustomizer(ctx, containerWindow));

		shapeTracker.open();
	}

	private void startUI(BundleContext arg0) {
		containerWindow = new ContainerWindow();
		containerWindow.show();

	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		stopUi(arg0);

		shapeTracker.close();

	}

	private void stopUi(BundleContext arg0) {
		if (containerWindow != null)
			containerWindow.close();
	}

}
