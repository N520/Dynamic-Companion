package swt6.dc.osgi.panel.traffic;

import javafx.scene.image.Image;
import swt6.dc.osgi.panel.Panel;
import swt6.dc.osgi.panel.PanelFactory;

public class TrafficFactory implements PanelFactory {

	public TrafficFactory() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getPanelType() {
		
		return "Traffic";
	}

	@Override
	public Panel createPanel() {
		
		return new Traffic(this);
	}

	@Override
	public Image getPanelIcon() {
		
		return null;
	}

}
