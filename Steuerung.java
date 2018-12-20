import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Steuerung
{
	private final int STARTANZ = 3;
	
	private BufferedImage spriteSheet = null;
	private Cursor fK;
	

	private ArrayList<Kugel> gegner = new ArrayList<Kugel>();

	public void update(ArrayList<Kugel> arrayList)
	{
		for (Kugel a : arrayList)
		{
			a.move();
//			a.ballKollision();
		}
	}

	public ArrayList<Kugel> getGegner()
	{
			return gegner;
	}

	public void init() throws IOException
	{
		for (int i = 0; i < STARTANZ; i++)
		{
			gegner.add(new Ballon());
		}
		
		ImageLoader loader = new ImageLoader();
		spriteSheet =loader.loadImage("/Images/SpriteSheet.png");
		
		fK = new Cursor(this);
	}
	
	public BufferedImage getSpriteSheet()
	{
		return spriteSheet;
	}
	
	public Cursor getCursor()
	{
		return fK;
	}
}
