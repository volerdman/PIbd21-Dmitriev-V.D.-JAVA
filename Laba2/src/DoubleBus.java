import java.awt.Color;
import java.awt.Graphics;

public class DoubleBus extends Bus {

	private Color DopColor;
	public Color getDopColor(){
		return DopColor;
	}
	public void setDopColor(Color value) {
		DopColor = value;
    }
	
	public DoubleBus(int maxSpeed, float weight, Color mainColor, Color dopColor) {
		super(maxSpeed, weight, mainColor);
        DopColor = dopColor;	
	}
	
	public void DrawBus(Graphics g) {
		g.setColor(DopColor);
		g.fillOval( (int)_startPosX , (int)_startPosY , 20, 40);
		g.fillOval( (int)_startPosX + 65, (int)_startPosY, 20, 40);
		g.fillOval( (int)_startPosX + 10, (int)_startPosY, 65, 25);
		g.fillRect((int)_startPosX + 12, (int)_startPosY, 62, 30);
		g.setColor(Color.BLUE);
		g.fillRect((int)_startPosX + 5, (int)_startPosY + 10, 10, 10);
		g.fillRect((int) _startPosX + 25,(int) _startPosY + 10, 10, 10);
		g.fillRect((int) _startPosX + 45,(int) _startPosY + 10, 10, 10);
		g.fillRect((int) _startPosX + 65,(int) _startPosY + 10, 10, 10);
		super.DrawBus(g);	
	}
}
