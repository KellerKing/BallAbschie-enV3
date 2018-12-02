import java.util.ArrayList;

public class Steuerung 
{

	private long fps;
	private final byte STARTANZ = 10;
	private long start, dif;

	private ArrayList<Kugel> gegner = new ArrayList<Kugel>();
	
	//FIXME private GameField initS = new GameField();

	public ArrayList<Kugel> getGegner()
	{
		if (gegner.size() != 0)
		{
			return gegner;
		}
		else
		{
			System.out.println("adfasdasdas");
			return null;
		}
		
		
		
	}

	public long getFPS()
	{
		return fps;
	}

	public void init() //FIXME added irgendwie nicht richtig gegner. Denn getGegner gibt null aus.
	{

		for (int i = 0; i < STARTANZ; i++)
		{
			gegner.add(new Ballon());
		}
	}

	public void logic(long fps)
	{
	}

	public void calcFps()
	{
		dif = System.nanoTime() - start;
		start = System.nanoTime(); // Für die nächsten FPS hier als neuer anfang
		fps = ((long) 1e9 / dif);

	}

}
