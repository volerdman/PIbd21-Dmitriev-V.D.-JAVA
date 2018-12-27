import java.awt.Color;
import java.awt.Graphics;

public class Bus {
	private float _startPosX;
	private float _startPosY;
	private int _pictureWidth;
	private int _pictureHeight;
	private int busWidth = 100;
	private int busHeight = 60;
	private int MaxSpeed;
	private boolean SecondFloor;
	
	public boolean getSecondFloor() {
		return SecondFloor;
	}
	private void setSecondFloor(boolean value) {
		SecondFloor = value;
	}
	
	public int getMaxSpeed(){
		return MaxSpeed;
	}
	private void setMaxSpeed(int value){
		MaxSpeed = value;
	}
	
	private float Weight;
	public float getWeight(){
		return Weight;
	}	
	private void setWeight(float value){
	Weight = value;
	}
	
	private Color MainColor;
	public Color getMainColor(){
		return MainColor;
	}
	private void setMainColor(Color value){
	MainColor = value;
	}
	
	
	private Color DopColor;
	public Color getDopColor(){
		return DopColor;
	}
	private void setDopColor(Color value){
	DopColor = value;
	}
	
	private boolean Check;
	public boolean getCheck(){
		return Check;
	}
	private void setCheck(boolean value){
	Check = value;
	}
	
	public Bus(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean floor,boolean check) {
		setMaxSpeed (maxSpeed);
		setWeight(weight);
		setMainColor(mainColor);
		setDopColor (dopColor);
		setSecondFloor(floor);
		setCheck(check);
	}

	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
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
		   	 
		if(SecondFloor==true) {
			
			g.setColor(DopColor);
			g.fillOval( (int)_startPosX , (int)_startPosY , 20, 40);
			g.fillOval( (int)_startPosX + 65, (int)_startPosY, 20, 40);
			g.fillOval( (int)_startPosX + 10, (int)_startPosY, 65, 25);
			g.fillRect((int)_startPosX + 12, (int)_startPosY, 62, 30);
			if (Check == true) {
				
				g.setColor(Color.BLUE);
			}else {
				g.setColor(Color.BLACK);
			}	
			g.fillRect((int)_startPosX + 5, (int)_startPosY + 10, 10, 10);
			g.fillRect((int) _startPosX + 25,(int) _startPosY + 10, 10, 10);
			g.fillRect((int) _startPosX + 45,(int) _startPosY + 10, 10, 10);
			g.fillRect((int) _startPosX + 65,(int) _startPosY + 10, 10, 10);
		}
		
		
		g.setColor(Color.BLACK);
		g.drawRect( (int)_startPosX + 5, (int)_startPosY + 27, 10, 10);
		g.drawRect( (int)_startPosX + 25, (int)_startPosY + 27, 10, 10);
		g.drawRect((int) _startPosX + 45,(int) _startPosY + 27, 10, 10);
		g.drawRect((int) _startPosX + 68,(int) _startPosY + 25, 12, 12);
		g.fillOval((int) _startPosX + 11,(int) _startPosY + 40, 12, 12);
		g.fillOval( (int)_startPosX + 71,(int) _startPosY + 40, 12, 12);
		
		g.setColor(MainColor);
		g.fillRect( (int)_startPosX + 1, (int)_startPosY + 25, 84, 20);
		g.fillRect( (int)_startPosX + 1, (int)_startPosY + 22, 84, 2);

		g.setColor(Color.GRAY);
		g.fillOval( (int)_startPosX + 13,(int) _startPosY + 42, 8, 8);
		g.fillOval((int) _startPosX + 73,(int) _startPosY + 42, 8, 8);
		g.fillRect((int)_startPosX + 82,(int) _startPosY + 25, 86, 10);
		
		
		if (Check == true) {
			
			g.setColor(Color.BLUE);
		}else {
			g.setColor(Color.BLACK);
		}		
		g.fillRect((int) _startPosX + 5, (int)_startPosY + 27, 10, 10);
		g.fillRect((int) _startPosX + 25,(int) _startPosY + 27, 10, 10);
		g.fillRect((int) _startPosX + 45,(int) _startPosY + 27, 10, 10);
		g.fillRect((int) _startPosX + 68, (int)_startPosY + 25, 12, 12);
		
	}
}
