package swt6.dc.osgi.panel.weather;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import swt6.dc.osgi.panel.ShapeFactory;

public class RectangleActivator implements BundleActivator {

	@Override
	public void start(BundleContext ctx) throws Exception {
		ctx.registerService(ShapeFactory.class, new RectangleFactory(), null);

	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
	}

}
