import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelBus extends JPanel {
	public static ITransport bus;
	public static boolean initialization = false;
	/**
	 * Create the panel.
	 */
	
	void setBus(ITransport transport) 
	{
        bus = transport;
    }
	
	public void paint(Graphics g) { 
		super.paint(g); 
		if(bus!=null) {
			bus.DrawBus(g);
		}
	}
}
