package swt6.dc.osgi.panel.weather;

import javafx.scene.image.Image;
import swt6.dc.osgi.panel.Shape;
import swt6.dc.osgi.panel.ShapeFactory;

public class RectangleFactory implements ShapeFactory {

  private Image icon;
  
  public RectangleFactory() {
    icon = new Image(this.getClass().getResourceAsStream("rectangle.png"));
  }

  @Override
  public Shape createShape() {
    return new Rectangle(this);
  }

  @Override
  public String getShapeType() {
    return "Rectangle";
  }

  @Override
  public Image getShapeIcon() {
    return icon;
  }

}
