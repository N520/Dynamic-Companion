package swt6.dc.osgi.main;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import swt6.dc.osgi.panel.PanelFactory;

public class PanelTrackerCustomizer implements ServiceTrackerCustomizer<PanelFactory, PanelFactory> {

	private BundleContext ctx;
	private ContainerWindow window;

	public PanelTrackerCustomizer(BundleContext ctx, ContainerWindow window) {
		this.ctx = ctx;
		this.window = window;
	}

	@Override
	public PanelFactory addingService(ServiceReference<PanelFactory> arg0) {
		PanelFactory pf = ctx.getService(arg0);
		window.addPanelFactory(pf);
		return pf;
	}

	@Override
	public void modifiedService(ServiceReference<PanelFactory> arg0, PanelFactory arg1) {
		window.removePanelFactory(arg1);
		window.addPanelFactory(arg1);
	}

	@Override
	public void removedService(ServiceReference<PanelFactory> arg0, PanelFactory arg1) {
		window.removePanelFactory(arg1);

	}

}
