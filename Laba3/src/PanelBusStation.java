import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelBusStation extends JPanel {
	 public  BusStation<ITransport> busstation;
	
	 public BusStation<ITransport> getBusStation() {
	        return busstation;
	 }

	 public PanelBusStation() {
	    	busstation = new BusStation<>(20, 615, 603);
	 }

	@Override 
	public void paint(Graphics g) { 
		super.paint(g); 
			if(busstation != null) {
				busstation.Draw(g);
			}
	}
}
