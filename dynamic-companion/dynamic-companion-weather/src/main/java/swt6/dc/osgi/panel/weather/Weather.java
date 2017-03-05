package swt6.dc.osgi.panel.weather;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
		content = "Sunny with a chance of meatballs";
		weatherPane = new VBox();
		Text t = new Text(content);
		t.maxWidth(100);
		HBox headerBox = new HBox();
		ImageView img = new ImageView(factory.getPanelIcon());
		img.setFitHeight(50);
		img.setFitWidth(50);
		headerBox.getChildren().add(img);
		headerBox.getChildren().add(new Label("Hagenberg"));
		weatherPane.getChildren().add(headerBox);
		weatherPane.getChildren().add(t);
		weatherPane.setMaxSize(100, 100);
		weatherPane.setId(getPanelType());
		weatherPane.setPadding(new Insets(10, 10, 10, 10));

	}

	@Override
	public Pane getPane() {
		return weatherPane;
	}

}
