import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Ballon extends Kugel
{
	
	private GameField zeichenboss = new GameField();
	private Steuerung manager = new Steuerung();
	
	// Groesse
	private final int W = 50;
	private final int H = 50;
	private final int radius  = 25; //TODO in superklasse nicht mit konstanten

	// Position Muss hier gesetzt werden und nicht in draw
	private int x = (int) (Math.random() * (1100 + 1)) + 1;
	private int y = (int) (Math.random() * (580 + 1)) + 1;

	// Richtung bzw. Speed
	private double velX = 1;
	private double velY = 1;
	
	//Ball Kollision
	private int xDif;
	private int yDif;
	private double kollision;
	
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
	public void ballKollision()
	{
		ArrayList<Kugel> gegner =  manager.getGegner();
		
		for(int i = 1;  i <= gegner.size(); i++)
		{
			for(int j = 0; j < gegner.size(); j++)
			{
				xDif = gegner.get(i).getX() - gegner.get(j).getX();
				yDif = gegner.get(i).getX() - gegner.get(j).getY();
				kollision = Math.sqrt(xDif * xDif + yDif * yDif);
				
				if(kollision <= gegner.get(i).getRadius() + gegner.get(j).getRadius())
				{
					System.out.println("Kollision");
				}
			}
		}
	}
	
	public double getRadius()
	{
		return radius;
	}

}
