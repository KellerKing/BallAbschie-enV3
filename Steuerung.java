import java.util.ArrayList;

public class Steuerung
{

	private final int STARTANZ = 200;

	private ArrayList<Kugel> gegner = new ArrayList<Kugel>();

	public void update(ArrayList<Kugel> arrayList)
	{
		for (Kugel a : arrayList)
		{
			a.move();
		}
	}

	public ArrayList<Kugel> getGegner()
	{
		if (gegner.size() != 0)
		{
			return gegner;
		} else
		{
			// gegner.clear();
			// init(); // Wenn die erste Init fehlsch�gt wird sie erneut ausgef�hrt
			return gegner;
		}

	}

	public void init()
	{
		for (int i = 0; i < STARTANZ; i++)
		{
			gegner.add(new Ballon());
		}
	}

}
