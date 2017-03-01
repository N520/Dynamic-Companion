package swt6.osgi.paint;

import java.util.logging.LogManager;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.util.tracker.ServiceTracker;

import swt6.osgi.shape.ShapeFactory;
//import swt6.osgi.shape.rectangle.RectangleFactory; v1 requires import
import swt6.util.JavaFxUtils;

public class PaintActivator implements BundleActivator {
	private PaintWindow paintWindow;

	// v2
	private ServiceTracker<ShapeFactory, ShapeFactory> shapeTracker;

	@Override
	public void start(BundleContext ctx) throws Exception {
		LogManager.getLogManager().reset(); // turn off JDK logging
		JavaFxUtils.initJavaFx();
		startUI(ctx);

		// v2
		shapeTracker = new ServiceTracker<>(ctx, ShapeFactory.class, new ShapeTrackerCustomizer(ctx, paintWindow));

		shapeTracker.open();
	}

	private void startUI(BundleContext arg0) {
		paintWindow = new PaintWindow();
		paintWindow.addOnCloseEventHandler(evt -> {
			try {
				arg0.getBundle().stop();
			} catch (BundleException e) {
				e.printStackTrace();
			}
		});
		paintWindow.show();

		// v1
		// paintWindow.addShapeFactory(new RectangleFactory());
		// paintWindow.addShapeFactory(new CircleFactory());
		// paintWindow.addShapeFactory(new LineFactory());
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		stopUi(arg0);

		// v2
		shapeTracker.close();

	}

	private void stopUi(BundleContext arg0) {
		if (paintWindow != null)
			paintWindow.close();
	}
	
}
