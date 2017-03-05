package swt6.dc.osgi.panel.traffic;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
		HBox headerBox = new HBox();
		ImageView img = new ImageView(factory.getPanelIcon());
		img.setFitHeight(50);
		img.setFitWidth(50);
		headerBox.getChildren().add(img);
		headerBox.getChildren().add(new Label("Traffic -- Hagenberg"));

		trafficPane = new VBox();
		trafficPane.getChildren().add(headerBox);
		trafficPane.getChildren().add(t);
		trafficPane.setMaxSize(100, 100);
		trafficPane.setId(factory.getPanelType());
		trafficPane.setPadding(new Insets(10, 10, 10, 10));

	}

	@Override
	public Pane getPane() {
		return trafficPane;
	}

}
