package swt6.dc.osgi.main;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import swt6.dc.osgi.panel.ShapeFactory;

public class ShapeTrackerCustomizer implements ServiceTrackerCustomizer<ShapeFactory, ShapeFactory> {

	private BundleContext ctx;
	private PaintWindow window;

	public ShapeTrackerCustomizer(BundleContext ctx, PaintWindow window) {
		this.ctx = ctx;
		this.window = window;
	}

	@Override
	public ShapeFactory addingService(ServiceReference<ShapeFactory> arg0) {
		ShapeFactory sf = ctx.getService(arg0);
		window.addShapeFactory(sf);
		return sf;
	}

	@Override
	public void modifiedService(ServiceReference<ShapeFactory> arg0, ShapeFactory arg1) {
		window.removeShapeFactory(arg1);
		window.addShapeFactory(arg1);
	}

	@Override
	public void removedService(ServiceReference<ShapeFactory> arg0, ShapeFactory arg1) {
		window.removeShapeFactory(arg1);

	}

}
