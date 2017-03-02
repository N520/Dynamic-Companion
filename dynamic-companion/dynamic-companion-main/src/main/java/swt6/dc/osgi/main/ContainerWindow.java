package swt6.dc.osgi.main;

import java.util.concurrent.ExecutionException;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import swt6.dc.osgi.panel.PanelFactory;
import swt6.dc.osgi.panel.ShapeFactory;
import swt6.util.JavaFxUtils;

public class ContainerWindow {
	private ToolBar toolBar;
	private VBox rootPane;
	private FlowPane flowPane;
	private Stage stage;

	public ContainerWindow() {
		try {
			JavaFxUtils.runAndWait(() -> {
				toolBar = new ToolBar();
				flowPane = new FlowPane();
				flowPane.setVgap(20);
				flowPane.setHgap(20);
				rootPane = new VBox(toolBar, flowPane);
			});
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void show() {
		try {
			JavaFxUtils.runAndWait(() -> {
				if (stage == null) {
					stage = new Stage();
					stage.setScene(new Scene(rootPane, 250, 250));
					stage.setMinWidth(100);
					stage.setMinHeight(100);
					stage.setTitle("Dynamic Companion");
				}
				stage.show();
			});
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public void addPanelFactory(PanelFactory pf) {
		try {
			JavaFxUtils.runAndWait(() -> {
				// multiple shape factories of the same type are not allowed.
				// if (getShapeFactoryByName(sf.getShapeType()) != null)
				// return;
				//
				// // update shape factory collection
				// shapeFactories.add(sf);
				// if (currentShapeFactory == null)
				// setCurrentShapeFactory(sf);

				// TODO create panel from factory and append it to parent
				flowPane.getChildren().add(pf.createPanel().getPane());

				// add toolbar button
				ToggleButton button = new ToggleButton(pf.getPanelType());
				button.setTooltip(new Tooltip(pf.getPanelType()));
				button.setGraphic(new ImageView(pf.getPanelIcon()));
				button.setUserData(pf.getPanelType());
				// button.setOnAction(evt -> toolbarButtonPressed(evt));
				toolBar.getItems().add(button);
			});
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removePanelFactory(PanelFactory pf) {
		try {
			JavaFxUtils.runAndWait(() -> {
				// String name = sf.getShapeType();
				//
				// // remove shape factory by name
				// Iterator<ShapeFactory> sfit = shapeFactories.iterator();
				// while (sfit.hasNext())
				// if (sfit.next().getShapeType().equals(name))
				// sfit.remove();
				//
				// remove toolbar item for shape factory.
				toolBar.getItems().remove(getToolBarButtonByName(pf.getPanelType()));

				Node nodeToRemove = null;

				for (Node p : flowPane.getChildren()) {
					if (p.getId() != null && p.getId().equals(pf.getPanelType())) {
						nodeToRemove = p;
						break;
					}
				}

				if (nodeToRemove != null)
					flowPane.getChildren().remove(nodeToRemove);

				// TODO remove corresponding panel

			});
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ToggleButton getToolBarButtonByName(String name) {
		for (Node n : toolBar.getItems())
			if (name.equals(n.getUserData()))
				return (ToggleButton) n;

		return null;
	}

}
