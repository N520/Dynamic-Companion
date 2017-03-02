package swt6.dc.osgi.panel;

import javafx.scene.image.Image;

public interface ShapeFactory {
  
  public Shape  createShape();
  public String getShapeType();
  public Image  getShapeIcon();
}
