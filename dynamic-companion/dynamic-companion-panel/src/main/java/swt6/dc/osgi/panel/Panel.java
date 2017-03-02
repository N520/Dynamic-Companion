package swt6.dc.osgi.panel;

import javafx.scene.layout.Pane;

public interface Panel {
	  public String getPanelType();
	  public String getContent();
	  public Pane getPane();
}
