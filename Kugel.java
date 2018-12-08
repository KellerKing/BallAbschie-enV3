import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;

public abstract class Kugel extends GameField
{

	protected int velX;
	protected int velY;
	protected int w;
	protected int h;
	protected int x;
	protected int y;
	
	protected float speed;
	
	public abstract int getW();
	
	public abstract int getH();
	
	public abstract void setW(int pw);
	
	public abstract void setH(int ph);
	
	public abstract void move();
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void drawGegner(Graphics2D g2d)
	{
	}	
}
