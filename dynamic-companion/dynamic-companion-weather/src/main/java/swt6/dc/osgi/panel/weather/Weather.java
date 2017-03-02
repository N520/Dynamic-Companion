package swt6.dc.osgi.panel.weather;

import javafx.scene.control.Label;
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
		Text t = new Text(content);
		t.maxWidth(100);
		weatherPane.getChildren().add(new Label("TownName"));
		weatherPane.getChildren().add(t);
		weatherPane.setMaxSize(100, 100);
		weatherPane.setStyle("-fx-border-style: solid; " + "-fx-boder-width: 2;");
		weatherPane.setId(getPanelType());
	}

	@Override
	public Pane getPane() {
		return weatherPane;
	}

}
