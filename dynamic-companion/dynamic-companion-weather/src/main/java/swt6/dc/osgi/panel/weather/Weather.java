package swt6.dc.osgi.panel.weather;

import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import swt6.dc.osgi.panel.AbstractPanel;
import swt6.dc.osgi.panel.PanelFactory;

public class Weather extends AbstractPanel {

	private Pane weatherPane;

	public Weather(PanelFactory factory) {
		super(factory);
		content = "Some weather content";
		weatherPane = new VBox();
		weatherPane.getChildren().add(new Label("TownName"));
		weatherPane.getChildren().add(new Text(content));
		weatherPane.setMaxSize(100, 100);
		weatherPane.setStyle("-fx-border-style: solid; " + "-fx-boder-width: 2;");

	}

	@Override
	public Pane getPane() {
		return weatherPane;
	}

}
