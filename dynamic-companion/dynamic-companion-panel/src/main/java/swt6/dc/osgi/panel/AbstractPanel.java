package swt6.dc.osgi.panel;

public abstract class AbstractPanel implements Panel {
	private PanelFactory factory;
	protected String content;
	
	public AbstractPanel(PanelFactory factory) {
		this.factory = factory;
		content = "some Content";
	}

	public String getContent() {
		return content;
	}	
	
	@Override
	public String getPanelType() {
		return factory.getPanelType();
	}
	
}
