import java.awt.Color;
import java.awt.Graphics;

public class Bus extends PublicTransport {
	protected int busWidth = 100;
	protected int busHeight = 60;
	
	public Bus(int maxSpeed, float weight, Color mainColor) {
		MaxSpeed = maxSpeed;
	    Weight = weight;
	    MainColor = mainColor;
	}

	public void MoveTransport(Direction direction) {

		float step = getMaxSpeed() * 100 / getWeight();
		switch (direction) {
		case Right:
			if (_startPosX + step < _pictureWidth - busWidth) {
				_startPosX += step;
			}
			break;
		case Left:
			if (_startPosX - step > 0) {
				_startPosX -= step;
			}
			break;
		case Up:
			if (_startPosY - step - 10 > 0) {
				_startPosY -= step;
			}
			break;
		case Down:
			if (_startPosY + step < _pictureHeight - busHeight) {
				_startPosY += step;
			}
			break;
		}
	}
	
	public void DrawBus(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval((int) _startPosX + 11,(int) _startPosY + 40, 12, 12);
		g.fillOval( (int)_startPosX + 71,(int) _startPosY + 40, 12, 12);
		
		g.setColor(MainColor);
		g.fillRect( (int)_startPosX + 1, (int)_startPosY + 25, 84, 20);
		g.fillRect( (int)_startPosX + 1, (int)_startPosY + 22, 84, 2);

		g.setColor(Color.GRAY);
		g.fillOval( (int)_startPosX + 13,(int) _startPosY + 42, 8, 8);
		g.fillOval((int) _startPosX + 73,(int) _startPosY + 42, 8, 8);
		g.fillRect((int)_startPosX + 82,(int) _startPosY + 25, 86, 10);
		
		g.setColor(Color.BLUE);
		g.fillRect( (int)_startPosX + 5, (int)_startPosY + 27, 10, 10);
		g.fillRect( (int)_startPosX + 25, (int)_startPosY + 27, 10, 10);
		g.fillRect((int) _startPosX + 45,(int) _startPosY + 27, 10, 10);
		g.fillRect((int) _startPosX + 68,(int) _startPosY + 25, 12, 12);
	}
}
