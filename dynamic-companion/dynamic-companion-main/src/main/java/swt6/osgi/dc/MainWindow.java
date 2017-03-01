package swt6.osgi.dc;

import java.util.concurrent.ExecutionException;

import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import swt6.util.JavaFxUtils;

public class MainWindow {

	private Stage stage;
	private ToolBar toolBar;
	private FlowPane flowPane;
	private VBox rootPane;

	public MainWindow() {
		toolBar = new ToolBar();
		flowPane = new FlowPane();
		rootPane = new VBox(toolBar, flowPane);

	}

	public void show() {

		if (stage == null) {
			stage = new Stage();
			stage.setScene(new Scene(rootPane, 500, 500));
			stage.setMinWidth(250);
			stage.setMinHeight(250);

			stage.setTitle("Simple Paint Application (non-modular)");
		}
		stage.show();

	}

	public void close() {
		try {
			JavaFxUtils.runAndWait(() -> {
				if (stage != null)
					stage.close();
			});
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
