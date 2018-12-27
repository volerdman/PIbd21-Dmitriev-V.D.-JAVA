import java.awt.Graphics;
import javax.swing.JList;
import javax.swing.JPanel;

public class PanelBusStation extends JPanel {
	private MultiLevelBusStation station;
	private JList listBoxLevels;
	private final int countLevel = 5;
	
	public  MultiLevelBusStation getBusStation() {
        return station;
	}
	
    public PanelBusStation() {
    	station = new MultiLevelBusStation(countLevel, 615, 603);
    }
	
    public void setListLevels(JList listBoxLevels) {
        this.listBoxLevels = listBoxLevels;
    }
    
	@Override 
	public void paint(Graphics g) { 
		super.paint(g); 
		int selectedLevel = listBoxLevels.getSelectedIndex();
		station.getBusStation(selectedLevel).Draw(g);
		if(selectedLevel != -1){
			if(station != null) {
				station.getBusStation(selectedLevel).Draw(g);
			}
		}		
	}
}
