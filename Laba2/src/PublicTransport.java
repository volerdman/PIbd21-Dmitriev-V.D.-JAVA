import java.awt.Color;
import java.awt.Graphics;

public abstract class PublicTransport implements ITransport {
	protected float _startPosX;
    protected float _startPosY;
    protected int _pictureWidth;
    protected int _pictureHeight;
    protected int MaxSpeed;
	public int getMaxSpeed(){
		return MaxSpeed;
	}
	protected void setMaxSpeed(int MaxSpeed){
		this.MaxSpeed = MaxSpeed;
	}
	protected float Weight;
	public float getWeight(){
		return Weight;
	}
	protected void setWeight(int Weight){
		this.Weight = Weight;
	}
	protected Color MainColor;
	public Color getMainColor(){
		return MainColor;
	}
	protected void setMainColor(Color MainColor){
		this.MainColor = MainColor;
	}
	public void SetPosition(int x, int y, int width, int height)
	    {
	        _startPosX = x;
	        _startPosY = y;
	        _pictureWidth = width;
	        _pictureHeight = height;
	    }

	public abstract void DrawBus(Graphics g);

	public abstract void MoveTransport(Direction direction);
}
