import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

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

		this.x = (int) (Math.random() * (1100 + 1)) + 1;
		this.y = (int) (Math.random() * (580 + 1)) + 1;

		g2d.setColor(Color.red);
		g2d.fillOval(x, y, W, H);
		// repaint();
		System.out.println("assssssssd");

	}

	@Override
	public void setW(int pw)
	{
	}

	@Override
	public void setH(int ph)
	{
	}

	@Override
	public void move()
	{
		// TODO same mit den Konstanten wie oben
		if (this.getX() < 0 || this.getX() > (1280 - w))
		{
			velX = -velX;
		}

		if (this.getY() < 0 || this.getY() > (720 - h))
		{
			velY = -velY;
		}

		x += velX;
		y += velY;
	}
}
