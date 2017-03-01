package swt6.osgi.dc;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import swt6.util.JavaFxUtils;

public class DCActivator implements BundleActivator {

	private MainWindow mainWindow;
	
	@Override
	public void start(BundleContext ctx) throws Exception {
		JavaFxUtils.initJavaFx();
		startUI(ctx);		
		
	}

	private void startUI(BundleContext ctx) {
		mainWindow = new MainWindow();
		
		mainWindow.show();
	}

	@Override
	public void stop(BundleContext ctx) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
