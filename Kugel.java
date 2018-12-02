import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;

public abstract class Kugel //extends GameField
{

	protected int w;
	protected int h;
	
	public abstract int getW();
	
	public abstract int getH();
	
	public abstract void setW();
	
	public abstract void setH();
	
	public void drawGegner(Graphics2D g2d)
	{

	}	
}
