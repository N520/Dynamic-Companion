package swt6.dc.osgi.panel;

import javafx.scene.image.Image;

public interface PanelFactory {
	  public String getPanelType();
	  public Panel createPanel();
	  public Image  getPanelIcon();
}
