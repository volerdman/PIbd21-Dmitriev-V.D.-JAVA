import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class BusStation <T extends ITransport> {
	private ArrayList<T> _places;
	private int PictureWidth;
    private int PictureHeight;
    private int _placeSizeWidth = 210;
    private int _placeSizeHeight = 80;
    
    public BusStation( int sizes, int pictureWidth, int pictureHeight)
    {
        _places = new ArrayList<T>();
        PictureWidth = pictureWidth;
        PictureHeight = pictureHeight;
        for (int i = 0; i < sizes; i++)
        {
            _places.add (null);
        }
    }
    
    public int Plus(T bus)
    {
        for (int i = 0; i < _places.size(); i++)
        {
            if (CheckFreePlace(i))
            {
                _places.add(i, bus);
                _places.get(i).SetPosition(10 + i / 5 * _placeSizeWidth + 5, i % 5 * _placeSizeHeight + 20, PictureWidth, PictureHeight);
                return i;
            }
        }
        return -1;
    }
    
    public  T Minus( int index)
    {	    	
        if (index < 0 || index > _places.size())
        {
            return null;
        }
        if (!CheckFreePlace(index))
        {
            T ship = _places.get(index);
            _places.set(index, null);
            return ship;
        }
        return null;
    }
    
    private boolean CheckFreePlace(int index)
    {
        return _places.get(index) == null;
    }
    
    public void Draw(Graphics g)
    {
        DrawMarking(g);
        for (int i = 0; i < _places.size(); i++)
        {
            if (!CheckFreePlace(i))
            {//если место не пустое      
                _places.get(i).DrawBus(g);
            }
        }
    }
    
    private void DrawMarking(Graphics g)
	{
	Color newColor3 = new Color(0, 0, 0);
	g.setColor(newColor3);         
        g.drawRect(0, 0, (_places.size() / 5) * _placeSizeWidth, 480);
        for (int i = 0; i < _places.size() / 5; i++)
        {
            for (int j = 0; j < 6; ++j)
            {
                g.drawRect(i * _placeSizeWidth, j * _placeSizeHeight, 110, 5 );
                Color nc = new Color(200,200,200);
        	g.setColor(nc);
                g.fillRect(i * _placeSizeWidth, j * _placeSizeHeight, 110, 5);
            }
    		g.setColor(newColor3);
            g.drawLine( i * _placeSizeWidth, 0, i * _placeSizeWidth, 400);
        }
    }
}
