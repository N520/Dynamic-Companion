package swt6.dc.osgi.panel.traffic;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import swt6.dc.osgi.panel.AbstractPanel;
import swt6.dc.osgi.panel.PanelFactory;

public class Traffic extends AbstractPanel {

	private Pane trafficPane;
	
	public Traffic(PanelFactory factory) {
		super(factory);
		content = "some traffic related content";
		Text t = new Text(content);
		t.maxWidth(100);
		trafficPane = new VBox();
		trafficPane.getChildren().add(new Label(factory.getPanelType()));
		trafficPane.getChildren().add(t);
		trafficPane.setMaxSize(100, 100);
		trafficPane.setId(factory.getPanelType());
		
		
	}

	@Override
	public Pane getPane() {
		return trafficPane;
	}

}
