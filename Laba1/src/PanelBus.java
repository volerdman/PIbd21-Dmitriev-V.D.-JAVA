import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelBus extends JPanel {
	public static Bus bus;
	public static boolean initialization = false;
	/**
	 * Create the panel.
	 */
	public void paint(Graphics g) { 
		super.paint(g); 
		if(initialization) {
			bus.DrawBus(g);
		}
	}
}
