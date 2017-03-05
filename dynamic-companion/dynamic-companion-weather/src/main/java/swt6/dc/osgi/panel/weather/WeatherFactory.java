package swt6.dc.osgi.panel.weather;

import javafx.scene.image.Image;
import swt6.dc.osgi.panel.Panel;
import swt6.dc.osgi.panel.PanelFactory;

public class WeatherFactory implements PanelFactory {

	private Image icon;

	public WeatherFactory() {
		icon = new Image(this.getClass().getResourceAsStream("sunny.jpg"));
	}

	@Override
	public String getPanelType() {

		return "Weather";
	}

	@Override
	public Panel createPanel() {

		return new Weather(this);
	}

	@Override
	public Image getPanelIcon() {
		return icon;
	}

}
