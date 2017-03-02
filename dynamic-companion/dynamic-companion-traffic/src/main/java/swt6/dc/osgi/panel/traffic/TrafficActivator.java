package swt6.dc.osgi.panel.traffic;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import swt6.dc.osgi.panel.PanelFactory;

public class TrafficActivator implements BundleActivator {

	@Override
	public void start(BundleContext ctx) throws Exception {
		Thread.sleep(5000);
		ctx.registerService(PanelFactory.class, new TrafficFactory(), null);
		
	}

	@Override
	public void stop(BundleContext ctx) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
