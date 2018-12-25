import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ballon extends Kugel
{
	
	private GameField zeichenboss = new GameField();
	private Steuerung manager = new Steuerung();
	private BufferedImage ballon;
	
	// Groesse
	private final int W = 32;
	private final int H = 32;

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
	
	public Ballon(Steuerung game)
	{
		this.manager = game;
		
		SpriteSheet spritesBallon = new SpriteSheet(manager.getSpriteSheet());
		ballon = spritesBallon.grabImage(2, 1, 32, 32);
	}

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
		
		g2d.drawImage(ballon, this.x, this.y, null);

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
		
		 if (y <= 0 || y + H >= zeichenboss.getHeight() - H)
		 {
		 velY = -velY;
		 }
		 
	}

	public Rectangle getBounds()
	{
		return new Rectangle(this.x, this.y, W, H);
		
	}


}
