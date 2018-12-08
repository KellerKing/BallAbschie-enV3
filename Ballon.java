import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Ballon extends Kugel
{

	private GameField zeichenboss = new GameField();
	private Steuerung manager = new Steuerung();
	
	// Groesse
	private final int W = 50;
	private final int H = 50;

	// Position Muss hier gesetzt werden und nicht in draw
	private int x = (int) (Math.random() * (1100 + 1)) + 1;
	private int y = (int) (Math.random() * (580 + 1)) + 1;

	// Richtung bzw. Speed
	private double velX = 1;
	private double velY = 1;


	@Override
	public int getW()
	{
		return W;
	}

	@Override
	public int getH()
	{
		return H;
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
	public void drawGegner(Graphics2D g2d)
	{
		super.drawGegner(g2d);


		//x und y ihren wert Updaten
		x = (int) (x + velX);
		y = (int) (y + velY);
		
		g2d.setColor(Color.red);
		g2d.fillOval(x, y, W, H);
		// repaint();

	}

	@Override
	public void move()
	{


		 /*FIXME Alg überarbeiten. Bei vielen Gegner glitcht ein Ball rum
		  * vllt mit Speed Variable die vel überschreibt ?
		  * https://www.youtube.com/watch?v=L6LFmtJynIs
		  */
		 if (x <=  0 || x + W >= zeichenboss.getWidth())
		 {
		 velX = -velX;
		 }
		
		 if (y <= 0 || y + H >= zeichenboss.getHeight() - H/2)
		 {
		 velY = -velY;
		 }
		 
		 //Kollision of 2 balls
//		 ballKollision();
	}
//	public void ballKollision()
//	{
//		ArrayList<Kugel> gegner =  manager.getGegner();
//		
//		for(int i = 0, j = 0;  i < gegner.size(); i++)
//		{
//			if(gegner.get(i).getX() && )
//		}
//	}
}
