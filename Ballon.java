import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ballon extends Kugel
{
	
	private final int W = 50;
	private final int H = 50;
	
	public Ballon()
	{
		
	}

	@Override
	public int getW()
	{
		// TODO Auto-generated method stub
		return W;
	}

	@Override
	public int getH()
	{
		// TODO Auto-generated method stub
		return H;
	}

	@Override
	public void drawGegner(Graphics2D g2d)
	{
		super.drawGegner(g2d);

		g2d.setColor(Color.red);
		g2d.fillOval(10, 10, W, H);
//		repaint();
		System.out.println("asd"); //TODO geht hier nicht rein !

	}

	@Override
	public void setW()
	{
		// TODO Auto-generated method stub
	
	}

	@Override
	public void setH()
	{
		// TODO Auto-generated method stub
		
	}

}
